package com.datasoft.pcs.Model.cchaportdb;

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
@Table(name="edo_application_by_cf_copy")
public class EdoApplicationByCf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name="rotation")
    private String rotationNo;

    @Column(name="cont_status")
    private String contStatus;


    @Column(name="bl")
    private String blNo;

}
