package com.work.pinkweb.Entity;

public class Admin {
    private Integer admin_id;
    private Integer admin_pwd;
    private String admin_name;
    private Integer admin_power;

    public Admin(Integer admin_id, Integer admin_pwd, String admin_name, Integer admin_power) {
        this.admin_id = admin_id;
        this.admin_pwd = admin_pwd;
        this.admin_name = admin_name;
        this.admin_power = admin_power;
    }

    public Integer getAdmin_pwd() {
        return admin_pwd;
    }

    public void setAdmin_pwd(Integer admin_pwd) {
        this.admin_pwd = admin_pwd;
    }

    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public Integer getAdmin_power() {
        return admin_power;
    }

    public void setAdmin_power(int admin_power) {
        this.admin_power = admin_power;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "admin_id=" + admin_id +
                ", admin_pwd=" + admin_pwd +
                ", admin_name='" + admin_name + '\'' +
                ", admin_power=" + admin_power +
                '}';
    }
}
