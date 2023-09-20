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
@Table(name="igm_detail_container_copy")
public class IgmDetailContainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cont_number")
    private String contNumber;


    @Column(name="cont_status")
    private String contStatus;



    @ManyToOne
    @JoinColumn(name="igm_detail_id")
    private IgmDetails igmDetails;


}