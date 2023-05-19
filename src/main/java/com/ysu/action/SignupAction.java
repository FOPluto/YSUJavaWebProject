package com.ysu.action;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "signup-action", value = "/signup.action")
public class SignupAction extends HttpServlet {
    public static final int ERROR = 422;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password_confirm = req.getParameter("password-confirm");
        if(!password.equals(password_confirm)){
            resp.setStatus(ERROR);
            resp.setHeader("error-information", "password-error");
        } else {
            resp.setStatus(200);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
