package com.datasoft.pcs.Model.sparcsn4.RoutingPointInfo;

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
@Table(name="ref_routing_point")
public class Ref_RoutingPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gkey")
    private Integer gkeyABC;

    @Column(name = "id")
    private String Id;

    @Column(name = "unloc_gkey")
    private Integer unlocGkey;

//    @ManyToOne
//    @JoinColumn(name="unloc_gkey")
//    private RefUnlocCode refUnlocCode;
//


}
