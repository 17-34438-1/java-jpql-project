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
@Table(name="do_truck_details_entry")
public class DoTruckDetailsEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name="import_rotation")
    private String importRotation;
    @Column(name="cont_no")
    private String  contNo;
    @Column(name="truck_id")
    private String truckId;
    @Column(name="gate_no")
    private  String gateNo;
    @Column(name="driver_name")
    private String driverName;
    @Column(name="driver_gate_pass")
    private String driverGatePass;
    @Column(name="assistant_name")
    private String assistantName;
    @Column(name="assistant_gate_pass")
    private String assistantGatePass;
    @Column(name="gate_in_status")
    private String gateInStatus;

    @Column(name="traffic_chk_st")
    private String trafficChkSt;
    @Column(name="yard_security_chk_st")
    private String yardSecurityChkSt;
    @Column(name="cnf_chk_st")
    private String cnfChkSt;
    @Column(name="update_by")
    private String updateBy;
    @Column(name="load_st")
    private Integer loadSt;
    @Column(name="gate_out_status")
    private Integer gateOutStatus;
    @Column(name="last_update")
    private String lastUpdate;

}
