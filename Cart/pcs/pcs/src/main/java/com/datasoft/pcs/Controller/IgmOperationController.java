package com.datasoft.pcs.Controller;
import com.datasoft.pcs.Model.cchaportdb.SadInfoModel;
import com.datasoft.pcs.Service.IgmCommudityService;
import com.datasoft.pcs.Service.IgmInfoByBlNumberServices;
import com.datasoft.pcs.Service.IgmOffdockInformationService;
import com.datasoft.pcs.Service.RoutingPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/IgmOpetation")
public class IgmOperationController {
    @Autowired
    IgmCommudityService igmCommudityService;


    @Autowired
    IgmOffdockInformationService igmOffdockInformationService;


    @Autowired
    RoutingPointService routingPointService;

    @Autowired
    IgmInfoByBlNumberServices igmInfoByBlNumberServices;

    @RequestMapping(value = "/IgmOpetation/CommudityList", method= RequestMethod.GET)
    @ResponseBody
    public List getIgmCommudityList()  {
        List list =new ArrayList<>();
        list=igmCommudityService.getIgmCommudity();
        return list;
    }

    @RequestMapping(value = "/IgmOpetation/OffDockInformation", method= RequestMethod.GET)
    @ResponseBody
    public List getIgmOffDockInfoList()  {
        List list =new ArrayList<>();
        list=igmOffdockInformationService.myoffDociew();
        return list;
    }
    @RequestMapping(value = "/IgmOpetation/routingPoint", method= RequestMethod.GET)
    @ResponseBody
    public List getRoutingPoint()  {
        List list =new ArrayList<>();
        list=routingPointService.getRoutingPoint();
        return list;
    }


//    @RequestMapping(value = "/IgmOpetation/routingPoint", method= RequestMethod.GET)
//    @ResponseBody
//    public List getIgmInfoByBlNumber(String bl)  {
//        List list =new ArrayList<>();
//        list=igmInfoByBlNumberServices.getIgmInfoByBlNumber(bl);
//        return list;
//    }


    @RequestMapping(value = "/IgmOpetation/{bl}", method= RequestMethod.GET)
    @ResponseBody
    public List getIgmInfoByBlNumber( @PathVariable String bl){
        System.out.println("blNo:"+bl);
        List list =new ArrayList<>();
        list=igmInfoByBlNumberServices.getIgmInfoByBlNumber(bl);
        return list;
    }

}
