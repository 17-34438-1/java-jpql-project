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
@Table(name="ref_equip_type")
public class RefEquipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gkey")
    private Integer Gkey;

    @Column(name="nominal_length")
    private String nominalLength;
}
