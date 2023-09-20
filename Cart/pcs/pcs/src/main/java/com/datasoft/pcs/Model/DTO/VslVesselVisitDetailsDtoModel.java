package com.datasoft.pcs.Model.DTO;

public class VslVesselVisitDetailsDtoModel {

    private Integer gkey;
    private String id;
    private String seal_nbr1;
    private Integer goods_and_ctr_wt_kg;
    private String mlo;
    private String name;
    private String nominal_length;
    public String length;


    public VslVesselVisitDetailsDtoModel(Integer gkey, String id, String seal_nbr1, Integer goods_and_ctr_wt_kg, String mlo, String name, String nominal_length) {
        this.gkey = gkey;
        this.id = id;
        this.seal_nbr1 = seal_nbr1;
        this.goods_and_ctr_wt_kg = goods_and_ctr_wt_kg;
        this.mlo = mlo;
        this.name = name;
        this.nominal_length = nominal_length;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMlo() {
        return mlo;
    }

    public void setMlo(String mlo) {
        this.mlo = mlo;
    }

    public String getNominal_length() {
        return nominal_length;
    }

    public void setNominal_length(String nominal_length) {
        this.nominal_length = nominal_length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGkey() {
        return gkey;
    }

    public void setGkey(Integer gkey) {
        this.gkey = gkey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeal_nbr1() {
        return seal_nbr1;
    }

    public void setSeal_nbr1(String seal_nbr1) {
        this.seal_nbr1 = seal_nbr1;
    }

    public Integer getGoods_and_ctr_wt_kg() {
        return goods_and_ctr_wt_kg;
    }

    public void setGoods_and_ctr_wt_kg(Integer goods_and_ctr_wt_kg) {
        this.goods_and_ctr_wt_kg = goods_and_ctr_wt_kg;
    }
}
