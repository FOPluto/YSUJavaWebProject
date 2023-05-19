<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2023/5/11
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>好记记事本</title>
      <%--链接到本地的css和js文件--%>
    <link type="text/css" rel="stylesheet" href="static/css/login.css">
  </head>
  <body>
  <div class="home home-login">
      <div class="home-body-card">
          <h1>Login</h1>
          <form id="home-login-form">
              <input type="text" id="login-username" name="username" placeholder="用户名" required>
              <input type="password" id="login-password" name="password" placeholder="密码" required>
              <div class="captcha" id="login-captcha-div">
                  <input type="text" id="login-captcha" name="captcha" placeholder="输入验证码" required>
                  <div class="login-captcha-image-div" id="login-captcha-image-div">
                    <img id="login-captcha-image" src="https://via.placeholder.com/100x50" alt="验证码">
                  </div>
              </div>
              <input type="submit" value="登录">
          </form>
          <div class="home-body-card-error-info" id="login-error-info"></div>
          <div class="home-body-card-signup" id="jump-to-signup-div">没有账号？注册一个</div>
      </div>
  </div>

  </body>
</html>

<script type="text/javascript" src="static/js/login.js"></script>