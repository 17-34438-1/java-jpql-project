package com.datasoft.pcs.Service;

import com.datasoft.pcs.Model.DTO.IgmAmedmentChangeContainerStatusModel;
import com.datasoft.pcs.Model.DTO.IgmChangeContainerStatusMode;
import com.datasoft.pcs.Model.DTO.ResponseMessage;
import com.datasoft.pcs.Model.cchaportdb.IgmCorrectionLog;
import com.datasoft.pcs.Model.cchaportdb.IgmDetailContainer;
import com.datasoft.pcs.Model.cchaportdb.IgmDetails;
import com.datasoft.pcs.Model.cchaportdb.IgmSupDetailContainer;
import com.datasoft.pcs.Repository.cchaportdb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


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
    @Qualifier("cchaportdbEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;


    ResponseMessage responseMessage;


    public List getViewIgmDetailContainerLists( String contNumber ,String import_Rotation_No, String bl_No){
        List<IgmDetailContainer> findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo = igmDetailContainerRepository.findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo(contNumber,import_Rotation_No,bl_No);
        String cont_status=igmDetailContainerRepository.findByContNumberAndIgmDetailsBlNoAndIgmDetailsImportRotationNo(contNumber,bl_No,import_Rotation_No).getContStatus();
        return findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo;
    }

    public List  getViewIgmDetailsLists( String import_Rotation_No, String bl_No ,String contNumber ){
        List<IgmDetails> findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo = igmDetailsRepository.findByImportRotationNoAndBlNoAndIgmDetailContainersContNumber(import_Rotation_No,bl_No,contNumber);
        //String cont_status=igmDetailContainerRepository.findByContNumberAndIgmDetailsBlNoAndIgmDetailsImportRotationNo(contNumber,bl_No,import_Rotation_No).getContStatus();
        return findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo;
    }


    public String getViewIgmDetailContainerList( String contNumber , String bl_No,String import_Rotation_No){
       String cont_status=igmDetailContainerRepository.findByContNumberAndIgmDetailsBlNoAndIgmDetailsImportRotationNo(contNumber,bl_No,import_Rotation_No).getContStatus();
        return cont_status;
    }


    public List getViewIgmSubDetalList(String import_Rotation_No, String bl_No,String contNumber){
        List<IgmDetails> findByImport_Rotation_NoAndBL_NoAndIgmDetailContainersContNumber = igmDetailsRepository.findByImportRotationNoAndBlNoAndIgmDetailContainersContNumber(import_Rotation_No,bl_No,contNumber);
        return findByImport_Rotation_NoAndBL_NoAndIgmDetailContainersContNumber;
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






    public List getViewIgmSubDetailContainer(String contNumber , String bl_No, String import_Rotation_No,String igmType,String priorValue,String newValue,String login_id){

        List<IgmCorrectionLog> findByContainer=new ArrayList<>();
        IgmCorrectionLog  igmCorrectionLog=new IgmCorrectionLog();
        Long igmContId = null;
        String contStatus="";

        String msg = "Blank";
        String edo_application_id = "";


        if(igmType == "" || igmType == " " || igmType == null)
        {
            msg = "Invalid Data.";
        }


        else
        {

            if(igmType.equals("dtl") ) {
                System.out.println("igmContId:" + igmType);
                System.out.println("igmContId:");
                System.out.println("contStatus:");
                List<IgmDetailContainer> findByContNumbers = igmDetailContainerRepository.findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo(contNumber, import_Rotation_No, bl_No);

                if (findByContNumbers.size() > 0)    // check again, if the data is valid
                {

                    igmType = "dtl";
                    igmContId = findByContNumbers.get(0).getId();
                    contStatus = findByContNumbers.get(0).getContStatus();

                    System.out.println("igmContId:" + igmContId);
                    System.out.println("contStatus:" + contStatus);

                    igmCorrectionLog.setRefTblId(igmContId);
                    igmCorrectionLog.setChangeType("Container");
                    igmCorrectionLog.setIgmType(igmType);
                    igmCorrectionLog.setChangeField("cont_status");
                    igmCorrectionLog.setPriorValue(priorValue);
                    igmCorrectionLog.setNewValue(newValue);
                    igmCorrectionLog.setEntryBy(login_id);
                    igmCorrectionLog.setEntryIp(request.getRemoteAddr());

                    IgmCorrectionLog respRole = igmCorrectionLogRepository.save(igmCorrectionLog);
                    System.out.println("respRole:" + respRole);


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
        msg = "Invalid Request !!!";

       findByContainer.add(igmCorrectionLog);

       return findByContainer;
    }





}
