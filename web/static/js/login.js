const form = document.getElementById("home-login-form");
form.addEventListener('submit', function(event) {
    event.preventDefault();
    const xhr = new XMLHttpRequest();
    const url = 'http://example.com/login'; // 修改为服务器端处理数据的 URL
    const username = form.elements.username.value;
    const password = form.elements.password.value;
    console.log(username);
    console.log(password);
    const data = 'username=' + encodeURIComponent(username) + '&password=' + encodeURIComponent(password);

    xhr.open('POST', url);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            console.log(xhr.responseText);
            location.reload();
            // 处理服务器返回的数据
        }
    };
    xhr.send(data);
});