package com.example.commerce.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String timestamp;

    private String hostname;

    private String appid;

    private String file;

    private String changeagent;

    private String changeprocess;

    private String ackstatus;

    private String acknote;

    private String acktimestamp;

    private String ackuser;

    private String ackintent;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getChangeagent() {
        return changeagent;
    }

    public void setChangeagenet(String changeagent) {
        this.changeagent = changeagent;
    }

    public String getChangeprocess() {
        return changeprocess;
    }

    public void setChangeprocess(String changeprocess) {
        this.changeprocess = changeprocess;
    }

    public String getAckstatus() {
        return ackstatus;
    }

    public void setAckstatus(String ackstatus) {
        this.ackstatus = ackstatus;
    }

    public String getAcknote() {
        return acknote;
    }

    public void setAcknote(String acknote) {
        this.acknote = acknote;
    }

    public String getAcktimestamp() {
        return acktimestamp;
    }

    public void setAcktimestamp(String acktimestamp) {
        this.acktimestamp = acktimestamp;
    }


    public String getAckuser() {
        return ackuser;
    }

    public void setAckuser(String ackuser) {
        this.ackuser = ackuser;
    }

    public String getAckintent() {
        return ackintent;
    }

    public void setAckintent(String ackintent) {
        this.ackintent = ackintent;
    }
}
