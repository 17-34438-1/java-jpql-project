
package com.datasoft.pcs.Service;

import com.datasoft.pcs.Model.DTO.IgmAmedmentChangeContainerStatusModel;

import com.datasoft.pcs.Model.DTO.ResponseMessage;
import com.datasoft.pcs.Model.cchaportdb.*;
import com.datasoft.pcs.Repository.cchaportdb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.servlet.http.HttpServletRequest;


import java.util.ArrayList;
import java.util.List;

@Service
public class IgmAmedmentChangeContainerStatusService {

    @Autowired
    IgmDetailsRepository igmDetailsRepository;
    @Autowired
    IgmDetailContainerRepository igmDetailContainerRepository;
    @Autowired
    IgmCorrectionLogRepository igmCorrectionLogRepository;


    @Autowired
    EdoApplicationByCfRepository edoApplicationByCfRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    IgmSupDetailContainerRepository igmSupDetailContainerRepository;

    @Autowired
    IgmSupplimentaryDetailRepository igmSupplimentaryDetailRepository;
    @Autowired
    IgmDetailContainerUpdateRepository igmDetailContainerUpdateRepository;

    @Autowired
    @Qualifier("cchaportdbEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;


    ResponseMessage responseMessage;


    public List getViewIgmDetailContainerLists( String contNumber ,String import_Rotation_No, String bl_No){

        Long igmContId = null;
        String contStatus="";
        String igmType="";
        List<IgmAmedmentChangeContainerStatusModel> igmAmedmentChangeContainerStatusModels=new ArrayList<>();
        IgmAmedmentChangeContainerStatusModel igmAmedmentChangeContainerStatusModel=new IgmAmedmentChangeContainerStatusModel();

        List<IgmSupDetailContainer> findByContNumber = igmSupDetailContainerRepository.findByContNumberAndIgmSupplimentaryDetailImportRotationNoAndIgmSupplimentaryDetailBlNo(contNumber,import_Rotation_No,bl_No);
        if(findByContNumber.size()>0){
            igmType = "sup";
            igmContId=findByContNumber.get(0).getId();
            contStatus=findByContNumber.get(0).getContStatus();
            igmAmedmentChangeContainerStatusModel.setIgmType(igmType);
            igmAmedmentChangeContainerStatusModel.setIgmContId(igmContId);
            igmAmedmentChangeContainerStatusModel.setContStatus(contStatus);
        }

        if(contStatus=="" || contStatus==null) {
            List<IgmDetailContainer> findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo = igmDetailContainerRepository.findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo(contNumber,import_Rotation_No,bl_No);

            if(findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo.size()>0){
                igmType = "dtl";
                igmContId=findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo.get(0).getId();
                contStatus=findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo.get(0).getContStatus();

                igmAmedmentChangeContainerStatusModel.setIgmType(igmType);
                igmAmedmentChangeContainerStatusModel.setIgmContId(igmContId);
                igmAmedmentChangeContainerStatusModel.setContStatus(contStatus);
            }
        }

        igmAmedmentChangeContainerStatusModels.add(igmAmedmentChangeContainerStatusModel);

        return igmAmedmentChangeContainerStatusModels;
    }

    public List  getViewIgmDetailsLists( String import_Rotation_No, String bl_No ,String contNumber ){
        List<IgmDetails> findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo = igmDetailsRepository.findByImportRotationNoAndBlNoAndIgmDetailContainersContNumber(import_Rotation_No,bl_No,contNumber);
        return findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo;
    }


//    public String getViewIgmDetailContainerList( String contNumber , String bl_No,String import_Rotation_No){
//        String cont_status=igmDetailContainerRepository.findByContNumberAndIgmDetailsBlNoAndIgmDetailsImportRotationNo(contNumber,bl_No,import_Rotation_No).getContStatus();
//        return cont_status;
//    }


    public List getViewIgmSubDetalList(String contNumber,String import_Rotation_No, String bl_No){
        List<IgmSupDetailContainer> findByContNumbers = igmSupDetailContainerRepository.findByContNumberAndIgmSupplimentaryDetailImportRotationNoAndIgmSupplimentaryDetailBlNo(contNumber, import_Rotation_No, bl_No);
        return findByContNumbers;
    }

    public List getViewIgmSubDetalListForUpdate(String contNumber, String import_Rotation_No, String bl_No){
        List<IgmSupDetailContainer> igmDetailContainersUpdate=new ArrayList<>();
        IgmSupDetailContainer igmSupDetailContainer=new IgmSupDetailContainer();
       String msg="";
        Long igmContId = null;
        String contStatus="";
        String igmType="";
        List<IgmSupDetailContainer> findByContNumbers = igmSupDetailContainerRepository.findByContNumberAndIgmSupplimentaryDetailImportRotationNoAndIgmSupplimentaryDetailBlNo(contNumber, import_Rotation_No, bl_No);

        return igmDetailContainersUpdate;
    }

    public List getViewDetalListUpdate(Long id,String cont_status){
        List<IgmDetailContainer> igmDetailContainersUpdate=new ArrayList<>();
        IgmDetailContainer igmDetailContainer=new IgmDetailContainer();
        String msg="";
        igmDetailContainer.getContStatus();
        igmDetailContainer.getId();
        IgmDetailContainer igmDetailContainers = igmDetailContainerRepository.save(igmDetailContainer);
        if (!igmDetailContainers.getId().equals("")) {
            msg = "Update successful";
        } else {
            msg = "Dtl Update failed.";
        }
      return igmDetailContainersUpdate;
    }

//        public List getViewIgmSubDetailContainerLists(String contNumber , String import_Rotation_No, String bl_No){
//        List<IgmSupDetailContainer> findByContNumber = igmSupDetailContainerRepository.findByContNumberAndIgmSupplimentaryDetailImportRotationNoAndIgmSupplimentaryDetailBlNo(contNumber,import_Rotation_No,bl_No);
//        return findByContNumber;
//    }



    public List getViewIgmSubDetailContainerLists(String contNumber , String import_Rotation_No, String bl_No){
        List<IgmAmedmentChangeContainerStatusModel> findByContainer=new ArrayList<>();
        IgmAmedmentChangeContainerStatusModel igmSupDetailContainer=new IgmAmedmentChangeContainerStatusModel();
        Long igmContId = null;
        String contStatus="";
        String igmType="";
        String msg = "Blank";
        String edo_application_id = "";
        List<IgmSupDetailContainer> findByContNumber = igmSupDetailContainerRepository.findByContNumberAndIgmSupplimentaryDetailImportRotationNoAndIgmSupplimentaryDetailBlNo(contNumber,import_Rotation_No,bl_No);
        if(findByContNumber.size()>0){
            igmType = "supDtl";
            igmContId=findByContNumber.get(0).getId();
            contStatus=findByContNumber.get(0).getContStatus();
            System.out.println("igmContId:"+igmContId);
            System.out.println("contStatus:"+contStatus);
        }
        System.out.println(igmContId);
        System.out.println("contStatus:"+contStatus);
        if(contStatus=="" || contStatus==null)
        {
            List<IgmDetailContainer> findByContNumbers = igmDetailContainerRepository.findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo(contNumber,import_Rotation_No,bl_No);
            igmType = "dtl";
            igmContId = findByContNumbers.get(0).getId();
            contStatus=findByContNumbers.get(0).getContStatus();

        }

        igmSupDetailContainer.setIgmType(igmType);
        igmSupDetailContainer.setIgmContId(igmContId);
        igmSupDetailContainer.setContStatus(contStatus);
        findByContainer.add(igmSupDetailContainer);

        return findByContainer;
    }


    public List getViewIgmSubDetailContainer(String contNumber ,String import_Rotation_No, String bl_No,String contStatus, String igmType,String login_id){
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        List<IgmCorrectionLog> findByContainer=new ArrayList<>();
        IgmCorrectionLog  igmCorrectionLog=new IgmCorrectionLog();
        Long igmContId = null;

        String msg = "Blank";
        String edo_application_id = "";


        if(igmType == "" || igmType == " " || igmType == null)
        {
            msg = "Invalid Data.";
        }
        else
        {
            if(igmType.equals("dtl") ) {
                List<IgmDetailContainer> findByContNumber = igmDetailContainerRepository.findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo(contNumber, import_Rotation_No, bl_No);
                IgmDetailContainer igmDetailContainer=new IgmDetailContainer();
                IgmDetailContainerUpdate igmDetailContainerUpdate=new IgmDetailContainerUpdate();
                if (findByContNumber.size() > 0)
                {
                    igmType = "dtl";
                    igmContId = findByContNumber.get(0).getId();

                    System.out.println("igmContId:" + igmContId);

                    igmCorrectionLog.setRefTblId(igmContId);
                    igmCorrectionLog.setChangeType("Container");
                    igmCorrectionLog.setIgmType(igmType);
                    igmCorrectionLog.setChangeField("cont_status");
                    igmCorrectionLog.setPriorValue(contStatus);
                    igmCorrectionLog.setNewValue(contStatus);
                    igmCorrectionLog.setEntryBy(login_id);
                    igmCorrectionLog.setEntryIp(request.getRemoteAddr());

                    IgmCorrectionLog respRole = igmCorrectionLogRepository.save(igmCorrectionLog);
                    System.out.println("respRole:" + request.getRemoteAddr());

                    if (!respRole.getRefTblId().equals("")) {

                        contNumber=igmDetailContainer.getContNumber();
                        igmDetailContainer.setId(igmContId);
                        igmDetailContainer.setContNumber(contNumber);

                        System.out.println("ID : " + igmContId + ", Role Name : " + contStatus );
                        Integer igmDetailContainers = igmDetailContainerRepository.update(contStatus,igmContId);
                        System.out.println("igmDetailContainers : "+igmDetailContainers  );


//                        String query1="UPDATE IgmDetailContainer e \n" +
//                                "      SET e.contStatus=:contStatus\n" +
//                                "       WHERE e.id=:id";
//                        entityManager.getTransaction().begin();
//                        Query query = entityManager.createQuery(query1);
//                        System.out.println("QueryUpdate : "+query);
//                        query.setParameter("contStatus",contStatus );
//                        query.setParameter("id", igmContId);
//                        query.executeUpdate();
//                        entityManager.getTransaction().commit();


                            List<EdoApplicationByCf> edoApplicationByCfs=edoApplicationByCfRepository.findByRotationNoAndBlNo(import_Rotation_No,bl_No);
                            EdoApplicationByCf edoApplicationByCf=new EdoApplicationByCf();
                            System.out.println("Rafiqul Islam:"+edoApplicationByCfs.size());
                            if (edoApplicationByCfs.size() > 0) {
                                Integer edoApplication=edoApplicationByCfRepository.update(contStatus,import_Rotation_No,bl_No);
                                System.out.println("edoApplication:"+edoApplication);
                            }
                    }

                    else
                    {
                        msg = "Dtl Log entry failed.";
                    }
                }
                else
                {
                    msg = "Invalid Dtl data submitted..";
                }
            }
            if(igmType.equals("sup") ) {

                List<IgmSupDetailContainer> findByContNumbers = igmSupDetailContainerRepository.findByContNumberAndIgmSupplimentaryDetailImportRotationNoAndIgmSupplimentaryDetailBlNo(contNumber, import_Rotation_No, bl_No);
                IgmSupDetailContainer igmSupDetailContainer=new IgmSupDetailContainer();
                if (findByContNumbers.size() > 0)
                {
                    igmType = "sup";
                    igmContId = findByContNumbers.get(0).getId();
                    igmCorrectionLog.setRefTblId(igmContId);
                    igmCorrectionLog.setChangeType("Container");
                    igmCorrectionLog.setIgmType(igmType);
                    igmCorrectionLog.setChangeField("cont_status");
                    igmCorrectionLog.setPriorValue(contStatus);
                    igmCorrectionLog.setNewValue(contStatus);
                    igmCorrectionLog.setEntryBy(login_id);
                    igmCorrectionLog.setEntryIp(request.getRemoteAddr());
                    IgmCorrectionLog respRole = igmCorrectionLogRepository.save(igmCorrectionLog);
                    if (!respRole.getId().equals("")) {

                        System.out.println("ID : " + igmContId + ", Role Name : " + contStatus );
                        Integer igmSubDetailContainer = igmSupDetailContainerRepository.update(contStatus,igmContId);
                        System.out.println("igmSubDetailContainer : "+igmSubDetailContainer  );

                        List<EdoApplicationByCf> edoApplicationByCfs=edoApplicationByCfRepository.findByRotationNoAndBlNo(import_Rotation_No,bl_No);
                        EdoApplicationByCf edoApplicationByCf=new EdoApplicationByCf();

                        if (edoApplicationByCfs.size() > 0) {


                            Integer edoApplication=edoApplicationByCfRepository.update(contStatus,import_Rotation_No,bl_No);
                            System.out.println("edoApplication:"+edoApplication);
                        }

                    }
                    else
                    {
                        msg = "Dtl Log entry failed.";
                    }
                }
                else
                {
                    msg = "Invalid Dtl data submitted..";
                }
            }
        }

        findByContainer.add(igmCorrectionLog);

        return findByContainer;
    }





}
