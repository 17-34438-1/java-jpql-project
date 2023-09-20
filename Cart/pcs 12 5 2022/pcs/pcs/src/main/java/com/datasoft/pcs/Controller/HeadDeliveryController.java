package com.datasoft.pcs.Controller;


import com.datasoft.pcs.Model.DTO.BillofEntryListDtoModel;
import com.datasoft.pcs.Model.cchaportdb.SadInfoModel;
import com.datasoft.pcs.Service.SadContainerService;
import com.datasoft.pcs.Service.SadInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/HeadDelivery")
public class HeadDeliveryController {
    @Autowired
    SadInfoService sadInfoService;

    @Autowired
    SadContainerService sadContainerService;


    @RequestMapping(value = "/BillOfEntryReport/{entryDate}", method= RequestMethod.GET)
    @ResponseBody
    public List getView( @PathVariable String entryDate) {
        List list =new ArrayList<>();
        list=sadInfoService.getViewIgmDetails(entryDate);
        return list;
    }

    @RequestMapping(value = "/BillOfEntrySadContainer/{entryDate}", method= RequestMethod.GET)
    @ResponseBody
    public List getContainerView( @PathVariable String entryDate) throws SQLException {

        List<SadInfoModel> list=sadContainerService.getSadContainer(entryDate);
        return list;
    }

}
