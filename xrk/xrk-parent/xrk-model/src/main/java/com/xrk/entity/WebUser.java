package com.xrk.entity;

import java.util.Date;

public class WebUser {
    private Integer id;

    private String password;

    private String name;

    private String grade;

    private String tel;

    private String totalscore;

    private String curscore;

    private Date birdate;

    private Integer edu;

    private String qq;

    private String email;

    private String sex;

    private String fax;

    private String zip;

    private String area;

    private String addr;

    private String notes;

    private String ctime;

    private String passwdsalt;

    private byte[] enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade == null ? null : grade.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(String totalscore) {
        this.totalscore = totalscore == null ? null : totalscore.trim();
    }

    public String getCurscore() {
        return curscore;
    }

    public void setCurscore(String curscore) {
        this.curscore = curscore == null ? null : curscore.trim();
    }

    public Date getBirdate() {
        return birdate;
    }

    public void setBirdate(Date birdate) {
        this.birdate = birdate;
    }

    public Integer getEdu() {
        return edu;
    }

    public void setEdu(Integer edu) {
        this.edu = edu;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getPasswdsalt() {
        return passwdsalt;
    }

    public void setPasswdsalt(String passwdsalt) {
        this.passwdsalt = passwdsalt == null ? null : passwdsalt.trim();
    }

    public byte[] getEnabled() {
        return enabled;
    }

    public void setEnabled(byte[] enabled) {
        this.enabled = enabled;
    }
}