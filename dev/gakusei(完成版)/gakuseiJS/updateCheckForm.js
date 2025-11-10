
    $(function () {
        $('#overlay').hide();

        // 学生内容チェック
        $('#name').blur(function () {
            $('#nameError').text('');
            const name = $('#name').val().trim();
            if (name === '') {
                $('#nameError').text('名前を入力してください').css('color', 'red');
                $('#name').addClass('has-error').removeClass('has-success');
                return;
            }
            if (name.length > 6) {
                $('#nameError').text('名前は6文字以内で入力してください').css('color', 'red');
                $('#name').addClass('has-error').removeClass('has-success');
            } else {
                $('#nameError').text('✓').css('color', 'green');
                $('#name').addClass('has-success').removeClass('has-error');
            }
        });
        // 实时输入验证 内容无误就清楚红色提示
        $('#name').on('input', function () {
            const max = 6;                          // ★ 与 maxlength 保持一致
            const count = $(this).val().length;      // ★ 当前字数
            $('#nameCount').text('<' + count + '/' + max + '>');  // ★ 更新计数

            const name = $(this).val().trim();
            if (name === '') {
                $('#nameError').text('');
                $(this).removeClass('has-error has-success');
            } else if (name.length > 6) {
                $('#nameError').text('名前は6文字以内で入力してください').css('color', 'red');
                $(this).addClass('has-error').removeClass('has-success');
            } else {
                $('#nameError').text('✓').css('color', 'green');
                $(this).addClass('has-success').removeClass('has-error');
            }
        });

        // 性別内容チェック
        $('#gender').blur(function () {
            $('#genderError').text('');
            const gender = $('#gender').val().trim();
            if (gender === '') {
                $('#genderError').text('性別を選択してください').css('color', 'red');
                $('#gender').addClass('has-error').removeClass('has-success');
                return;
            }
            if (gender !== '男' && gender !== '女') {
                $('#genderError').text('「男」または「女」を選択してください').css('color', 'red');
                $('#gender').addClass('has-error').removeClass('has-success');
            } else {
                $('#genderError').text('✓').css('color', 'green');
                $('#gender').addClass('has-success').removeClass('has-error');
            }
        });
        // 实时输入验证 内容无误就清楚红色提示
        $('#gender').on('change input', function () {
            const gender = $(this).val().trim();
            if (gender === '') {
                $('#genderError').text('');
                $(this).removeClass('has-error has-success');
            } else if (gender !== '男' && gender !== '女') {
                $('#genderError').text('「男」または「女」を選択してください').css('color', 'red');
                $(this).addClass('has-error').removeClass('has-success');
            } else {
                $('#genderError').text('✓').css('color', 'green');
                $(this).addClass('has-success').removeClass('has-error');
            }
        });

        // 生年月日チェック（YYYY/MM/DD形式）
        $('#birthday').blur(function () {
            $('#birthdayError').text('');
            let birthday = $('#birthday').val().trim();
            const dateRegex1 = /^\d{4}\/\d{2}\/\d{2}$/; // YYYY/MM/DD
            const dateRegex2 = /^\d{8}$/;               // YYYYMMDD
            if (birthday === '') {
                $('#birthdayError').text('生年月日を入力してください').css('color', 'red');
                $('#birthday').addClass('has-error').removeClass('has-success');
                return;
            }
            if (dateRegex2.test(birthday)) {
                // 自动修正 19990101 → 1999/01/01
                birthday = birthday.slice(0, 4) + '/' + birthday.slice(4, 6) + '/' + birthday.slice(6);
                $('#birthday').val(birthday);
            }
            if (dateRegex1.test(birthday)) {
                const [year, month, day] = birthday.split('/').map(Number);
                const date = new Date(year, month - 1, day);

                // 存在する日付か確認
                if (date.getFullYear() === year &&
                    date.getMonth() === month - 1 &&
                    date.getDate() === day) {
                    $('#birthdayError').text('✓').css('color', 'green');
                    $('#birthday').addClass('has-success').removeClass('has-error');
                } else {
                    $('#birthdayError').text('存在しない日付です').css('color', 'red');
                    $('#birthday').addClass('has-error').removeClass('has-success');
                }
            } else {
                // 形式不正
                $('#birthdayError').text('YYYY/MM/DD形式で入力してください').css('color', 'red');
                $('#birthday').addClass('has-error').removeClass('has-success');
            }
        });
        // 实时输入验证 内容无误就清楚红色提示
        $('#birthday').on('input', function () {
            const max = 10; // YYYY/MM/DD 为10字符
            const count = $(this).val().length;
            $('#birthdayCount').text('<' + count + '/' + max + '>');

            let birthday = $(this).val().trim();
            const dateRegex1 = /^\d{4}\/\d{2}\/\d{2}$/;
            const dateRegex2 = /^\d{8}$/;

            if (birthday === '') {
                $('#birthdayError').text('');
                $(this).removeClass('has-error has-success');
                return;
            }

            if (dateRegex2.test(birthday)) {
                birthday = birthday.slice(0, 4) + '/' + birthday.slice(4, 6) + '/' + birthday.slice(6);
                $(this).val(birthday);
            }

            if (dateRegex1.test(birthday)) {
                const [year, month, day] = birthday.split('/').map(Number);
                const date = new Date(year, month - 1, day);
                if (date.getFullYear() === year && date.getMonth() === month - 1 && date.getDate() === day) {
                    $('#birthdayError').text('✓').css('color', 'green');
                    $(this).addClass('has-success').removeClass('has-error');
                } else {
                    $('#birthdayError').text('存在しない日付です').css('color', 'red');
                    $(this).addClass('has-error').removeClass('has-success');
                }
            } else {
                $('#birthdayError').text('YYYY/MM/DD形式で入力してください').css('color', 'red');
                $(this).addClass('has-error').removeClass('has-success');
            }
        });

        // 最終学歴チェック
        $('#education').blur(function () {
            $('#educationError').text('');
            const education = $('#education').val().trim();
            if (education === '') {
                $('#educationError').text('最終学歴を選択してください').css('color', 'red');
                $('#education').addClass('has-error').removeClass('has-success');
                return;
            } else {
                $('#educationError').text('✓').css('color', 'green');
                $('#education').addClass('has-success').removeClass('has-error');
            }
        });
        // 实时输入验证 内容无误就清楚红色提示
        $('#education').on('change input', function () {
            const education = $(this).val().trim();
            if (education === '') {
                $('#educationError').text('');
                $(this).removeClass('has-error has-success');
            } else {
                $('#educationError').text('✓').css('color', 'green');
                $(this).addClass('has-success').removeClass('has-error');
            }
        });

        // 語学力チェック
        $('#languagelevel').blur(function () {
            $('#languagelevelError').text('');
            const languagelevel = $('#languagelevel').val().trim();
            if (languagelevel === '') {
                $('#languagelevelError').text('語学力を選択してください').css('color', 'red');
                $('#languagelevel').addClass('has-error').removeClass('has-success');
                return;
            } else {
                $('#languagelevelError').text('✓').css('color', 'green');
                $('#languagelevel').addClass('has-success').removeClass('has-error');
            }
        });
        // 实时输入验证 内容无误就清楚红色提示
        $('#languagelevel').on('change input', function () {
            const languagelevel = $(this).val().trim();
            if (languagelevel === '') {
                $('#languagelevelError').text('');
                $(this).removeClass('has-error has-success');
            } else {
                $('#languagelevelError').text('✓').css('color', 'green');
                $(this).addClass('has-success').removeClass('has-error');
            }
        });

        // 点数チェック
        $('#score').blur(function () {
            $('#scoreError').text('');
            const score = $('#score').val().trim();
            if (score === '') {
                $('#scoreError').text('点数を入力してください').css('color', 'red');
                $('#score').addClass('has-error').removeClass('has-success');
                return;
            }
            if (isNaN(score)) {
                $('#scoreError').text('数値で入力してください').css('color', 'red');
                $('#score').addClass('has-error').removeClass('has-success');
            } else {
                $('#scoreError').text('✓').css('color', 'green');
                $('#score').addClass('has-success').removeClass('has-error');
            }
        });
        // 实时输入验证 内容无误就清楚红色提示
        $('#score').on('input', function () {
            const score = $(this).val().trim();
            if (score === '') {
                $('#scoreError').text('');
                $(this).removeClass('has-error has-success');
            } else if (isNaN(score)) {
                $('#scoreError').text('数値で入力してください').css('color', 'red');
                $(this).addClass('has-error').removeClass('has-success');
            } else {
                $('#scoreError').text('✓').css('color', 'green');
                $(this).addClass('has-success').removeClass('has-error');
            }
        });

        // ==================== 評価チェック ====================
        $('#evaluation').blur(function () {
            $('#evaluationError').text('');
            const evaluation = $('#evaluation').val().trim();
            if (evaluation.length > 100) {
                $('#evaluationError').text('100文字以内で入力してください').css('color', 'red');
                $('#evaluation').addClass('has-error').removeClass('has-success');
            } else if (evaluation === '') {
                // 空白允许输入，可不提示错误，只清空状态
                $('#evaluationError').text('');
                $('#evaluation').removeClass('has-error has-success');
            } else {
                $('#evaluationError').text('✓').css('color', 'green');
                $('#evaluation').addClass('has-success').removeClass('has-error');
            }
        });
        // 实时输入验证 内容无误就清楚红色提示 + 实时计数
        $('#evaluation').on('input', function () {
            const max = 100;                          // ★ 与 maxlength 保持一致
            const count = $(this).val().length;      // ★ 当前字数
            $('#evaluationCount').text('<' + count + '/' + max + '>');  // ★ 更新计数

            const evaluation = $(this).val().trim();
            if (evaluation.length > max) {
                $('#evaluationError').text('100文字以内で入力してください').css('color', 'red');
                $(this).addClass('has-error').removeClass('has-success');
            } else if (evaluation === '') {
                $('#evaluationError').text('');
                $(this).removeClass('has-error has-success');
            } else {
                $('#evaluationError').text('✓').css('color', 'green');
                $(this).addClass('has-success').removeClass('has-error');
            }
        });

        // ==================== 備考チェック ====================
        $('#other').blur(function () {
            $('#otherError').text('');
            const other = $('#other').val().trim();
            if (other.length > 100) {
                $('#otherError').text('100文字以内で入力してください').css('color', 'red');
                $('#other').addClass('has-error').removeClass('has-success');
            } else if (other === '') {
                // 空白允许输入，不提示错误
                $('#otherError').text('');
                $('#other').removeClass('has-error has-success');
            } else {
                $('#otherError').text('✓').css('color', 'green');
                $('#other').addClass('has-success').removeClass('has-error');
            }
        });
        // 实时输入验证 内容无误就清楚红色提示 + 实时计数
        $('#other').on('input', function () {
            const max = 100;                          // ★ 与 maxlength 保持一致
            const count = $(this).val().length;       // ★ 当前字数
            $('#otherCount').text('<' + count + '/' + max + '>');  // ★ 更新计数

            const other = $(this).val().trim();
            if (other.length > max) {
                $('#otherError').text('100文字以内で入力してください').css('color', 'red');
                $(this).addClass('has-error').removeClass('has-success');
            } else if (other === '') {
                $('#otherError').text('');
                $(this).removeClass('has-error has-success');
            } else {
                $('#otherError').text('✓').css('color', 'green');
                $(this).addClass('has-success').removeClass('has-error');
            }
        });

    });
