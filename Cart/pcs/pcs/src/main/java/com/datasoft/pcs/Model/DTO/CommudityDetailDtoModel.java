package com.datasoft.pcs.Model.DTO;


public class CommudityDetailDtoModel {
    private Integer commudityCode;
    private String commudityDesc;

    public CommudityDetailDtoModel(Integer commudityCode, String commudityDesc) {

        this.commudityCode = commudityCode;
        this.commudityDesc = commudityDesc;
    }

    public Integer getCommudityCode() {
        return commudityCode;
    }

    public void setCommudityCode(Integer commudityCode) {
        this.commudityCode = commudityCode;
    }

    public String getCommudityDesc() {
        return commudityDesc;
    }

    public void setCommudityDesc(String commudityDesc) {
        this.commudityDesc = commudityDesc;
    }
}
