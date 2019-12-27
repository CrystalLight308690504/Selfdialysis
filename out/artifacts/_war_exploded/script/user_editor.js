var oldPassword = document.getElementById("oldPassword");
var password = document.getElementById("password");
var passwordAgain = document.getElementById("passwordAgain");

function checkEditor() {
    var old_password_message = document.getElementById("old_password_message");
    var password_message = document.getElementById("password_message");
    var password_message_again = document.getElementById("password_message_again");

    //获取表单的值
    var string_oldPassword =oldPassword.value = oldPassword.value.trim();
    var string_password = password.value = password.value.trim();
    var string_passwordAgain = passwordAgain.value = passwordAgain.value.trim();
    if (string_oldPassword.length == 0) { // 是否输入原密码
        $("#button_editor").attr("disabled",true);
        old_password_message.innerText = "请输入原密码";
    } else { // 验证用户新密码
        old_password_message.innerText = "";
        if (string_password.length == 0) {
            $("#button_editor").attr("disabled",true);
            password_message.innerText = "请输入密码";
        } else if (string_passwordAgain.length == 0) {
            $("#button_editor").attr("disabled",true);
            password_message_again.innerText = "请输入密码";
        } else if (string_passwordAgain != string_password) {
            $("#button_editor").attr("disabled",true);
            password_message_again.innerText = "密码不一致";
            password_message.innerText = "密码不一致";
        } else {
            $("#button_editor").attr("disabled",false);
            password_message.innerText = "";
            password_message_again.innerText = "";
        }
    }


}
oldPassword.onblur = checkEditor;
password.onblur = checkEditor;
passwordAgain.onblur = checkEditor;