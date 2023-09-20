package com.datasoft.pcs.Repository.cchaportdb;


import com.datasoft.pcs.Model.cchaportdb.SadInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SadInfoModelRepository extends JpaRepository<SadInfoModel,Integer> {



//    List<SadInfoModel> findByEntryDateContains(String entryDate);
//    List<SadInfoModel> countByIpAddress(String entryDate);



}
