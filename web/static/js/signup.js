let signup_captcha_img = document.getElementById("signup-captcha-image");
let signup_username = document.getElementById("signup-username");
let signup_password = document.getElementById("signup-password");
let signup_password_confirm = document.getElementById("signup-password-confirm");
let signup_captcha = document.getElementById("signup-captcha");
let signup_captcha_box = document.getElementById("signup-captcha-image-div");
let signup_form = document.getElementById("home-signup-form");
let error_box = document.getElementById("signup-error-info");

let login_card = document.getElementById("login-card");
let signup_card = document.getElementById("signup-card");

let jump_to_login = document.getElementById("jump-to-login-div");

function get_captcha_func() {
    const captcha_url = 'http://localhost:8080/Javaweb_project_war_exploded/getCapture.action';
    const xrl_captcha = new XMLHttpRequest();
    xrl_captcha.responseType = 'blob';
    xrl_captcha.onload = function () {
        if (xrl_captcha.readyState === 4 && xrl_captcha.status === 200) {
            // 处理服务器返回的数据
            signup_captcha_img.src = window.URL.createObjectURL(xrl_captcha.response);
        }
    };
    xrl_captcha.open('GET', captcha_url, true);
    xrl_captcha.send();
}
// 获取验证码函数
get_captcha_func();
// 点击图片重新生成新的验证码
signup_captcha_box.addEventListener('click', function (event){
    get_captcha_func();
});


signup_form.addEventListener('submit', function(event) {
    event.preventDefault();
    error_box.innerHTML = "";
    const username = signup_form.elements.username.value;
    const password = signup_form.elements.password.value;
    const password_confirm = signup_password_confirm.value;
    const captcha = captcha_context.value;
    console.log(username);
    console.log(password);
    console.log(captcha);
    if(username.toString().length < 5){
        error_box.innerHTML = "用户名太短，最少5位";
    } else if(username.toString().length > 18){
        error_box.innerHTML = "用户名太长，最多18位";
    } else if(password.toString().length < 8){
        error_box.innerHTML = "密码太短，最少8位";
    } else if(password.toString().length > 20){
        error_box.innerHTML = "密码太长，最多20位";
    } else if(captcha.toString().length !== 4) {
        error_box.innerHTML = "验证码长度为4位";
    } else if(password !== password_confirm) {
        error_box.innerHTML = "两次输入密码不相同";
    } else {
        const data = 'username=' + encodeURIComponent(username) + '&password=' + encodeURIComponent(password);
        const xhr = new XMLHttpRequest();
        const url = 'http://localhost:8080/Javaweb_project_war_exploded/login.action';
        xhr.open('GET', url);
        xhr.setRequestHeader('username', username);
        xhr.setRequestHeader("password", password);
        xhr.setRequestHeader("captcha", captcha);
        xhr.send(data);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                console.log(xhr.responseText);
                error_box.innerHTML = "";
                // 处理服务器返回的数据
            } else {
                error_box.innerHTML = xhr.getResponseHeader("error_info");
            }
        };
    }
});


jump_to_login.addEventListener('click', function () {
    login_card.style.display = "block";
    signup_card.style.display = "none"
    signup_card.style.transform = "size()";
    login_card.style.right = '-100%';
    login_card.style.transition = 'right 0.5s ease-in-out';
    signup_card.style.left = '0';
});