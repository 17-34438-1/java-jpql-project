package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.SadContainer;
import com.datasoft.pcs.Model.cchaportdb.SadInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface  SadInfoRepository extends JpaRepository<SadInfo,Long> {
    List<SadInfo> findBydecCode(Long decode);
    //for Search List
    List<SadInfo> findByOfficeCodeAndDecCode(Long officeCode, Long decCode);
    List<SadInfo> findByRegDateAndDecCode(Date regDate, Long decCode);
    List<SadInfo> findByEntryDateAndDecCode(Date entryDate,Long decCode);
    List<SadInfo> findByRegNoAndDecCode(Long regNo, Long decCode);

}
