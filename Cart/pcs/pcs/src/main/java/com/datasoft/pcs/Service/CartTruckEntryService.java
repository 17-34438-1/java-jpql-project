package com.datasoft.pcs.Service;

import com.datasoft.pcs.Model.cchaportdb.DoTruckDetailsEntry;

import com.datasoft.pcs.Repository.cchaportdb.DoTruckDetailsEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartTruckEntryService {
    @Autowired
    DoTruckDetailsEntryRepository doTruckDetailsEntryRepository;


        public List getDoTruckDetailsEntry(String id)  {
            List<DoTruckDetailsEntry> doTruckDetailsEntries=new ArrayList<>();

            if(id!=""){
                doTruckDetailsEntries=doTruckDetailsEntryRepository.findById(id);
                Integer i=0;
                while (i< doTruckDetailsEntries.size()){
                    String updateBy;
                    updateBy=doTruckDetailsEntries.get(i).getUpdateBy();
                    System.out.println("updateBy:"+updateBy);
                    i++;

                }

            }

            else{
                LocalDate myObj = LocalDate.now();
                doTruckDetailsEntries=doTruckDetailsEntryRepository.findByLoadStAndGateOutStatusAndLastUpdateContains(1,0,myObj);
                Integer i=0;
                while (i< doTruckDetailsEntries.size()){

                    String updateBy;
                    updateBy=doTruckDetailsEntries.get(i).getUpdateBy();
                    System.out.println("updateBy:"+updateBy);
                    i++;

                }
            }
            return doTruckDetailsEntries;
        }


    public List getDoTruckDetailsByLoadStAndGateOutStatusAndLastUpdate()  {
        List<DoTruckDetailsEntry> doTruckDetailsEntries=new ArrayList<>();
        LocalDate myObj = LocalDate.now();
        doTruckDetailsEntries=doTruckDetailsEntryRepository.findByLoadStAndGateOutStatusAndLastUpdateContains(1,0,myObj);


        Integer i=0;
        while (i< doTruckDetailsEntries.size()){
            DoTruckDetailsEntry doTruckDetailsEntry=new DoTruckDetailsEntry();
            String updateBy;
            updateBy=doTruckDetailsEntries.get(i).getUpdateBy();
            System.out.println("updateBy:"+updateBy);
            i++;

        }
        System.out.println("Total Value:"+i);
        return doTruckDetailsEntries;
    }


}
