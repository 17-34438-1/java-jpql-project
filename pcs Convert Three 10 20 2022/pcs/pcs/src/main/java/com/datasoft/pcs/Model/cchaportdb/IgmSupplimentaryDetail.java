package com.datasoft.pcs.Model.cchaportdb;

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
@Table(name="igm_supplimentary_detail_copy")
public class IgmSupplimentaryDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="Import_Rotation_No")
    private String importRotationNo;

    @Column(name="BL_No")
    private String blNo;

//    @ManyToOne
//    @JoinColumn(name="igm_sub_detail_id")
//    private IgmSupDetailContainer igmSupDetailContainer;


    @JsonIgnore
    @OneToMany(mappedBy = "igmSupplimentaryDetail",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<IgmSupDetailContainer> igmSupDetailContainers=new ArrayList<>();



}
