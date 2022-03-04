package com.codegym.test.Entity;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @Column(name = "promotion_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "startDay")
    private Date startDay;

    @Column(name = "endDay")
    private Date endDay;

    @Column(name = "voucher")
    private String voucher;

    @Column(name="detail")
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    private String operationType;

    public Promotion(){

    }

    public Promotion(String title, Date startDay, Date endDay, String voucher) {
        this.title = title;
        this.startDay = startDay;
        this.endDay = endDay;
        this.voucher = voucher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", voucher='" + voucher + '\'' +
                '}';
    }
}
