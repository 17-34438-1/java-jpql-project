package com.datasoft.pcs.Service;

import com.datasoft.pcs.Model.DTO.BillOfEntryListModel;
import com.datasoft.pcs.Model.cchaportdb.SadContainer;
import com.datasoft.pcs.Model.cchaportdb.SadInfo;
import com.datasoft.pcs.Repository.cchaportdb.SadContainerRepository;
import com.datasoft.pcs.Repository.cchaportdb.SadInfoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;



@Service
public class BillOfEntryListService {
    @Autowired
    SadInfoRepository sadInfoRepository;
    @Autowired
    SadContainerRepository sadContainerRepository;



    public List billOfEntryList(Long orgTypeId, String logInId){
        List<SadInfo> sadInfoList=new ArrayList<>();
        String logIn_Id = logInId;
        String[] arrOfLoginId = logIn_Id.split("CF");
        String loginId_String=arrOfLoginId[0];

         long decode=Long.parseLong(loginId_String);
       //        Long decode=301760607L;
        if(orgTypeId==2) {
            sadInfoList = sadInfoRepository.findByDecCode(decode);
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
            String regDate;
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

       //    for SearchList(SearchListBe) function
    public List searchBillList(Long orgTypeId, String logInId, String searchCriteria, String searchValue){
//        List<SadInfo> sadInfoList1=new ArrayList<>();
                List sadInfoList1=new ArrayList<>();
                System.out.println(searchValue);



        Long regNo =0L;
        Long search_office_code = 0L;
        String reg_Date;
        String logIn_id = logInId;
        String[] arrLoginId = logIn_id.split("CF",-2);
        String loginIdStr=arrLoginId[0];
        long decCode=Long.parseLong(loginIdStr);
        if(orgTypeId==2){
            sadInfoList1  =sadInfoRepository.findByDecCode(decCode);
        }
        if(searchCriteria.equals("office_code") ){
            long office_Code=Long.parseLong(searchValue);
            sadInfoList1=sadInfoRepository.findByOfficeCodeAndDecCode(office_Code,decCode);
        }
        else if( searchCriteria.equals("c_number")){
            long reg_Number=Long.parseLong(searchValue);
            sadInfoList1=sadInfoRepository.findByRegNoAndDecCode(reg_Number, decCode);
        }
        else if (searchCriteria.equals("c_date")) {
            sadInfoList1=sadInfoRepository.findByRegDateAndDecCode(searchValue,decCode);
        }

        else if(searchCriteria.equals("entry_date")){
            System.out.println("entryDate"+searchValue);
            sadInfoList1 =sadInfoRepository.findByEntryDateAndDecCode(searchValue, decCode);
        }

        else if(searchCriteria.equals("cont_no")){
            sadInfoList1 = sadInfoRepository.findByDecCodeAndSadContainerListContNumber(decCode,searchValue);
        }

        return sadInfoList1;
    }
}
