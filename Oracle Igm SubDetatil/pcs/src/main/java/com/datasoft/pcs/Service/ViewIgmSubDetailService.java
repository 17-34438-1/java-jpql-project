package com.datasoft.pcs.Service;

import com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel;
import com.datasoft.pcs.Model.DTO.ViewIgmSubDetailMainModel;
import com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel;
import com.datasoft.pcs.Model.cchaportdb.IgmDetails;
import com.datasoft.pcs.Model.cchaportdb.OrganizationProfiles;
import com.datasoft.pcs.Repository.cchaportdb.IgmDetailContainerRepository;
import com.datasoft.pcs.Repository.cchaportdb.IgmDetailsRepository;
import com.datasoft.pcs.Repository.cchaportdb.OrganizationProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ViewIgmSubDetailService {
    @Autowired
    IgmDetailsRepository igmDetailsRepository;
    @Autowired
    IgmDetailContainerRepository igmDetailContainerRepository;
    @Autowired
    OrganizationProfilesRepository organizationProfilesRepository;

    @Autowired
    @Qualifier("cchaportdbEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    public List getViewIgmSubDetalList(String type, Integer limit, Integer start, Integer status, Integer code , Integer queryStatus ){
        List<ViewIgmSubDetailMainModel> mainResultList =new ArrayList<>();
        List<ViewIgmSubDetailModel> resultList =new ArrayList<>();
        ViewIgmSubDetailMainModel resultModel=new ViewIgmSubDetailMainModel();
        List<IgmDetails>list=new ArrayList<>();
        String mainQuery="";

        List<ViewIgmSubDetailModel> mainQueryList=new ArrayList<>();
        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        if(queryStatus==0){



            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                    "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                    "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                    "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                    "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                    "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                    "FROM  IgmDetails igms \n" +
                    "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                    "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"') \n" +
                    "AND igms.finalSubmit=1";
            // list=igmDetailsRepository.findByIgmIdAndIgmTypeAndFinalSubmit(code,type,1);
        }
        else{
           // list =igmDetailsRepository.findByIgmIdAndIgmTypeOrIgmTypeAndFinalSubmit(code,type,"GM",1);
            mainQuery="Select new com.datasoft.pcs.Model.DTO.ViewIgmSubDetailModel( igms.id,igms.igmId,igms.Import_Rotation_No, \n" +
                    "igms.Line_No, igms.BL_No,igms.Pack_Number, \n" +
                    "igms.Pack_Description,igms.Pack_Marks_Number,\n" +
                    "igms.Description_of_Goods,igms.Date_of_Entry_of_Goods, \n" +
                    "igms.weight,igms.weight_unit,igms.net_weight,igms.final_submit_date,\n" +
                    "igms.net_weight_unit, igms.Bill_of_Entry_No,igms.Bill_of_Entry_Date,\n" +
                    "igms.office_code,igms.No_of_Pack_Delivered, igms.No_of_Pack_Discharged,\n" +
                    "igms.Remarks,igms.AFR,igms.int_block,igms.R_No,igms.R_Date,\n" +
                    "igms.delivery_block_stat,igms.ConsigneeDesc,\n" +
                    "igms.NotifyDesc,igms.navy_comments,igms.Submitee_Org_Id,igms.mlocode,igms.igmType,\n" +
                    "igms.imco,igms.un,igms.extra_remarks,Navyresponse.response_details1,Navyresponse.response_details3,Navyresponse.response_details2,\n" +
                    "Navyresponse.hold_application,Navyresponse.rejected_application,Navyresponse.auto_no,\n" +
                    "Navyresponse.final_amendment , Navyresponse.appsubmitdate ,Navyresponse.navy_response_to_port,Navyresponse.permission_no,igms.Submission_Date)\n" +
                    "FROM  IgmDetails igms \n" +
                    "LEFT OUTER JOIN IgmNavyResponse  Navyresponse \n" +
                    "ON Navyresponse.igm_details_id =igms.id WHERE igms.igmId='"+code+"' AND (igms.igmType='"+type+"' or igms.igmType='GM') \n" +
                    "AND igms.finalSubmit=1 and (igms.PFstatus=1 or igms.PFstatus=10)";
        }
        mainQueryList =entitymanager.createQuery(mainQuery).getResultList();


        Integer resultSize=mainQueryList.size();
        List<ViewIgmSubDetailModel> mainQueryListLast=new ArrayList<>();

        for(int i=start;i<start+limit;i++){
            Integer submitee_Org_Id=0;
            String organizationName="";
            Integer ainNo=0;
            List<OrganizationProfiles> organizationNameList= new ArrayList<>();
            List<OrganizationProfiles> organizationAinNoList= new ArrayList<>();

            String organizationNameQuery="";
            String organizationAinNoQuery="";
            ViewIgmSubDetailModel viewIgmSubDetailModel=mainQueryList.get(i);
            submitee_Org_Id=viewIgmSubDetailModel.getSubmitee_Org_Id();
            organizationNameQuery="select orgs from OrganizationProfiles orgs where \n" +
                    "orgs.id="+submitee_Org_Id;

            organizationAinNoQuery="select orgs from OrganizationProfiles orgs where \n" +
                    "orgs.id="+submitee_Org_Id;
            System.out.println(organizationAinNoQuery);
            organizationNameList= entitymanager.createQuery(organizationNameQuery).getResultList();
            organizationAinNoList= entitymanager.createQuery(organizationAinNoQuery).getResultList();
            System.out.println(organizationNameList.get(0).getOrganizationName());
            System.out.println(organizationNameList.get(0).getAIN_No());
            if(organizationNameList.size()>0){
                organizationName=organizationNameList.get(0).getOrganizationName();
            }

            if(organizationAinNoList.size()>0){
                ainNo=organizationAinNoList.get(0).getAIN_No();

            }

            viewIgmSubDetailModel.setOrganization_Name(organizationName);
            viewIgmSubDetailModel.setAIN_No(ainNo);




            mainQueryListLast.add(viewIgmSubDetailModel);
        }

        for(int i=0;i<mainQueryListLast.size();i++){
            Integer id=0;
            ViewIgmSubDetailModel queryResultMainModel=mainQueryListLast.get(i);
            id=queryResultMainModel.getId();
            String result1Query="";
            String result2Query="";
            String result3Query="";
            String result4Query="";
            List<ViewIGMSubDetailResultModel> resultList1=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList2=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList3=new ArrayList<>();
            List<ViewIGMSubDetailResultModel> resultList4=new ArrayList<>();
             result1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(cnt.id,cnt.contNumber ,cnt.contSize ,cnt.contType ,\n" +
                    " cnt.cont_iso_type,cnt.contHeight,cnt.contStatus,\n" +
                    " cnt.contGrossWeight,cnt.contWeight,cnt.contSealNumber,\n" +
                    "cnt.contDescription,cnt.contImo,cnt.contUn,\n" +
                    "ogr.organizationName) from IgmDetailContainer cnt \n" +
                    "left join OrganizationProfiles ogr on cnt.offDockId=ogr.id\n" +
                     "where cnt.igmDetailId='"+id+"'";
            resultList1=entitymanager.createQuery(result1Query).getResultList();
            if(resultList1.size()>0){
                queryResultMainModel.setResultListFirst(resultList1);
            }


            result2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( cons.id,cons.igm_detail_id,cons.Consignee_ID," +
                    "cons.ff_clearance,2) from  IgmDetailConsigneetabs cons where cons.igm_detail_id='"+id+"'";
            resultList2=entitymanager.createQuery(result2Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList2=new ArrayList<>();
            for(int j=0;j<resultList2.size();j++){
                Integer consigneeID=0;
                String orgName="";
                String address1="";
                ViewIGMSubDetailResultModel result2Model=resultList2.get(j);
                consigneeID= result2Model.getConsignee_ID();
                String result2Sub1Query="";
                String result2Sub2Query="";
                List<ViewIGMSubDetailResultModel> result2Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result2Sub2QueryList=new ArrayList<>();
                result2Sub1Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org.organizationName,'orgName') from OrganizationProfiles org where org.id="+consigneeID;
                result2Sub2Query="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel( org1.Address_1,'address1') from OrganizationProfiles org1 where org1.id="+consigneeID;
                result2Sub1QueryList=entitymanager.createQuery(result2Sub1Query).getResultList();
                result2Sub2QueryList=entitymanager.createQuery(result2Sub2Query).getResultList();
                if(result2Sub1QueryList.size()>0){
                    orgName=result2Sub1QueryList.get(0).getOrganization_Name();
                }
                if(result2Sub2QueryList.size()>0){
                    address1=result2Sub2QueryList.get(0).getAddress_1();
                }
                result2Model.setOrganization_Name(orgName);
                result2Model.setAddress_1(address1);
                mainResultList2.add(result2Model);

            }
            List<ViewIGMSubDetailResultModel> resultListMain2=new ArrayList<>();
            for(int s=0;s<mainResultList2.size();s++){
                ViewIGMSubDetailResultModel result2MainModel=resultList2.get(s);
                String pfsStatusQuery="";
                Integer psf=0;
                List<ViewIGMSubDetailResultModel> pfsStatusQueryList=new ArrayList<>();
                pfsStatusQuery="select new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (igm.PFstatus) from IgmDetails igm where id='"+id+"'";
                pfsStatusQueryList=entitymanager.createQuery(pfsStatusQuery).getResultList();
                if(pfsStatusQueryList.size()>0){
                    psf=pfsStatusQueryList.get(0).getPFs();

                }
                result2MainModel.setPFs(psf);
                resultListMain2.add(result2MainModel);

            }
            queryResultMainModel.setResultListSecond(resultListMain2);

            result3Query="SELECT new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(notf.id,notf.igm_detail_id,notf.Notify_ID,\n" +
                    "notf.ff_clearance,3)FROM IgmDetailNotifyTabs notf WHERE notf.igm_detail_id='"+id+"'";
            resultList3=entitymanager.createQuery(result3Query).getResultList();
            List<ViewIGMSubDetailResultModel> mainResultList3=new ArrayList<>();
            for(int j=0;j<resultList3.size();j++){
                Integer Notify_ID=0;
                String result3OrgName="";
                String result3Address1="";
                ViewIGMSubDetailResultModel result3Model=resultList3.get(j);
                Notify_ID=result3Model.getNotify_ID();
                String result3Sub1Query="";
                String result3Sub2Query="";
                List<ViewIGMSubDetailResultModel> result3Sub1QueryList=new ArrayList<>();
                List<ViewIGMSubDetailResultModel> result3Sub2QueryList=new ArrayList<>();
                result3Sub1Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel(org.organizationName) FROM OrganizationProfiles org WHERE org.id="+Notify_ID;
                result3Sub2Query="SELECT  new com.datasoft.pcs.Model.DTO.ViewIGMSubDetailResultModel (org1.Address_1) FROM OrganizationProfiles org1 WHERE org1.id="+Notify_ID;
                result3Sub1QueryList=entitymanager.createQuery(result3Sub1Query).getResultList();
                result3Sub2QueryList=entitymanager.createQuery(result3Sub2Query).getResultList();
                if(result3Sub1QueryList.size()>0){
                    result3OrgName=  result3Sub2QueryList.get(0).getOrganization_Name();
                }
                if(result3Sub2QueryList.size()>0){
                    result3Address1=result3Sub2QueryList.get(0).getAddress_1();
                }
                result3Model.setOrganization_Name(result3OrgName);
                result3Model.setAddress_1(result3Address1);
                mainResultList3.add(result3Model);
            }
            queryResultMainModel.setResultListThird(mainResultList3);


            resultList.add(queryResultMainModel);
        }

        Integer actualSize=0;
        if((resultSize%5)==0){
            actualSize=resultSize/5;
        }
        else {
            actualSize=(resultSize/5)+1;
        }
        Integer a=0;
        Integer b=5;
        Integer c=5;
        System.out.println("page "+actualSize);
        List<ViewIgmSubDetailMainModel> pageList=new ArrayList<>();
        for(int k=1; k<=actualSize; k++){
            ViewIgmSubDetailMainModel paginationModel=new ViewIgmSubDetailMainModel();
            paginationModel.setPageStratLimit(a);
            paginationModel.setPageEndLimit(c);
            paginationModel.setSl(k);
            if(b<=(start+15) && start<=resultSize){
                paginationModel.setState(1);
            }
            else{
                paginationModel.setState(0);
            }

            a=b;
            b=b+5;
            pageList.add(paginationModel);
        }

        resultModel.setResultList(resultList);
        resultModel.setPagination(pageList);
        mainResultList.add(resultModel);




    /*   List tempList=new ArrayList();
        for(int i=0;i<mainQueryList.size();i++){
            Integer id=0;
             id=mainQueryList.get(i).getId();
            Query query = entitymanager.createQuery("Select e from IgmDetailContainer e LEFT OUTER JOIN  " +
                    "OrganizationProfiles p On e.offDockId=p.id where e.id=:id");



        }*/


       /*  entitymanager= entityManagerFactory.createEntityManager();
        Query query = entitymanager.createQuery("Select e.id,p.id from IgmDetailContainer e LEFT OUTER JOIN  " +
                "OrganizationProfiles p On e.offDockId=p.id where e.id=1");
       List<IgmDetailContainer> l=query.getResultList();*/

      // String e="";
       //entitymanager.createQuery(e,);
      //  List<IgmDetailContainer> l=igmDetailContainerRepository.all();




        return mainResultList;
    }

    class IgmDetailContainerResult implements RowMapper{
        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            ViewIgmSubDetailModel viewIgmSubDetailModel =new ViewIgmSubDetailModel();
            viewIgmSubDetailModel.setIGM_id(rs.getInt("igmDetailId"));
            viewIgmSubDetailModel.setOrganization_Name(rs.getString("organizationName"));
            return viewIgmSubDetailModel;
        }
    }
}
