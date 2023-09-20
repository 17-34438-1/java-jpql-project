package com.datasoft.pcs.Model.cchaportdb;
import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name="sad_info")
public class SadInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "office_code")
    private Long officeCode;

    @Column(name = "ip_address")
    private String ipAddress;



    @Column(name = "reg_no")
    private Long regNo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone = "Asia/Dhaka")
    @Column(name="reg_date")
    private String regDate;

    @Column(name="place_dec")
    private String placeDec;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Dhaka")
    @Column(name="entry_dt")
    private String entryDate;

    @Column(name="dec_code")
    private Long decCode;

    @OneToMany(mappedBy = "sadInfo",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<SadContainer> sadContainerList=new ArrayList<>();


}
