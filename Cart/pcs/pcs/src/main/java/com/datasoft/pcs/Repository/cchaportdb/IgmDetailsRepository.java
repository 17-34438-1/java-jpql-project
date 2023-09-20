package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IgmDetailsRepository extends JpaRepository<IgmDetails,Integer> {
    List<IgmDetails> findByImportRotationNoAndBlNoAndIgmDetailContainersContNumber(String import_Rotation_No, String bl_No,String contNumber);

}
