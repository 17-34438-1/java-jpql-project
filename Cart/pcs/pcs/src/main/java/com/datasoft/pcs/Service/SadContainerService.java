package com.datasoft.pcs.Service;
import com.datasoft.pcs.Model.DTO.BillofEntryListDtoModel;
import com.datasoft.pcs.Repository.cchaportdb.SadInfoModelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;
@Service
public class SadContainerService {
    @Autowired
    SadInfoModelRepository sadInfoModelRepository;


    @Autowired
    @Qualifier("cchaportdbEntityManagerFactory")
    EntityManagerFactory entityManagerFactory;

    public List getSadContainer(String entryDate) throws SQLException {
        List<BillofEntryListDtoModel>  resultList=new ArrayList<>();
        Connection con42 = DriverManager.getConnection("jdbc:mysql://192.168.16.42/cchaportdb","user1","user1test");
        Statement st42 = con42.createStatement();

        EntityManager entitymanager= entityManagerFactory.createEntityManager();
        String mainQuery="";
        String ip_address="";
        Integer total;
        Integer total_Entry=0;
        mainQuery="SELECT COUNT(*) AS tot_entry,ip_address,entry_dt\n" +
                "FROM sad_info\n" +
                "WHERE DATE(entry_dt)='"+entryDate+"'\n" +
                "GROUP BY ip_address";
        ResultSet rslt_berthOptRpt = st42.executeQuery(mainQuery);


        BillofEntryListDtoModel billofEntryListDtoModels=new BillofEntryListDtoModel();
        while(rslt_berthOptRpt.next()) {
            BillofEntryListDtoModel billofEntryListDtoModel=new BillofEntryListDtoModel();
            total=rslt_berthOptRpt.getInt("tot_entry");
            total_Entry=total_Entry+total;
            ip_address=rslt_berthOptRpt.getString("ip_address");
            entryDate=rslt_berthOptRpt.getString("entry_dt");
            billofEntryListDtoModel.setEntry_dt(entryDate);
            billofEntryListDtoModel.setIp_address(ip_address);
            billofEntryListDtoModel.setTotal(total);
            System.out.println("Ip_address:"+ip_address);
            System.out.println("total:"+total);
            resultList.add(billofEntryListDtoModel);
        }
        billofEntryListDtoModels.setTotalEnty(total_Entry);
        resultList.add(billofEntryListDtoModels);

        return resultList;
    }
}
