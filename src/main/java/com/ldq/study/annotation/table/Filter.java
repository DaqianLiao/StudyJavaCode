package com.ldq.study.annotation.table;



/**
 * Created by diligent_leo on 2016/12/24.
 */
@Table(name = "user")
public class Filter {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_name")
    private int id;

    @Column(name = "user_name")
    private String email;

    @Column(name = "user_name")
    private String nickName;

    @Column(name = "user_name")
    private int age;

    @Column(name = "user_name")
    private String city;

    @Column(name = "user_name")
    private String mobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
