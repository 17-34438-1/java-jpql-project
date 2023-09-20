package com.datasoft.pcs.Service;

import com.datasoft.pcs.Model.ctmsmis.CommudityDetail;
import com.datasoft.pcs.Repository.ctmsmis.CommudityDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import javax.persistence.EntityManagerFactory;

import java.util.List;
@Service
public class IgmCommudityService {
    @Autowired
    CommudityDetailsRepository commudityDetailsRepository;

    @Autowired
    @Qualifier("ctmsmisEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;


    public List getIgmCommudity() {
    List<CommudityDetail> commudityDetails=commudityDetailsRepository.findAll();
    return commudityDetails;
    }




//    public List getIgmCommudity() {
//        List<CommudityDetailDtoModel> commudityDetails=new ArrayList<>();
//        EntityManager entitymanager= entityManagerFactory.createEntityManager();
//String mainQuery="";
//       // mainQuery="SELECT commudity.commudityCode, commudity.commudityDesc FROM CommudityDetail commudity";
//        mainQuery="SELECT new com.datasoft.pcs.Model.DTO.CommudityDetailDtoModel(commudity.commudityCode, commudity.commudityDesc) FROM CommudityDetail commudity";
//        commudityDetails =entitymanager.createQuery(mainQuery).getResultList();
//        List<CommudityDetail> commudityDetails=commudityDetailsRepository.findByCommudityCodeAndCommudityDesc();
//    return commudityDetails;
//    }




}
