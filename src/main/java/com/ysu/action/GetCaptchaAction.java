package com.ysu.action;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "getCaptche", value = "/getCapture.action")
public class GetCaptchaAction extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 50;
    private static final int FONT_SIZE = 26;
    private static final String SESSION_CAPTCHA_KEY = "captcha";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String captcha = generateCaptcha();
        HttpSession session = req.getSession();
        session.setAttribute(SESSION_CAPTCHA_KEY, captcha);
        BufferedImage image = generateCaptchaImage(captcha);
        resp.setContentType("image/png");
        ImageIO.write(image, "png", resp.getOutputStream());
        resp.setStatus(200);
    }

    /**
     * 生成验证码
     * @return String 生成的随机验证码
     */
    private String generateCaptcha(){
        Random random = new Random();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i < 4;i++){
            int index = random.nextInt(chars.length());
            stringBuilder.append(chars.charAt(index));
        }
        return stringBuilder.toString();
    }

    private BufferedImage generateCaptchaImage(String captcha) {
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();

        // 设置背景色
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        // 设置字体
        g.setFont(new Font("Arial", Font.BOLD, FONT_SIZE));
        // 填充验证码
        g.setColor(Color.BLACK);
        g.drawString(captcha, 10, 20);
        // 添加干扰线
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            g.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
            int x1 = random.nextInt(WIDTH);
            int y1 = random.nextInt(HEIGHT);
            int x2 = random.nextInt(WIDTH);
            int y2 = random.nextInt(HEIGHT);
            g.drawLine(x1, y1, x2, y2);
        }
        // 释放资源
        g.dispose();
        return image;
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
