const form = document.getElementById("home-login-form");
let error_box = document.getElementById("login-error-info");
let captcha_box = document.getElementById("login-captcha");
form.addEventListener('submit', function(event) {
    event.preventDefault();
    error_box.innerHTML = "";
    const username = form.elements.username.value;
    const password = form.elements.password.value;
    const captcha = captcha_box.value;
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
    } else if(captcha.toString().length != 4) {
        error_box.innerHTML = "验证码长度为4位";
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
                // 处理服务器返回的数据
            }
        };
    }
});