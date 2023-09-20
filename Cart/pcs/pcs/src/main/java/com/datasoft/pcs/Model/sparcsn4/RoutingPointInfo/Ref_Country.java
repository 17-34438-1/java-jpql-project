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
@Table(name="ref_country")
public class Ref_Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cntry_code")
    private String cntryCode;

    @Column(name = "cntry_name")
    private String cntryName;


}
