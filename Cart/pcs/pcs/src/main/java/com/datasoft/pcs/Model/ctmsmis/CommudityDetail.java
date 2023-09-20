package com.datasoft.pcs.Model.ctmsmis;

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
@Table(name="commudity_detail")
public class CommudityDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commudity_code")
    private Integer commudityCode;

    @Column(name = "commudity_desc")
    private String commudityDesc;


}
