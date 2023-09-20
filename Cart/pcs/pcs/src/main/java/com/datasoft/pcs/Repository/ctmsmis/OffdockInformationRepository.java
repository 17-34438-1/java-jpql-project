package com.datasoft.pcs.Repository.ctmsmis;


import com.datasoft.pcs.Model.ctmsmis.OffdockInformation;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OffdockInformationRepository extends CrudRepository<OffdockInformation,Integer> {

    List<OffdockInformation> findAll();
}
