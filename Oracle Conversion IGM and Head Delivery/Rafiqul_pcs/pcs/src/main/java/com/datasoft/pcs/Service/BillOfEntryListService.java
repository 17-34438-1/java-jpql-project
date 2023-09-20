package com.datasoft.pcs.Service;


import com.datasoft.pcs.Model.DTO.BillOfEntryListModel;
import com.datasoft.pcs.Model.cchaportdb.SadContainer;
import com.datasoft.pcs.Model.cchaportdb.SadInfo;
import com.datasoft.pcs.Repository.cchaportdb.SadContainerRepository;
import com.datasoft.pcs.Repository.cchaportdb.SadInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class BillOfEntryListService {
    @Autowired
    SadInfoRepository sadInfoRepository;
    @Autowired
    SadContainerRepository sadContainerRepository;


    public List billOfEntryList(Long orgTypeId, String logInId){
        List<SadInfo> sadInfoList=new ArrayList<>();
        //    for subtructing cf from login id start
        String logIn_Id = logInId;
        String[] arrOfLoginId = logIn_Id.split("CF");
        String loginId_String=arrOfLoginId[0];
        //    for subtructing cf from login id end
         long decode=Long.parseLong(loginId_String);
       //        Long decode=301760607L;
       //        Long decode=arrOfLoginId[0]
        if(orgTypeId==2) {
            sadInfoList = sadInfoRepository.findBydecCode(decode);
        }
        else{
//             sadInfoList = sadInfoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
//             sadInfoList=sadInfoRepository.findAll(Sort.by("id").descending());
               sadInfoList = sadInfoRepository.findAll();

        }
        List<BillOfEntryListModel> resultList =new ArrayList<>();
        for(int i=0;i< sadInfoList.size();i++){
           BillOfEntryListModel resultModel=new BillOfEntryListModel();
            Long id;
            Integer containerNo=0;
            Long regNo=0L;
            String placeDec;
            Long officeCode;
            Long decCode=0L;
            Date regDate=new Date();
            id=sadInfoList.get(i).getId();
            regNo=sadInfoList.get(i).getRegNo();
            regDate=sadInfoList.get(i).getRegDate();
            placeDec=sadInfoList.get(i).getPlaceDec();
            officeCode =sadInfoList.get(i).getOfficeCode();
            decCode=sadInfoList.get(i).getDecCode();

            resultModel.setId(id);
            resultModel.setDecCode(decCode);
            resultModel.setOfficeCode(officeCode);
            resultModel.setPlaceDec(placeDec);
            resultModel.setRegNo(regNo);
            resultModel.setRegDate(regDate);


            List<SadContainer> list=sadContainerRepository.findBySadInfoRegNoAndSadInfoRegDate(regNo,regDate);
            //List<SadContainer> list=sadContainerRepository.findBySadInfoRegNo(regNo);
            containerNo=list.size();
            resultModel.setContainerNo(containerNo);
            resultList.add(resultModel);

        }

        return resultList;

    }

       //    for SearchList function
    public List searchBillList(Long orgTypeId, String logInId, String SearchCriteria ){
        List<SadInfo> sadInfoList1=new ArrayList<>();
        Long officeCode=0L;
        Date regDate=new Date();
        Date entryDate=new Date();
        Long regNo =0L;


        String logIn_id = logInId;
        String[] arrLoginId = logIn_id.split("CF");
        String loginIdStr=arrLoginId[0];
        long decCode=Long.parseLong(loginIdStr);
        if(orgTypeId==2){
            sadInfoList1  =sadInfoRepository.findBydecCode(decCode);
        }
        if(SearchCriteria=="search_office_code" ){
            sadInfoList1=sadInfoRepository.findByOfficeCodeAndDecCode( officeCode,decCode);
        }else if(SearchCriteria=="search_c_number"){
            sadInfoList1=sadInfoRepository.findByRegNoAndDecCode(regNo, decCode);
        } else if (SearchCriteria=="search_c_date") {
            sadInfoList1 =sadInfoRepository.findByRegDateAndDecCode(regDate, decCode);
        }else if(SearchCriteria=="search_entry_date"){
            sadInfoList1 =sadInfoRepository.findByEntryDateAndDecCode(entryDate, decCode);
        }else if(SearchCriteria=="search_cont_no"){

        }else {
//            sadInfoList1= sadInfoRepository.findAll();
        }
        return null;
    }
}
