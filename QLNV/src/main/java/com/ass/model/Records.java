package com.ass.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "records")
public class Records {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String type;
    private String reason;
    private String date;

    @ManyToOne
    @JoinColumn(name = "staffs_id")
    private Staffs staffs;

    public Records() {
    }
    public Records(Long id, String  type,String reason, String date) {
        this.id= id;
        this.type = type;
        this.reason = reason;
        this.date= date;


    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Records{" +
                "id=" + id +
                ", type=" + type +
                ", reason='" + reason + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public Staffs getStaffs() {
        return staffs;
    }

    public void setStaffs(Staffs staffs) {
        this.staffs = staffs;
    }
}
