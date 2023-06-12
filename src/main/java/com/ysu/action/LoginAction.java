package com.ysu.action;

import com.ysu.sql.MySqlFunction;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "login-servlet", value = "/login.action")
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8"); // 设置响应类型和编码方式
        String username = req.getHeader("username");
        String password = req.getHeader("password");
        String captcha = req.getHeader("captcha");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("captcha:  " + captcha);
        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("captcha"));

        // 判断验证码和用户是否存在
        if(!captcha.equals(session.getAttribute("captcha"))){
            resp.setStatus(203);
            resp.setHeader("error_info", "captcha error");
            return;
        } else {
            // 查询用户信息
            MySqlFunction mySqlFunction = new MySqlFunction();
            String userInfo = mySqlFunction.findUserInfo(username);
            if(userInfo == null) {
                resp.setStatus(203);
                resp.setHeader("error_info", "user not exist");
            } else if(!userInfo.equals(password)){
                resp.setStatus(203);
                resp.setHeader("error_info", "password error");
            } else {
                resp.setStatus(200);
                // 登录成功后设置 Cookie
                Cookie cookie = new Cookie("username", "your_username_here");
                cookie.setMaxAge(24 * 60 * 60); // 设置 Cookie 的有效期为 1 天
                resp.addCookie(cookie);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
