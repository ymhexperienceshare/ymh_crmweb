package com.guigu.crm.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CrmCustomer {
    
    @NotNull(message="{customer.no.isNull}")
    @Size(min=5,max=6,message="{customer.no.length}")
    private String no;
 
    @NotNull(message="{customer.name.isNull}")
    @Size(min=2,max=12,message="{customer.name.length}")
    private String name;

    private String region;

    private Integer managerId;

    @Max(value=5,message="{customer.level.max}")
    @Min(value=0,message="{customer.level.min}")
    private Integer level;

    private String levelLable;

    private Integer satisfy;

    private Integer credit;

    private String addr;

    private String zip;  //

    private String tel;

    private String fax;

    private String website;

    private String licenceNo;

    private String chieftain;

    private Integer bankroll;

    private Integer turnover;

    private String bank;

    private String bankAccount;

    private String localTaxNo;//

    private String nationTaxNo;

    private Integer status;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelLable() {
        return levelLable;
    }

    public void setLevelLable(String levelLable) {
        this.levelLable = levelLable == null ? null : levelLable.trim();
    }

    public Integer getSatisfy() {
        return satisfy;
    }

    public void setSatisfy(Integer satisfy) {
        this.satisfy = satisfy;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo == null ? null : licenceNo.trim();
    }

    public String getChieftain() {
        return chieftain;
    }

    public void setChieftain(String chieftain) {
        this.chieftain = chieftain == null ? null : chieftain.trim();
    }

    public Integer getBankroll() {
        return bankroll;
    }

    public void setBankroll(Integer bankroll) {
        this.bankroll = bankroll;
    }

    public Integer getTurnover() {
        return turnover;
    }

    public void setTurnover(Integer turnover) {
        this.turnover = turnover;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount == null ? null : bankAccount.trim();
    }

    public String getLocalTaxNo() {
        return localTaxNo;
    }

    public void setLocalTaxNo(String localTaxNo) {
        this.localTaxNo = localTaxNo == null ? null : localTaxNo.trim();
    }

    public String getNationTaxNo() {
        return nationTaxNo;
    }

    public void setNationTaxNo(String nationTaxNo) {
        this.nationTaxNo = nationTaxNo == null ? null : nationTaxNo.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}