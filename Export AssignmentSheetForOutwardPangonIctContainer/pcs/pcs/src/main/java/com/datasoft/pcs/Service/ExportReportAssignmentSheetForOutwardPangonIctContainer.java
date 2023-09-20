package com.datasoft.pcs.Service;

import com.datasoft.pcs.Model.DTO.VslVesselVisitDetailsDtoModel;
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
       // List<VslVesselVisitDetails> vslVesselVisitDetails=new ArrayList<>();
        List<VslVesselVisitDetailsDtoModel> vslVesselVisitDetails=new ArrayList<>();

        EntityManager entitymanager= entityManagerFactory.createEntityManager();





//        vslVesselVisitDetails=vslVesselVisitDetailsRepository.findByIbVyg(Rotation);
//        mainQuery="SELECT new com.datasoft.pcs.Model.DTO.VslVesselVisitDetailsDtoModel(igms.id,igms.igmId) FROM  IgmDetails igms \n" +
//                "WHERE igms.igmId='"+code+"'";


//        mainQuery="SELECT new com.datasoft.pcs.Model.DTO.VslVesselVisitDetailsDtoModel(inv.Gkey,inv.id,inv.sealNbr1,inv.goodsAndCtrWtKg)\n" +
//                "FROM VslVesselVisitDetails vslVessel\n" +
//                "INNER JOIN ArgoCarrierVisit argo ON argo.cvcvdGkey=vslVessel.vvdGkey\n" +
//                "INNER JOIN InvUnitFcyVisit invunitFcy ON invunitFcy.actualObCv = argo.Gkey\n" +
//                "INNER JOIN InvUnit inv ON inv.Gkey = invunitFcy.unitGkey\n" +
//
//                "WHERE vslVessel.ibVyg='"+Rotation+"'";



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


//        mainQuery="SELECT new com.datasoft.pcs.Model.DTO.VslVesselVisitDetailsDtoModel (vslVessel.ibVyg)\n" +
//                "FROM VslVesselVisitDetails vslVessel\n" +
//                "WHERE vslVessel.ibVyg='"+Rotation+"'";

//                mainQuery="SELECT vsl.ibVyg\n" +
//                        "FROM VslVesselVisitDetails vsl\n" +
//                        "WHERE vsl.ibVyg='"+Rotation+"'\n";

        vslVesselVisitDetails =entitymanager.createQuery(mainQuery).getResultList();
        return vslVesselVisitDetails;
    }

}
