package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.SadContainer;
import com.datasoft.pcs.Model.cchaportdb.SadInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SadContainerRepository extends JpaRepository<SadContainer,Long> {
    List<SadContainer> findBySadInfoRegNoAndSadInfoRegDate(Long regNo, String regDate);

    List findByContNumberAndSadInfoDecCode(String searchValue, long decCode);


    List findBySadInfoDecCodeAndContNumber(long decCode, String searchValue);
}
