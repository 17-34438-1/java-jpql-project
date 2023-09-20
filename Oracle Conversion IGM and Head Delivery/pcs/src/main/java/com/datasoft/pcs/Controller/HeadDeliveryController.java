package com.datasoft.pcs.Controller;

import com.datasoft.pcs.Service.BillOfEntryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/HeadDelivery")
public class HeadDeliveryController {
    @Autowired
    BillOfEntryListService billOfEntryListService;




    @RequestMapping(value = "/BillOfEntryList/{orgTypeId}/{logInId}",method = RequestMethod.GET)
    @ResponseBody
    public List billOfEntryList(@PathVariable Long orgTypeId, @PathVariable String logInId ){
        List list =new ArrayList();
        list=billOfEntryListService.billOfEntryList(orgTypeId,logInId);
        return list;
    }

    //  for searchBeList
    @RequestMapping(value = "/SearchBillList/{orgTypeId}/{logInId}/{searchCriteria}/{searchValue}",method = RequestMethod.GET)
    @ResponseBody
    public List searchBillList(@PathVariable Long orgTypeId,@PathVariable String logInId,@PathVariable String searchCriteria,@PathVariable String searchValue){
        List list =new ArrayList();
        list=billOfEntryListService.searchBillList(orgTypeId,logInId,searchCriteria,searchValue);
        return list;
    }

}
