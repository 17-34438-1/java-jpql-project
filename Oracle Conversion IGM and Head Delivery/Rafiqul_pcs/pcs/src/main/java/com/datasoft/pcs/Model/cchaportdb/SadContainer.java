package com.datasoft.pcs.Model.cchaportdb;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="sad_container")
public class SadContainer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

 @JsonIgnore
 @ManyToOne
 @JoinColumn(name = "sad_id")
 private SadInfo sadInfo;
}
