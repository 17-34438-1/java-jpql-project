package com.datasoft.pcs.Model.sparcsn4;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="inv_unit_fcy_visit")
public class InvUnitFcyVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gkey")
    private Integer Gkey;

    @Column(name="visit_state")
    private String visitState;

    @Column(name="transit_state")
    private String transitState;

    @Column(name="actual_ob_cv")
   private Integer actualObCv;


    @Column(name="unit_gkey")
    private Integer unitGkey;

    //    visit_state
    //    transit_state
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="unit_gkey")
//    private InvUnit invUnit;
//
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="actual_ob_cv")
//    private ArgoCarrierVisit argoCarrierVisit;



}
