package com.datasoft.pcs.Model.sparcsn4;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="inv_unit")
public class InvUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gkey")
    private Integer Gkey;


    @Column(name="id")
    private String id;


    @Column(name="seal_nbr1")
    private String sealNbr1;

    @Column(name="line_op")
    private String lineOp;


    @Column(name="goods_and_ctr_wt_kg")
    private Integer goodsAndCtrWtKg;

//    @JsonIgnore
//    @OneToMany(mappedBy = "argoCarrierVisit",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<InvUnitFcyVisit> invUnitFcyVisits=new ArrayList<>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "invUnit",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    List<InvUnitFcyVisit> invUnitFcyVisit=new ArrayList<>();

}
