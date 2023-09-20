package com.datasoft.pcs.Model.DTO;

public class IgmAmedmentChangeContainerStatusModel {

   private  Long igmContId;
    private  String contStatus;
    private String igmType;
    private String msg;

    public Long getIgmContId() {
        return igmContId;
    }
    public void setIgmContId(Long igmContId) {
        this.igmContId = igmContId;
    }
    public String getContStatus() {
        return contStatus;
    }
    public void setContStatus(String contStatus) {
        this.contStatus = contStatus;
    }

    public String getIgmType() {
        return igmType;
    }

    public void setIgmType(String igmType) {
        this.igmType = igmType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
