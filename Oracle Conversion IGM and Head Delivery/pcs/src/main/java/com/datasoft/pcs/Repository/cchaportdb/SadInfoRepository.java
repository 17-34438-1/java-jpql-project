package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.SadInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface  SadInfoRepository extends JpaRepository<SadInfo,Long> {
    List<SadInfo> findByDecCode(Long decode);
    //for Search List
    List<SadInfo> findByOfficeCodeAndDecCode(Long officeCode, Long decCode);
    List<SadInfo> findByRegDateAndDecCode(String regDate, Long decCode);
    List<SadInfo> findByEntryDateAndDecCode(String entryDate,Long decCode);
    List<SadInfo> findByRegNoAndDecCode(Long regNo, Long decCode);

   List<SadInfo> findByDecCodeAndSadContainerListContNumber(long decCode,String searchValue);
}
