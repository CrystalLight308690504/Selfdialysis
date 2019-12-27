var name = document.getElementById("name");
var password = document.getElementById("password");
var passwordAgain = document.getElementById("passwordAgain");

function checkRegister() {
    var name_message = document.getElementById("name_message");
    var password_message = document.getElementById("password_message");
    var password_message_again = document.getElementById("password_message_again");

    /*获取注册输入的值并自动去除空格*/
    $("#name").val($.trim($("#name").val()));
    var string_name =$("#name").val() ;
    var string_password = password.value = password.value.trim();
    var string_passwordAgain = passwordAgain.value = passwordAgain.value.trim();
    if (string_name.length == 0) { // 是否写入用户名
        $("#button_register").attr("disabled",true);
        name_message.innerText = "请输入注册账号";
    } else { // 判断新密码是否符合
            name_message.innerText = "";
        if (string_password.length == 0) {
            $("#button_register").attr("disabled",true);
            password_message.innerText = "请输入密码";
        } else if (string_passwordAgain.length == 0) {
            $("#button_register").attr("disabled",true);
            password_message_again.innerText = "请再输入密码";
        } else if (string_password != string_passwordAgain) {
            $("#button_register").attr("disabled",true);
            password_message_again.innerText = "密码不一致";
            password_message.innerText = "密码不一致";
        } else {
            $("#button_register").attr("disabled",false);
            password_message.innerText = "";
            password_message_again.innerText = "";
        }
    }
}

$("#name").blur(checkRegister);
password.onblur = checkRegister;
passwordAgain.onblur = checkRegister;