package com.datasoft.pcs.Model.sparcsn4;

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
@Table(name="vsl_vessel_visit_details")
public class VslVesselVisitDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="vvd_gkey")
    private Integer vvdGkey;

    @Column(name="ib_vyg")
    private String ibVyg;

    @Column(name="vessel_gkey")
    private String vesselGkey;

//    @Column(name="ob_vyg")
//    private String obVyg;
//
//    @Column(name="is_dray_off")
//    private String isDrayOff;


//    ob_vyg
//
//            is_dray_off

//
//    @OneToMany(mappedBy = "vslVesselVisitDetails",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//  List<ArgoCarrierVisit> argoCarrierVistList=new ArrayList<>();

}
