package com.datasoft.pcs.Repository.cchaportdb;



import com.datasoft.pcs.Model.cchaportdb.IgmSupDetailContainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IgmSupDetailContainerRepository  extends JpaRepository<IgmSupDetailContainer,Integer> {

    List<IgmSupDetailContainer> findByContNumberAndIgmSupplimentaryDetailImportRotationNoAndIgmSupplimentaryDetailBlNo(String contNumber, String import_Rotation_No, String bl_No);


    @Modifying
      @Query("UPDATE IgmSupDetailContainer e\n" +
            "    SET e.contStatus=:cont_status\n" +
            "    WHERE e.id=:id")
    @Transactional
    Integer update( @Param("cont_status") String cont_status,@Param("id") Long id);




}
