package com.datasoft.pcs.Repository.ctmsmis;

import com.datasoft.pcs.Model.ctmsmis.CommudityDetail;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface CommudityDetailsRepository extends CrudRepository<CommudityDetail,Integer> {
    List<CommudityDetail> findAll();

}
