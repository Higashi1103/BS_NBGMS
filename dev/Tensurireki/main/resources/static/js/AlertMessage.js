$(function() {

//	const alertType = /*[[${alertType}]]*/ null;
//	const alertMsg = /*[[${alertMsg}]]*/ null;

	if (alertType) {
		showAlertModal(alertType, alertMsg);
	}

	function showAlertModal(type, message) {
		const $dialogMessage = $("#dialogMessage");
		let displayMsg = "";

		switch (type) {
			case "new":
				displayMsg = "登録できました。";
				break;
			case "update":
				displayMsg = "変更できました。";
				break;
			case "delete":
				displayMsg = "削除できました。";
				break;
			default:
				displayMsg = message || "";
				break;
		}

		$dialogMessage.text(displayMsg);
		$("#alertModal").modal("show");

		$("#confirmReturn").off("click").on("click", function() {
			window.location.href = "/tensu";
		});
	}
});
