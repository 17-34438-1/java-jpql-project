package com.datasoft.pcs.Model.DTO;

public class BillofEntryListDtoModel {
    private Integer TotalEnty;
    private Integer total;
    private String ip_address;
    private String entry_dt;

//    public BillofEntryListDtoModel(String ip_address, String entry_dt) {
//        this.ip_address = ip_address;
//        this.entry_dt = entry_dt;
//    }

    public Integer getTotalEnty() {
        return TotalEnty;
    }

    public void setTotalEnty(Integer totalEnty) {
        TotalEnty = totalEnty;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public String getEntry_dt() {
        return entry_dt;
    }

    public void setEntry_dt(String entry_dt) {
        this.entry_dt = entry_dt;
    }
}
