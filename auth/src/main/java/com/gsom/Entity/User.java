package com.gsom.Entity;

import com.google.common.base.MoreObjects;
import lombok.Data;

import javax.persistence.*;
import java.sql.Array;
import java.sql.Date;
import java.sql.Timestamp;
//
//@Entity
//@Table(name = "t_user")
//@Data
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//    private String name;
//    private String password;
//    private String email;
//    private String roles;
//    private Boolean locked;
//    private Boolean expired;
//    private Boolean disabled;
//    private String oauthRegistrationId;
//    private String oauthClientId;
//    private Timestamp createdAt;
//    private Timestamp updatedAt;
//
//
//    @PrePersist
//    protected void onSave() {
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//        if (createdAt == null) {
//            createdAt = now;
//        }
//
//        updatedAt = now;
//    }
//}
//
