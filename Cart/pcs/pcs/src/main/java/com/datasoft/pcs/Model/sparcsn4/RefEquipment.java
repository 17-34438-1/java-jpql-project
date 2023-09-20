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
@Table(name="ref_equipment")
public class RefEquipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="gkey")
    private Integer Gkey;

    @Column(name="eqtyp_gkey")
    private Integer eqtypGkey;


}
