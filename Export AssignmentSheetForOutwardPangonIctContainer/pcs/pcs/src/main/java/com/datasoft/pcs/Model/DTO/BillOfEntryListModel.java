package com.datasoft.pcs.Model.DTO;
import com.fasterxml.jackson.annotation.JsonFormat;

public class BillOfEntryListModel {

    private Long id;
    private Long officeCode;
    private Long regNo;
    private Integer placeDecCount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    private String regDate;

    private String placeDec;



//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private Date entryDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    private String entryDate;


    private Integer totalCount;

    private Long decCode;
    private Integer containerNo;

    private String ipAddress;



    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPlaceDecCount() {
        return placeDecCount;
    }

    public void setPlaceDecCount(Integer placeDecCount) {
        this.placeDecCount = placeDecCount;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getPlaceDec() {
        return placeDec;
    }

    public void setPlaceDec(String placeDec) {
        this.placeDec = placeDec;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
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
