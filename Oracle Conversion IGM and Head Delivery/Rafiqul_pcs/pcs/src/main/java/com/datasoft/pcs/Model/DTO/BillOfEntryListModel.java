package com.datasoft.pcs.Model.DTO;

import com.datasoft.pcs.Model.cchaportdb.SadContainer;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillOfEntryListModel {

    private Long id;
    private Long officeCode;
    private Long regNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    private Date regDate=new Date();
    private String placeDec;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    private Date entryDate=new Date();
    private Long decCode;
    private Integer containerNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(Long officeCode) {
        this.officeCode = officeCode;
    }

    public Long getRegNo() {
        return regNo;
    }

    public void setRegNo(Long regNo) {
        this.regNo = regNo;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getPlaceDec() {
        return placeDec;
    }

    public void setPlaceDec(String placeDec) {
        this.placeDec = placeDec;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Long getDecCode() {
        return decCode;
    }

    public void setDecCode(Long decCode) {
        this.decCode = decCode;
    }

    public Integer getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(Integer containerNo) {
        this.containerNo = containerNo;
    }
}
