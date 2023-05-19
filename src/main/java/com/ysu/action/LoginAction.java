package com.ysu.action;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(name = "login-servlet", value = "/login.action")
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-type","text/html;charset=utf-8");
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getHeader("username");
        String password = req.getHeader("password");
        String captcha = req.getHeader("captcha");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("captcha:  " + captcha);
        HttpSession session = req.getSession();
        System.out.println(session.getAttribute("captcha"));
        if(captcha.equals(session.getAttribute("captcha"))){

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
