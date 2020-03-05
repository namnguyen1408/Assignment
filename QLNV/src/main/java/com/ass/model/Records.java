//package com.ass.model;
//
//import javax.persistence.*;
//import java.util.Date;
//
//
//@Entity
//@Table(name = "records")
//public class Records {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;
//    private Boolean type;
//    private String reason;
//    private Date date;
//
//    public Records(){
//
//    }
//    public Records(Long id, Boolean type, String reason, Date date) {
//        this.id = id;
//        this.type = type;
//        this.reason = reason;
//        this.date = date;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Boolean getType() {
//        return type;
//    }
//
//    public void setType(Boolean type) {
//        this.type = type;
//    }
//
//    public String getReason() {
//        return reason;
//    }
//
//    public void setReason(String reason) {
//        this.reason = reason;
//    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//}
