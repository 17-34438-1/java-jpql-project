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
@Table(name="ref_routing_point")
public class RefRoutingPoint {
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
