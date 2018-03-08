package com.agarwal.ashi.adminapp;

/**
 * Created by Ashi on 21-01-2018.
 */

public class FirebaseSend {
    String fullname;
    String branch;
    String sapid;
    String phone;
    String email;
    String semester;
    String events;

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setSapid(String sapid) {
        this.sapid = sapid;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public void setAcm(String acm) {
        this.acm = acm;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public void setSend(String send) {
        this.send = send;
    }

    String acm;
    String paymode;
    String amount;
    String transaction;

    public FirebaseSend() {

    }

    String send;
    public FirebaseSend(String fullname, String branch, String sapid, String phone, String email, String semester, String events, String acm, String paymode, String amount, String transaction, String send) {
        this.fullname = fullname;
        this.branch = branch;
        this.sapid = sapid;
        this.phone = phone;
        this.email = email;
        this.semester = semester;
        this.events = events;
        this.acm = acm;
        this.paymode = paymode;
        this.amount = amount;
        this.transaction = transaction;
        this.send = send;
    }

    public String getSend() {
        return send;
    }

    public String getFullname() {
        return fullname;
    }

    public String getBranch() {
        return branch;
    }

    public String getSapid() {
        return sapid;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getSemester() {
        return semester;
    }

    public String getEvents() {
        return events;
    }

    public String getAcm() {
        return acm;
    }

    public String getPaymode() {
        return paymode;
    }

    public String getAmount() {
        return amount;
    }

    public String getTransaction() {
        return transaction;
    }
}
