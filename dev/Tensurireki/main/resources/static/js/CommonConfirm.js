$(function() {

	/* ページ判定 */
	const isHenkoPage = $("#updateForm").length > 0;
	const isShinkiPage = $("#shinkiForm").length > 0;
	const isShousaiPage = $("#deleteBtn").length > 0;

	console.log("現在のページ:", isHenkoPage ? "変更ページ" : (isShinkiPage ? "新規ページ" : (isShousaiPage ? "詳細ページ" : "不明")));

	/* 学生選択モーダル */
	$("#confirmSelection").click(function() {
		const selected = $(".search-item.selected");
		if (selected.length === 0) {
			alert("学生を選択してください。");
			return;
		}

		const selectedName = selected.data("namae");
		const selectedId = selected.data("id");

		$("#namaeInput").val(selectedName);
		if ($("#gakuseiIdInput").length) $("#gakuseiIdInput").val(selectedId);
		if ($("#oldGakuseiId").length) $("#oldGakuseiId").val(selectedId);
		if ($("#newGakuseiId").length) $("#newGakuseiId").val(selectedId);

		$("#searchModal").modal("hide");
	});

	/* 共通：モーダル内容セット関数 */
	function setConfirmModal(title, actionType) {
		$(".modal-title").text(title);

		const namae = $("#namaeInput").val() || "（未入力）";
		const kagen = $("input[name='kagenTensu']").val() || $("#kagenTensuInput").val() || "（未入力）";
		const riyuText = $("#gutaiRiyuSelect").is("select")
			? $("#gutaiRiyuSelect option:selected").text()
			: $("#gutaiRiyuSelect").val() || "（未選択）";
		const riyuId = $("#gutaiRiyuSelect").val();
		const hasseiBi = $("#hasseiBiInput").val() || "（未入力）";

		$("#riyuIdInput").val(riyuId);

		$("#confirmNamae").text(namae);
		$("#confirmKagen").text(kagen);
		$("#confirmRiyu").text(riyuText);
		$("#confirmHasseiBi").text(hasseiBi);
		$("#confirmModal").data("action", actionType); // 操作タイプ保存
	}

	/* 新規・変更ボタンクリック時 */
	$("#openConfirmModal").on("click", function() {
		if (!inputCheck()) return;
		const title = isHenkoPage ? "変更内容の確認" : "新規内容の確認";
		setConfirmModal(title, isHenkoPage ? "update" : "insert");
		$("#confirmModal").modal("show");
	});

	/* 削除ボタンクリック時（詳細画面用） */
	$("#deleteBtn").on("click", function() {
		const title = "削除内容の確認";
		setConfirmModal(title, "delete");
		const rirekiId = $(this).data("rireki-id");
		$("#confirmModal").data("action", "delete");
		$("#confirmModal").data("rirekiId", rirekiId);
		$("#confirmModal").modal("show");
	});

	/* 共通：確定ボタンクリック */
	$("#confirmSubmit").on("click", function() {
		const actionType = $("#confirmModal").data("action");
		const rirekiId = $("#confirmModal").data("rirekiId");

		if (actionType === "insert" && isShinkiPage) {
			$("#shinkiForm").submit();
		} else if (actionType === "update" && isHenkoPage) {
			$("#updateForm").submit();
		}else if (actionType === "delete" && isShousaiPage) {
			$("#deleteRirekiId").val(rirekiId);
			$("#deleteForm").submit();
		} else {
			alert("不明な操作タイプです。");
		}

		$("#confirmModal").modal("hide");
	});
});
