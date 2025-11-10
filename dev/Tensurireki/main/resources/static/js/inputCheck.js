function inputCheck() {
    
    let isValid = true;
    $("#msg1, #msg2").text("");
    $("#gakuseiFormGroup").removeClass("has-error has-warning has-success");
    $("#kagenFormGroup").removeClass("has-error has-warning has-success");

    /* 学生IDチェック */
    const gakuseiId = $("#gakuseiIdInput").val() || $("#newGakuseiId").val();
    if (!gakuseiId) {
        $("#msg1").text("学生名前を選択してください。");
        $("#gakuseiFormGroup").addClass("has-error");
        isValid = false;
        return false;
    } else {
        $("#gakuseiFormGroup").addClass("has-success");
    }

    /* 加減点数チェック */
    let kagen = $("#kagenTensuInput").val().trim();

    /* 全角を半角に変換 */
    kagen = kagen.replace("＋", "+").replace("－", "-");
    kagen = kagen.replace(/[０-９]/g, s => String.fromCharCode(s.charCodeAt(0) - 0xFEE0));

    const hasSign = /^[+-]/.test(kagen);
    const numPart = hasSign ? kagen.substring(1) : kagen;
    const numOk = /^([+-]?[1-9][0-9]?)$/.test(numPart);

    let msg2 = "";
    if (hasSign && numOk) {
        msg2 = "";
        $("#kagenFormGroup").addClass("has-success");
    } else if (hasSign && !numOk) {
        msg2 = "数字部分が不正です。1〜99の整数で入力してください。";
        $("#kagenFormGroup").addClass("has-warning");
        isValid = false;
    } else if (!hasSign && numOk) {
        msg2 = "先頭に「+」または「-」を付けてください。";
        $("#kagenFormGroup").addClass("has-warning");
        isValid = false;
    } else {
        msg2 = "形式が不正です。「+5」や「-2」のように入力してください。";
        $("#kagenFormGroup").addClass("has-error");
        isValid = false;
    }
    $("#msg2").text(msg2);

    return isValid;
}
