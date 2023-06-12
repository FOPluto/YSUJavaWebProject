package com.ysu.sql;

import com.ysu.dao.User;

import java.sql.*;

public class MySqlFunction {
    // 链接数据库 返回密码
    public String findUserInfo(String username){
        String url = "jdbc:mysql://127.0.0.1:3306/ysudata";
        String sql_username = "root";
        String sql_password = "1234";

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, sql_username, sql_password);
        } catch (SQLException e) {
            System.out.println("出现异常");
            System.out.println(e);
        }

        if(conn == null) {
            System.out.println("conn为空，sql查询链接断开");
            return null;
        }

        Statement stmt = null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("创建Statement出现异常");
            System.out.println(e);
        }
        // sql语句
        String sql = "SELECT password FROM ysudata.userinfo where username='" + username + "'";

        if(stmt == null) {
            System.out.println("Statement为空，sql查询链接断开");
            return null;
        }

        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e);
        }

        if(rs == null) {
            System.out.println("Statement为空，sql查询链接断开");
            return null;
        }
        String user = null;
        try {
            if(rs.next()) {
                user = rs.getString("password");
                System.out.println(user);
            }
        } catch (SQLException e) {
            return null;
        }
        return user;
    }
    // 测试程序
//    public static void main(String[] args) {
//        MySqlFunction.findUserInfo("ysu1314");
//    }
}
