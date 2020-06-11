package com.springmvc.entity;

import java.sql.Date;

public class Inbound {

    private String inboundReceipt;
    private Date inboundDate;
    private String supplier;
    private String recorder;
    private String reviewer;
    private String price;
    private String remark;

    public String getInboundReceipt() {
        return inboundReceipt;
    }

    public void setInboundReceipt(String inboundReceipt) {
        this.inboundReceipt = inboundReceipt;
    }

    public Date getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(Date inboundDate) {
        this.inboundDate = inboundDate;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getRecorder() {
        return recorder;
    }

    public void setRecorder(String recorder) {
        this.recorder = recorder;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Inbound{" +
                "inboundReceipt='" + inboundReceipt + '\'' +
                ", inboundDate=" + inboundDate +
                ", supplier='" + supplier + '\'' +
                ", recorder='" + recorder + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", price='" + price + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
