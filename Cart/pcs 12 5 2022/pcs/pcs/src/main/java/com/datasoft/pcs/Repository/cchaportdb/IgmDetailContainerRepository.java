package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmDetailContainer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IgmDetailContainerRepository extends JpaRepository<IgmDetailContainer,Integer> {

    List<IgmDetailContainer> findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo( String contNumber,String import_Rotation_No, String bl_No);
    IgmDetailContainer findByContNumberAndIgmDetailsBlNoAndIgmDetailsImportRotationNo( String contNumber, String bl_No,String import_Rotation_No);




   @Transactional
    @Modifying()
    @Query("UPDATE IgmDetailContainer e\n" +
            "    SET e.contStatus=:contStatus\n" +
            "    WHERE e.id=:id")

    Integer update(@Param("contStatus") String contStatus, @Param("id") Long id);


}
