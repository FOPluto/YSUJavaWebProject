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
      <link type="text/css" rel="stylesheet" href="static/css/signup.css">

      <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.6.0/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/5.15.3/css/all.min.css">
  </head>
  <body>
  <div class="home">
          <div class="home-body-card">

              <div class="home-body-card-login" id="login-card">

                  <h1>Login</h1>

                  <form id="home-login-form">
                      <label for="login-username"></label><input type="text" id="login-username" name="username" placeholder="用户名" required>
                      <label for="login-password"></label><input type="password" id="login-password" name="password" placeholder="密码" required>
                      <div class="captcha" id="login-captcha-div">
                          <label for="login-captcha"></label><input type="text" id="login-captcha" name="captcha" placeholder="输入验证码" required>
                          <div class="login-captcha-image-div" id="login-captcha-image-div">
                              <img id="login-captcha-image" src="https://via.placeholder.com/100x50" alt="验证码">
                          </div>
                      </div>
                      <input type="submit" value="登录">
                  </form>

                  <div class="home-body-card-error-info" id="login-error-info"></div>
                  <div class="home-body-signup" id="jump-to-signup-div">没有账号？注册一个</div>
              </div>

              <div class="home-body-card-signup" id="signup-card">

                  <h1 class="signup-h1-txt">Signup</h1>

                  <form id="home-signup-form">
                      <label for="signup-username"></label><input type="text" id="signup-username" name="username" placeholder="用户名" required>
                      <label for="signup-password"></label><input type="password" id="signup-password" name="password" placeholder="密码" required>
                      <label for="signup-password-confirm"></label><input type="password" id="signup-password-confirm" name="confirm_password" placeholder="密码" required>
                      <div class="captcha" id="signup-captcha-div">
                          <label for="signup-captcha"></label><input type="text" id="signup-captcha" name="captcha" placeholder="输入验证码" required>
                          <div class="signup-captcha-image-div" id="signup-captcha-image-div">
                              <img id="signup-captcha-image" src="https://via.placeholder.com/100x50" alt="验证码">
                          </div>
                      </div>
                      <input class="signup-submit" type="submit" value="注册">
                  </form>

                  <div class="home-body-card-error-info" id="signup-error-info"></div>
                  <div class="home-body-signup" id="jump-to-login-div">已有账号？马上登录</div>
              </div>
          </div>
  </div>

  </body>
</html>

<script type="text/javascript" src="static/js/login.js"></script>
<script type="text/javascript" src="static/js/signup.js"></script>

<script src="https://cdn.staticfile.org/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/2.9.3/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.6.0/js/bootstrap.min.js"></script>