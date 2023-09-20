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
@Table(name="igm_detail_container")
public class IgmDetail_Container {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="igm_detail_id")
    private String igmDetailId;

    @Column(name="cont_number")
    private String contNumber;




    @Column(name="cont_size")
    private String contSize;


    @Column(name="cont_gross_weight")
    private String contGrossWeight;

    @Column(name="cont_seal_number")
    private String contSealNumber;



    @Column(name="cont_status")
    private String contStatus;

    @Column(name="cont_height")
    private String contHeight;


//    @ManyToOne
//    @JoinColumn(name="igm_detail_id")
//    private IgmDetails igmDetails;


}