package com.xrk.entity;

import java.util.Date;

public class WebLinkOur {
    private Integer id;

    private String enterPriselevel;

    private String demandTitle;

    private String demandDetails;

    private Date ctime;

    private Integer open;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnterPriselevel() {
        return enterPriselevel;
    }

    public void setEnterPriselevel(String enterPriselevel) {
        this.enterPriselevel = enterPriselevel == null ? null : enterPriselevel.trim();
    }

    public String getDemandTitle() {
        return demandTitle;
    }

    public void setDemandTitle(String demandTitle) {
        this.demandTitle = demandTitle == null ? null : demandTitle.trim();
    }

    public String getDemandDetails() {
        return demandDetails;
    }

    public void setDemandDetails(String demandDetails) {
        this.demandDetails = demandDetails == null ? null : demandDetails.trim();
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }
}