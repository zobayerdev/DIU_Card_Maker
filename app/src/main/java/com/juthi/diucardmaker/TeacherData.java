package com.juthi.diucardmaker;

public class TeacherData {

    private String name, designation, mobile, email,  key;

    public TeacherData() {
    }

    public TeacherData(String name, String designation, String mobile, String email, String key) {
        this.name = name;
        this.designation = designation;
        this.mobile = mobile;
        this.email = email;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
