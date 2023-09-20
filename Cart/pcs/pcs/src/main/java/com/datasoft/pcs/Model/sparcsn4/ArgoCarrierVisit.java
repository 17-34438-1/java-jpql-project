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
@Table(name="argo_carrier_visit")
public class ArgoCarrierVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gkey")
    private Integer Gkey;

    @Column(name="cvcvd_gkey")
    private Integer cvcvdGkey;


//    @Column(name="carrier_mode")
//    private String carrierMode;
//
//    @Column(name="phase")
//    private String phase;





//
//    @OneToMany(mappedBy = "argoCarrierVisit",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    List<InvUnitFcyVisit> invUnitFcyVisits=new ArrayList<>();
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="cvcvd_gkey")
//    private VslVesselVisitDetails vslVesselVisitDetails;
}
