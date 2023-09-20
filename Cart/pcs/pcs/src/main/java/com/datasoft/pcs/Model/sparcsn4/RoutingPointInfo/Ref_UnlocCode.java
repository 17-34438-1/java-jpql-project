package com.datasoft.pcs.Model.sparcsn4.RoutingPointInfo;

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
@Table(name="ref_unloc_code")
public class Ref_UnlocCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gkey")
    private Integer Gkey;

    @Column(name = "id")
  private String Id;


    @Column(name = "place_code")
         private String placeCode;


    @Column(name = "place_name")
           private String placeName;


    @Column(name = "cntry_code")
         private String cntryCode;

//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name="unloc_gkey")
//    private RefRoutingPoint refRoutingPoint;

//        @JsonIgnore
//        @OneToMany(mappedBy = "refUnlocCode",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//        List<RefRoutingPoint> refRoutingPoints=new ArrayList<>();

}
