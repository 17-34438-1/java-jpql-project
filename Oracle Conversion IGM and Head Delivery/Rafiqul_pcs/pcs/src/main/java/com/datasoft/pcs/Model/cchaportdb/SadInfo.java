package com.datasoft.pcs.Model.cchaportdb;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sad_info")
public class SadInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   @Column(name = "office_code")
    private Long officeCode;

    @Column(name = "reg_no")
    private Long regNo;

   @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name="reg_date")
    private Date regDate=new Date();

    @Column(name="place_dec")
    private String placeDec;

   @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name="entry_dt")
    private Date entryDate=new Date();

    @Column(name="dec_code")
    private Long decCode;

    @OneToMany(mappedBy = "sadInfo",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<SadContainer> sadContainerList=new ArrayList<>();


}
