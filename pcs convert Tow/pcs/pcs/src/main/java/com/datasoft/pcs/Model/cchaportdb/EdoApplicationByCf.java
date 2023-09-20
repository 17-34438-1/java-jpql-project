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
@Table(name="edo_application_by_cf_backup")
public class EdoApplicationByCf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
