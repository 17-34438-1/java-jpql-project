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
@Table(name="ref_bizunit_scoped")
public class RefBizunitScoped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private String Mlo;

    @Column(name="gkey")
    private Integer Gkey;


//    @Column(name="id")
//    private String Mlo;

}
