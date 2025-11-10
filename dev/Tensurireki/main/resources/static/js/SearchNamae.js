$(function() {
	/* モックボックス */
	$("#openSearchModal").click(function() {
		$("#searchModal").modal("show");
		$("#searchNamae").val("");
		// 空文字で全員表示
		searchByNamae("");
		$("#confirmSelection").prop("disabled", true);
	});

	/* あいまい検索 */
	$("#searchNamae").on("input", function() {
		var namae = $(this).val();
		searchByNamae(namae);
	});

	/* Ajax検索関数 */
	function searchByNamae(namae) {
		$.ajax({
			url: "/tensushousaihenko/searchByNamae",
			method: "GET",
			data: { namae: namae },
			success: function(data) {
				$("#searchResult").empty();

				if (data.length === 0) {
					$("#searchResult").append("<li class='list-group-item error'>該当なし</li>");
				} else {
					data.forEach(function(item) {
						$("#searchResult").append(
							`<li class='list-group-item search-item' 
                                data-namae='${item.namae}' 
                                data-id='${item.gakuseiId}'
                                data-kurasuNamae='${item.kurasuNamae|| "未登録"}'
                                data-rireki='${item.rirekiId || ""}'>
                                ${item.namae}（学生ID: ${item.gakuseiId}）（クラス所属: ${item.kurasuNamae|| "未登録"}）</li>`
						);
					});

					// 学生選択時の処理
					$(".search-item").off("click").on("click", function() {
						var selectedNamae = $(this).data("namae");
						$("#searchNamae").val(selectedNamae);  
						$(".search-item").removeClass("selected");
						$(this).addClass("selected");
						$("#confirmSelection").prop("disabled", false);
					});
				}
			},
			error: function() {
				$("#searchResult").html("<li class='list-group-item text-danger error'>検索エラー</li>");
				$("#confirmSelection").prop("disabled", true);
			}
		});
	}

	//	/* 検索結果にクリックイベントをバインドする */
	//	$("#confirmSelection").click(function() {
	//		const selected = $(".search-item.selected");
	//		if (selected.length === 0) {
	//			alert("学生を選択してください。");
	//			return;
	//		}
	//
	//		const selectedName = selected.data("namae");
	//		const selectedId = selected.data("id");
	//
	//		/* 共通：名前入力欄にセット */
	//		$("#namaeInput").val(selectedName);
	//
	//		if ($("#gakuseiIdInput").length) {
	//			/*新規ページ*/
	//			if (selectedId) {
	//				$("#gakuseiIdInput").val(selectedId);
	//			}
	//		}
	//
	//		if ($("#oldGakuseiId").length && $("#newGakuseiId").length) {
	//			/* 編集ページ */
	//			if (selectedId) {
	//				/* 選択あり */
	//				$("#oldGakuseiId").val(selectedId);
	//				$("#newGakuseiId").val(selectedId);
	//			}
	//		}
	//
	//		/*モックボックスを閉じる*/
	//		setTimeout(() => {
	//			$("#searchModal").modal("hide");
	//		}, 500);
	//	});
});

