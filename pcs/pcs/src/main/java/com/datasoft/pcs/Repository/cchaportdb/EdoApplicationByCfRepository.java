package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.EdoApplicationByCf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EdoApplicationByCfRepository extends JpaRepository<EdoApplicationByCf,Integer> {

    List<EdoApplicationByCf> findByRotationNoAndBlNo(String import_Rotation_No, String bl_No);



    @Transactional
    @Modifying()
    @Query("UPDATE EdoApplicationByCf e\n" +
            "    SET e.contStatus=:contStatus\n" +
            "    WHERE e.rotationNo=:import_Rotation_No\n" +
            "    AND e.blNo=:blNo"
    )

    Integer update(@Param("contStatus") String contStatus, @Param("import_Rotation_No") String import_Rotation_No,@Param("blNo") String blNo);



}