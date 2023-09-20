package com.datasoft.pcs.Model.DTO;


public class RoutingPointDtoModel {

    private String Id;
    private String Ids;
    private String placeCode;

    private String placeName;

    private String cntryCode;
    private String cntry_name;

    public RoutingPointDtoModel(String id, String ids, String placeCode, String placeName, String cntryCode) {
        Id = id;
        Ids = ids;
        this.placeCode = placeCode;
        this.placeName = placeName;
        this.cntryCode = cntryCode;
    }

    public RoutingPointDtoModel(String cntry_name) {
        this.cntry_name = cntry_name;
    }

    public String getIds() {
        return Ids;
    }

    public void setIds(String ids) {
        Ids = ids;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCntry_name() {
        return cntry_name;
    }

    public void setCntry_name(String cntry_name) {
        this.cntry_name = cntry_name;
    }

    public String getCntryCode() {
        return cntryCode;
    }

    public void setCntryCode(String cntryCode) {
        this.cntryCode = cntryCode;
    }
}
