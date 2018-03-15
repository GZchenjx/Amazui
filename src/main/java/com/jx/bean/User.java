package com.jx.bean;

/**
 * Created by Administrator on 2018/1/31.
 */
public class User {
    private Integer id;
    private String email;
    private String pwd;
    private String name;
    private String phone;
    private String qq;
    private String twitter;
    private String intro;

    public User() {
    }

    public User(Integer id, String email, String pwd, String name, String phone, String qq, String twitter, String intro) {
        this.id = id;
        this.email = email;
        this.pwd = pwd;
        this.name = name;
        this.phone = phone;
        this.qq = qq;
        this.twitter = twitter;
        this.intro = intro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                ", twitter='" + twitter + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }
}
