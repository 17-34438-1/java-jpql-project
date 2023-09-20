package com.datasoft.pcs.Service;
import com.datasoft.pcs.Model.DTO.RoutingPointDtoModel;
import com.datasoft.pcs.Repository.sparcsn4.RefRoutingPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;



@Service
public class RoutingPointService {
    @Autowired
    RefRoutingPointRepository refRoutingPointRepository;

    @Autowired
    @Qualifier("sparcsn4EntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

//    public List getRoutingPoint(){
//        List<RefRoutingPoint> refRoutingPoints=new ArrayList<>();
//        refRoutingPoints=refRoutingPointRepository.findAll();
//        return refRoutingPoints;
//    }


    public List getRoutingPoint(){
        String mainQuery="";
        List<RoutingPointDtoModel> routingPointDtoModels=new ArrayList<>();
        List<RoutingPointDtoModel> routingPointDtoModel=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();


        mainQuery="SELECT new com.datasoft.pcs.Model.DTO.RoutingPointDtoModel(ref.Id,refUnloc.Id,refUnloc.placeCode,refUnloc.placeName,refUnloc.cntryCode)\n" +
                "FROM Ref_RoutingPoint ref\n" +
                "INNER JOIN Ref_UnlocCode refUnloc ON ref.unlocGkey=refUnloc.Gkey ORDER BY 1\n";
        routingPointDtoModels=entitymanager.createQuery(mainQuery).getResultList();


//                mainQuery="SELECT ref.Id,refUnloc.Id,refUnloc.placeCode,refUnloc.placeName,refUnloc.cntryCode\n" +
//                        "FROM RefRoutingPoint ref\n" +
//                        "INNER JOIN RefUnlocCode refUnloc ON ref.unlocGkey=refUnloc.Gkey\n";
//                vslVesselVisitDetails=entitymanager.createQuery(mainQuery).getResultList();


        for(Integer i=0;i<routingPointDtoModels.size();i++)
        {
            String cntryName="";
            String mainQuery1="";
            RoutingPointDtoModel pointDtoModel=routingPointDtoModels.get(i);

            String cntryCode=pointDtoModel.getCntryCode();
             System.out.println("cntryCode:"+cntryCode);

            mainQuery1="SELECT new com.datasoft.pcs.Model.DTO.RoutingPointDtoModel(refcountry.cntryName) FROM Ref_Country refcountry WHERE refcountry.cntryCode='"+cntryCode+"'";


            routingPointDtoModel=entitymanager.createQuery(mainQuery1).getResultList();
            System.out.println("cntryCode:"+routingPointDtoModel.size());
            if(routingPointDtoModel.size()>0){
              cntryName=routingPointDtoModel.get(0).getCntry_name();
//                System.out.println("cntryCode:"+cntryName);
//                //pointDtoModel.setCntryCode(cntryName);
           }
            pointDtoModel.setCntry_name(cntryName);
        }


//                List<RefRoutingPoint> refRoutingPoints=new ArrayList<>();
//                refRoutingPoints=refRoutingPointRepository.findAll();


        return routingPointDtoModels;
    }


}
