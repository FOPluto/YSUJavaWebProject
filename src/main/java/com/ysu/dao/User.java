package com.ysu.dao;

public class User {
    private String password;
    private String username;
    private int age;
    private int flag;

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public int getFlag() {
        return flag;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", flag=" + flag +
                '}';
    }

    public User(String password, String username, int age, int flag) {
        this.password = password;
        this.username = username;
        this.age = age;
        this.flag = flag;
    }

    public User(){
        this.password = "";
        this.username = "";
    }
}
