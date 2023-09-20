package com.datasoft.pcs.Model.cchaportdb.IGMInfoByBlNumber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="igm_details")
public class Igm_Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="IGM_id")
    private Integer igmId;


    @Column(name="Import_Rotation_No")
    private String importRotationNo;

    @Column(name="BL_No")
    private String blNo;
    @Column(name="Line_No")
    private String lineNo;
    @Column(name = "Consignee_code")
    private String consigneeCode;
    @Column(name = "Consignee_name")
    private String consigneeName;
     @Column(name="Consignee_address")
     private String consigneeAddress;



//    @Column(name="final_submit")
//    private Integer finalSubmit;
//
//    @Column(name="Line_No")
//    private Integer LineNo;



//    @Column(name="Pack_Number")
//    private Double Pack_Number;
//
//    @Column(name="Pack_Description")
//    private String Pack_Description;
//
//    @Column(name="Pack_Marks_Number")
//    private String Pack_Marks_Number;
//
//    @Column(name="Description_of_Goods")
//    private String Description_of_Goods;
//
//    @Column(name="Date_of_Entry_of_Goods")
//    private String Date_of_Entry_of_Goods;
//
//    @Column(name="weight")
//    private Double weight;
//
//    @Column(name="weight_unit")
//    private String weight_unit;
//
//    @Column(name="net_weight")
//    private String net_weight;
//
//    @Column(name="final_submit_date")
//    private String final_submit_date;
//
//    @Column(name="net_weight_unit")
//    private String net_weight_unit;
//
//    @Column(name="Bill_of_Entry_No")
//    private String Bill_of_Entry_No;
//
//    @Column(name="Bill_of_Entry_Date")
//    private String Bill_of_Entry_Date;
//
//    @Column(name="office_code")
//    private String office_code;
//
//    @Column(name="No_of_Pack_Delivered")
//    private Double No_of_Pack_Delivered;
//
//
//    @Column(name="No_of_Pack_Discharged")
//    private String No_of_Pack_Discharged;
//
//    @Column(name="Remarks")
//    private String Remarks;
//    @Column(name="AFR")
//    private String AFR;
//    @Column(name="int_block")
//    private String int_block;
//
//    @Column(name="R_No")
//    private String R_No;
//
//    @Column(name="R_Date")
//    private String R_Date;
//
//    @Column(name="delivery_block_stat")
//    private String delivery_block_stat;
//
//    @Column(name="ConsigneeDesc")
//    private String ConsigneeDesc;
//    @Column(name="NotifyDesc")
//    private String NotifyDesc;
//
//    @Column(name="navy_comments")
//    private String navy_comments;
//
//    @Column(name="Submitee_Org_Id")
//    private Integer Submitee_Org_Id;
//
//    @Column(name="mlocode")
//    private String mlocode;
//    @Column(name="type_of_igm")
//    private String igmType;
//
//
//    @Column(name="imco")
//    private String imco;
//    @Column(name="un")
//    private String un;
//    @Column(name="extra_remarks")
//    private String extra_remarks;
//    @Column(name="Submission_Date")
//    private String Submission_Date;
//    @Column(name="PFstatus")
//    private Integer PFstatus;


//    @JsonIgnore
//    @OneToMany(mappedBy = "igmDetails",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<IgmDetailContainer> igmDetailContainers=new ArrayList<>();


}
