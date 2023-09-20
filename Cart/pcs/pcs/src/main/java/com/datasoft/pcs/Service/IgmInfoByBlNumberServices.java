package com.datasoft.pcs.Service;


import com.datasoft.pcs.Model.cchaportdb.IGMInfoByBlNumber.Igm_Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
@Service
public class IgmInfoByBlNumberServices {
    @Autowired
    @Qualifier("cchaportdbEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    public List getIgmInfoByBlNumber(String bl)  {

        System.out.println("Rotation:"+bl);
        String mainQuery="";
        List<Igm_Details> vslVesselVisitDetails=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();

//        mainQuery="SELECT igmdetails.importRotationNo,igmdetails.lineNo,igmdetails.consigneeCode,igmdetails.consigneeName,igmdetails.consigneeAddress,igmDetailsCont.contNumber,igmDetailsCont.contSize,igmDetailsCont.contGrossWeight,igmDetailsCont.contSealNumber,igmDetailsCont.contStatus,igmDetailsCont.contHeight\n" +
//                "FROM Igm_Details igmdetails INNER JOIN IgmDetail_Container igmDetailsCont ON igmDetailsCont.igmDetailId=igmdetails.Id\n" +
//                "WHERE BL_No IN ('"+bl+"')";


//        mainQuery="SELECT igmdetails.importRotationNo,igmdetails.lineNo,igmdetails.consigneeCode,igmdetails.consigneeName,igmdetails.consigneeAddress,igmDetailsCont.contNumber,igmDetailsCont.contSize,igmDetailsCont.contGrossWeight,igmDetailsCont.contSealNumber,igmDetailsCont.contStatus,igmDetailsCont.contHeight\n" +
//                "FROM Igm_Details igmdetails INNER JOIN IgmDetail_Container igmDetailsCont ON igmDetailsCont.igmDetailId=igmdetails.Id\n" +
//                "WHERE BL_No IN ('"+bl+"')"
//        ;

//        mainQuery="SELECT igmdetails.importRotationNo,igmdetails.lineNo,igmdetails.consigneeCode,igmdetails.consigneeName,igmdetails.consigneeAddress,igmDetailsCont.contNumber,igmDetailsCont.contSize,igmDetailsCont.contGrossWeight,igmDetailsCont.contSealNumber,igmDetailsCont.contStatus,igmDetailsCont.contHeight\n" +
//                "FROM Igm_Details igmdetails INNER JOIN IgmDetail_Container igmDetailsCont ON igmDetailsCont.igmDetailId=igmdetails.Id\n" +
//                "WHERE BL_No IN ('"+bl+"') UNION " +
//                "SELECT igmsupDetail.importRotationNo,igmsupDetail.lineNo,igmsupDetail.consigneeCode,igmsupDetail.consigneeName,igmsupDetail.consigneeAddress,\n" +
//                "igmSupDetailContainer.contNumber,igmSupDetailContainer.contSize,igmSupDetailContainer.contGrossWeight,igmSupDetailContainer.contSealNumber,igmSupDetailContainer.contStatus,igmSupDetailContainer.contHeight\n" +
//                "FROM IgmSupplimentary_Detail igmsupDetail\n" +
//                "INNER JOIN IgmSupDetail_Container igmSupDetailContainer ON igmSupDetailContainer.igmSupDetailId=igmsupDetail.Id\n" +
//                "WHERE BL_No IN  ('"+bl+"')";

        mainQuery="SELECT igmdetails.importRotationNo,igmdetails.lineNo,igmdetails.consigneeCode,igmdetails.consigneeName,igmdetails.consigneeAddress,igmDetailsCont.contNumber,igmDetailsCont.contSize,igmDetailsCont.contGrossWeight,igmDetailsCont.contSealNumber,igmDetailsCont.contStatus,igmDetailsCont.contHeight\n" +
                "FROM Igm_Details igmdetails INNER JOIN IgmDetail_Container igmDetailsCont ON igmDetailsCont.igmDetailId=igmdetails.Id\n" +
                "WHERE BL_No IN ('"+bl+"')\n";
        vslVesselVisitDetails =entitymanager.createQuery(mainQuery).getResultList();
        return vslVesselVisitDetails;
    }


}
