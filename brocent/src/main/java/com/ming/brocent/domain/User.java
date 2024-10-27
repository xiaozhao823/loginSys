package com.ming.brocent.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private String userId;

    private String userName;

    private String password;

    private String email;

    private String work;

    private String street;

    private String zip;

    private String city;

    private String state;

    private String country;

    private String radio;

    private Date createTime;

    private Date updateTime;
}
