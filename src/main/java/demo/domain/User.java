package demo.domain;

import java.io.Serializable;

/**
 * Project: demo-springboot-docker
 * Author: tomoya
 * Date: 7/23/2017
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    private String phoneNo;

    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name + "(" + email + ")";
    }
}
