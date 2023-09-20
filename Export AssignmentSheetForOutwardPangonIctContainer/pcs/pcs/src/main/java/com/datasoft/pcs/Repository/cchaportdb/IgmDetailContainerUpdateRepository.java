package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmDetailContainerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IgmDetailContainerUpdateRepository extends JpaRepository<IgmDetailContainerUpdate,Integer> {

//    @Modifying()
//    @Query(value = "UPDATE edi_stow_info\n" +
//            "SET file_status='1',file_download_by=:log_id,file_download_date=NOW() \n" +
//            "WHERE id=:id", nativeQuery = true)
//    @Transactional
//    Integer updateTodaysEdi(@Param("log_id") String log_id, @Param("id") Integer id);


//    @Modifying()
//    @Query(value = "UPDATE igm_detail_container_copy\n" +
//            "SET igm_detail_container_copy.cont_status=:cont_status\n" +
//            "WHERE igm_detail_container_copy.id=:id", nativeQuery = true)
//    @Transactional
//    Integer updateTodaysEdi(@Param("cont_status") String cont_status, @Param("id") Long id);



}
