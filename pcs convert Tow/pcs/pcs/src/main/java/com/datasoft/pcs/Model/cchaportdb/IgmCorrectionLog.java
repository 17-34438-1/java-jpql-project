package com.datasoft.pcs.Model.cchaportdb;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="igm_correction_log_copy")
public class IgmCorrectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="ref_tbl_id")
    public Long refTblId;

    @Column(name = "change_type")
    public String changeType;
    @Column(name = "igm_type")
    public String igmType;

    @Column(name = "change_field")
    public String changeField;



    @Column(name = "prior_value")
    public String priorValue;
    @Column(name = "new_value")
    public String newValue;



    @Column(name = "entry_by",updatable = false)
    private String entryBy;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name = "entry_at", updatable = false)
    private Date entryAt = new Date();



    @Column(name = "entry_ip",updatable = false)
    private String entryIp;
}
