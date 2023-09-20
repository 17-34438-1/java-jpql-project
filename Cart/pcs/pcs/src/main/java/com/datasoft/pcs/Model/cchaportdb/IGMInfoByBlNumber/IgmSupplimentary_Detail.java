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
@Table(name="igm_supplimentary_detail")
public class IgmSupplimentary_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="Import_Rotation_No")
    private String importRotationNo;

    @Column(name="BL_No")
    private String blNo;

    @Column(name="Line_No")
    private Integer lineNo;

    @Column(name = "Consignee_code")
    private Integer consigneeCode;

    @Column(name = "Consignee_name")
    private Integer consigneeName;

    @Column(name="Consignee_address")
    private String consigneeAddress;

}
