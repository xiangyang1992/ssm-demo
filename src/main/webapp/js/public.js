/**
 * 为空校验
 */
function isNull(obj) {
    if (obj == null && obj == undefined && obj.trim()=="") {
        return true
    }
    return false
}
/**
 * 参数长度验证
 */
function validLength(obj,length) {
    if (obj.trim().length <length) {
        return true
    }
    return false
}

/**
 * 用户名称验证 4到16位（字母，数字，下划线，减号）
 */
function validUserName(userName) {
    var pattern = /^[a-zA-Z0-9_-]{4,16}$/;
    if (pattern.test(userName.trim())) {
        return true;
    }else {
        return false;
    }
}
function validPassword(password) {
    var pattern = /^[a-zA-Z0-9]{6,20}$/;
    if (pattern.test(password.trim())) {
        return true;
    }else {
        return false;
    }
}


function login() {
    var userName = $("#username").val();
    var password = $("#password").val();
    if (isNull(userName)) {
        showErrorInfo("请输入用户名！");
        return;
    }
    if (!validUserName(userName)) {
        showErrorInfo("请输入正确的用户名!");
        return;
    }
    if (!validPassword(password)) {
        showErrorInfo("密码错误！")
        return;
    }
    if (isNull(password)) {
        showErrorInfo("请输入密码！")
        return;
    }

    var data = {"userName": userName, "password": password};
    $.ajax({
        type: "post",
        dataType: 'json',
        url: 'user/login.do',
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success:function (result) {
            if (result.resultCode === 200) {
                $(".alert-danger").css("display","block");
                setCookie("token", result.data.userToken);
                alert("登陆成功！")
                window.location.href = "/";
            }
        }
    });
}


function showErrorInfo(info) {
    $(".alert-danger").css("display","block");
    $(".alert-danger").html(info);
}


function setCookie(name,value) {
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";
    
}