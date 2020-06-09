package com.springmvc.entity;

import org.springframework.stereotype.Repository;

@Repository("consumer")
public class Consumer {

    private String consumerCode; // primary key
    private String consumerName;
    private String consumerAddress;
    private String contactNumber;
    private String faxNumber;
    private String linkman;
    private String remark;

    public String getConsumerCode() {
        return consumerCode;
    }

    public void setConsumerCode(String consumerCode) {
        this.consumerCode = consumerCode;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public String getConsumerAddress() {
        return consumerAddress;
    }

    public void setConsumerAddress(String consumerAddress) {
        this.consumerAddress = consumerAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "consumerCode='" + consumerCode + '\'' +
                ", consumerName='" + consumerName + '\'' +
                ", consumerAddress='" + consumerAddress + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", faxNumber='" + faxNumber + '\'' +
                ", linkman='" + linkman + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}

