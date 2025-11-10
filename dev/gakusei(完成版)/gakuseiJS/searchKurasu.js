
    $(function () {
        /* モックボックス */
        $("#openKurasuModal").click(function () {
            $("#searchKurasuModal").modal("show");
            $("#searchKurasuNamae").val("");
            // 空文字で全員表示
            searchByKurasuNamae("");
            $("#confirmSelection").prop("disabled", true);
        });

        /* あいまい検索 */
        $("#searchKurasuNamae").on("input", function () {
            var kurasuNamae = $(this).val();
            searchByKurasuNamae(kurasuNamae);
        });

        /* Ajax検索関数 */
        function searchByKurasuNamae(kurasuNamae) {
            $.ajax({
                url: "/gakusei/searchByKurasuNamae",
                method: "GET",
                data: { kurasuNamae: kurasuNamae },
                success: function (data) {
                    $("#searchKurasuResult").empty();

                    if (data.length === 0) {
                        $("#searchKurasuResult").append("<li class='list-group-item error'>該当なし</li>");
                    } else {
                        data.forEach(function (item) {
                            $("#searchKurasuResult").append(
                                `<li class='list-group-item search-item' 
                                data-namae='${item.kurasuNamae}' 
                                data-id='${item.kurasuId}'>
                                ${item.kurasuNamae}</li>`
                            );
                        });

                        // クラス選択時の処理
                        $(".search-item").off("click").on("click", function () {
                            var selectedKurasuNamae = $(this).data("namae");
                            $("#searchKurasuNamae").val(selectedKurasuNamae);
                            $(".search-item").removeClass("selected");
                            $(this).addClass("selected");
                            $("#confirmSelection").prop("disabled", false);
                        });
                    }
                },
                error: function () {
                    $("#searchKurasuResult").html("<li class='list-group-item text-danger error'>検索エラー</li>");
                    $("#confirmSelection").prop("disabled", true);
                }
            });
        }

        /* 「確定」ボタンクリック時 → 主画面に値を反映 */
        $("#confirmSelection").on("click", function () {
            var selectedItem = $(".search-item.selected");
            if (selectedItem.length === 0) return; // 未選択なら何もしない

            // data属性から値を取得
            var selectedNamae = selectedItem.data("namae");
            var selectedId = selectedItem.data("id");

            // 主画面に値をセット
            $("#kurasuInput").val(selectedNamae);
            $("#kurasuId").val(selectedId);

            // 触发实时验证（让绿色✓立刻出现）
            $("#kurasuInput").trigger("input");

            // モーダルを閉じる
            $("#searchKurasuModal").modal("hide");
        });

    });
