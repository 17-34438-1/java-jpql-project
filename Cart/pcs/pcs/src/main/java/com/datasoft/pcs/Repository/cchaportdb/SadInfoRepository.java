package com.datasoft.pcs.Repository.cchaportdb;
import com.datasoft.pcs.Model.cchaportdb.SadInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SadInfoRepository extends JpaRepository<SadInfo,Integer> {
//    List<SadInfo> findByAsyId(Integer asyId);
//    List<SadInfo> findByIpAddress(String ipAddress);
    List<SadInfo> findByEntryDateContains(String entryDate);

}
