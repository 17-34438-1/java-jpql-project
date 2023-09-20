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
public class SadInfoService {
    @Autowired
    SadInfoRepository sadInfoRepository;
    @Autowired
    SadContainerRepository sadContainerRepository;

//    public List getViewIgmDetailsLists(Integer asyId ){
//        System.out.println("entryDt:"+asyId);
//        List<SadInfo> findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo = sadInfoRepository.findByAsyId(asyId);
//        return findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo;
//    }

//    public List getViewIgmDetailsList(String IpAddress ){
//        System.out.println("IpAddress:"+IpAddress);
//        List<SadInfo> findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo = sadInfoRepository.findByIpAddress(IpAddress);
//        return findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo;
//    }

//    public List getViewIgmDetails(String entryDate)  {
//       System.out.println(entryDate);
//     List<SadInfo>  result = sadInfoRepository.findByEntryDateContains(entryDate);
//        return result;
//    }




    public List getViewIgmDetails(String entryDate)  {
        List<SadInfo> sadInfoList=new ArrayList<>();
       System.out.println(entryDate);
        sadInfoList = sadInfoRepository.findByEntryDateContains(entryDate);
        List<BillOfEntryListModel> resultList =new ArrayList<>();
        Integer m=0;
        int i=0;
        BillOfEntryListModel resultModel=new BillOfEntryListModel();
        while (i< sadInfoList.size()){


            System.out.println("result:"+sadInfoList.size());
            BillOfEntryListModel resultModels=new BillOfEntryListModel();
            Long id;
            Integer containerNo=0;
            Long regNo=0L;
            String placeDec;
            Long officeCode;
            Long decCode=0L;

            String regDate;
            String ipAddress;


            id=sadInfoList.get(i).getId();
            regNo=sadInfoList.get(i).getRegNo();
            regDate=sadInfoList.get(i).getRegDate();
            placeDec=sadInfoList.get(i).getPlaceDec();

            //totEntry=sadInfoList.get(i).getTotEntry();


            System.out.println("placeDec:"+placeDec);


            if(!placeDec.equals("")){
                m++;
            }

            officeCode =sadInfoList.get(i).getOfficeCode();
            decCode=sadInfoList.get(i).getDecCode();
            entryDate=sadInfoList.get(i).getEntryDate();

            ipAddress=sadInfoList.get(i).getIpAddress();
            //System.out.println("ipAddress:"+ipAddress.length());
            resultModels.setId(id);
            resultModels.setDecCode(decCode);
            resultModels.setOfficeCode(officeCode);
            resultModels.setPlaceDec(placeDec);
            resultModels.setRegNo(regNo);
            resultModels.setRegDate(regDate);
            resultModels.setEntryDate(entryDate);
            resultModels.setIpAddress(ipAddress);



            List<SadContainer> list=sadContainerRepository.findBySadInfoRegNoAndSadInfoRegDate(regNo,regDate);


            containerNo=list.size();

            System.out.println("ContainerNo:"+containerNo);
            resultModels.setContainerNo(containerNo);
            resultList.add(resultModels);
            i++;
        }
        resultModel.setTotalCount(i);
        System.out.println("incrimantal value:"+i);
        resultModel.setPlaceDecCount(m);
        resultList.add(resultModel);
        return resultList;
    }



}
