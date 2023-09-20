package com.datasoft.pcs.Service;
import com.datasoft.pcs.Model.DTO.VslVesselVisitDetailsDtoModel;
import com.datasoft.pcs.Model.sparcsn4.RefEquipType;
import com.datasoft.pcs.Repository.sparcsn4.VslVesselVisitDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportReportAssignmentSheetForOutwardPangonIctContainer {

    @Autowired
    VslVesselVisitDetailsRepository vslVesselVisitDetailsRepository;

    @Autowired
    @Qualifier("sparcsn4EntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    public List getAssignmentSheetForOutwardPangonIctContainer(String rotation)  {
        String Rotation=rotation.replace('_','/');
        System.out.println("Rotation:"+Rotation);
        String mainQuery="";
        List<VslVesselVisitDetailsDtoModel> vslVesselVisitDetails=new ArrayList<>();
        List<RefEquipType> refEquipTypes=new ArrayList<>();
        RefEquipType refEquipType=new RefEquipType();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
                mainQuery="SELECT new com.datasoft.pcs.Model.DTO.VslVesselVisitDetailsDtoModel(inv.Gkey,inv.id,inv.sealNbr1,inv.goodsAndCtrWtKg,ref.Mlo,vessels.Name,refEquipType.nominalLength)\n" +
                "FROM VslVesselVisitDetails vslVessel\n" +
                "INNER JOIN ArgoCarrierVisit argo ON argo.cvcvdGkey=vslVessel.vvdGkey\n" +
                "INNER JOIN InvUnitFcyVisit invunitFcy ON invunitFcy.actualObCv = argo.Gkey\n" +
                "INNER JOIN InvUnit inv ON inv.Gkey = invunitFcy.unitGkey\n" +
                "INNER JOIN RefBizunitScoped ref ON ref.Gkey = inv.lineOp\n" +
                "INNER JOIN VslVessels vessels  ON vslVessel.vesselGkey = vessels.Gkey\n" +
                "INNER JOIN InvUnitEquip equip  ON equip.unitGkey = inv.Gkey\n" +
                "INNER JOIN RefEquipment refEquip  ON refEquip.Gkey = equip.eqGkey\n" +
                "INNER JOIN RefEquipType refEquipType  ON refEquipType.Gkey = refEquip.eqtypGkey\n" +
                "WHERE vslVessel.ibVyg='"+Rotation+"'";
        vslVesselVisitDetails =entitymanager.createQuery(mainQuery).getResultList();
        Integer i=0;

//        String size=vslVesselVisitDetails.get(0).getNominal_length();
//        String[] arrOfLoginId = size.split("M");
//        String short_name=arrOfLoginId[1];
//        System.out.println("splited:"+short_name);



        VslVesselVisitDetailsDtoModel vslVesselVisitDetailsDtoModel;
        while (i< vslVesselVisitDetails.size()){
            vslVesselVisitDetailsDtoModel=vslVesselVisitDetails.get(i);
            String size=vslVesselVisitDetails.get(i).getNominal_length();
            String[] arrOfLoginId = size.split("M");
            String short_name=arrOfLoginId[1];
            vslVesselVisitDetailsDtoModel.setLength(short_name);
            i++;
          }
        return vslVesselVisitDetails;
    }

}
