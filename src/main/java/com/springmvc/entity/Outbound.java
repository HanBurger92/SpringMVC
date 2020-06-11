package com.springmvc.entity;

import java.sql.Date;

public class Outbound {

    private String outboundReceipt;
    private Date outboundDate;
    private String supplier;
    private String recorder;
    private String reviewer;
    private String price;
    private String remark;

    public String getOutboundReceipt() {
        return outboundReceipt;
    }

    public void setOutboundReceipt(String outboundReceipt) {
        this.outboundReceipt = outboundReceipt;
    }

    public Date getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(Date outboundDate) {
        this.outboundDate = outboundDate;
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
        return "Outbound{" +
                "outboundReceipt='" + outboundReceipt + '\'' +
                ", outboundDate=" + outboundDate +
                ", supplier='" + supplier + '\'' +
                ", recorder='" + recorder + '\'' +
                ", reviewer='" + reviewer + '\'' +
                ", price='" + price + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
