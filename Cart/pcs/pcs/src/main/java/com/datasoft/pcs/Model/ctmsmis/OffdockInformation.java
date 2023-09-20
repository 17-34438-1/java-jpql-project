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
@Table(name="offdoc")
public class OffdockInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    @Column(name="code")
    private String code;

    @Column(name="code_ctms")
            private String codeCtms;

    @Column(name="name")
            private String name;



}
