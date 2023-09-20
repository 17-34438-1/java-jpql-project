package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.SadContainer;
import com.datasoft.pcs.Model.cchaportdb.SadInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SadContainerRepository extends JpaRepository<SadContainer,Long> {

//    List<SadContainer> findByContNumber(String entryDate);
    List<SadContainer> findBySadInfoRegNoAndSadInfoRegDate(Long regNo, String regDate);

}
