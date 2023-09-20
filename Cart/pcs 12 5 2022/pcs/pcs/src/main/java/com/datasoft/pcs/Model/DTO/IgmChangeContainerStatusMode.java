package com.datasoft.pcs.Model.DTO;



public class IgmChangeContainerStatusMode {

    private String container_no;
    private String bl_no;
    private String  Rotation;
    private String igmType;
    private String priorValue;
    private String  newValue;
    private String login_id;
    public Long refTblId;
    public String changeType;
    public String changeField;
    private String entryBy;
    public String getEntryBy() {
        return entryBy;
    }
    public void setEntryBy(String entryBy) {
        this.entryBy = entryBy;
    }
    public String getContainer_no() {
        return container_no;
    }
    public void setContainer_no(String container_no) {
        this.container_no = container_no;
    }
    public String getBl_no() {
        return bl_no;
    }
    public void setBl_no(String bl_no) {
        this.bl_no = bl_no;
    }
    public String getRotation() {
        return Rotation;
    }
    public void setRotation(String rotation) {
        Rotation = rotation;
    }
    public String getIgmType() {
        return igmType;
    }
    public void setIgmType(String igmType) {
        this.igmType = igmType;
    }

    public String getPriorValue() {
        return priorValue;
    }

    public void setPriorValue(String priorValue) {
        this.priorValue = priorValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getLogin_id() {
        return login_id;
    }

    public void setLogin_id(String login_id) {
        this.login_id = login_id;
    }

    public Long getRefTblId() {
        return refTblId;
    }

    public void setRefTblId(Long refTblId) {
        this.refTblId = refTblId;
    }

    public String getChangeType() {
        return changeType;
    }

    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    public String getChangeField() {
        return changeField;
    }

    public void setChangeField(String changeField) {
        this.changeField = changeField;
    }
}
