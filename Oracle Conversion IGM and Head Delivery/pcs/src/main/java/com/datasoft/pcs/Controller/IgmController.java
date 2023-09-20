package com.datasoft.pcs.Controller;

import com.datasoft.pcs.Service.ViewIgmSubDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/IgmOperation")
public class IgmController {
    @Autowired
    ViewIgmSubDetailService viewIgmSubDetailService;

    @RequestMapping(value = "/ViewIgmSubDetailList/{type}/{limit}/{start}/{status}/{code}/{queryStatus}", method= RequestMethod.GET)
    @ResponseBody
    public List getViewIgmSubDetailList(@PathVariable String type, @PathVariable Integer limit, @PathVariable Integer start,
                                        @PathVariable Integer status, @PathVariable Long code, @PathVariable Integer queryStatus)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.getViewIgmSubDetalList(type,limit,start,status,code,queryStatus);


        return list;
    }

    @RequestMapping(value = "/ViewIgmSubDetailSearch/{code}/{role}/{orgTpeId}/{type}", method= RequestMethod.GET)
    @ResponseBody
    public List viewIgmSubDetailSearch(@PathVariable Long code, @PathVariable Integer role,  @PathVariable Integer orgTpeId,@PathVariable String type)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.viewIgmDeatailSearch(code,role,orgTpeId,type);


        return list;
    }

    @RequestMapping(value = "/SearchIgmSubmittedByMlo/{type}/{status}/{code}/{queryStatus}/{orgTypeId}", method= RequestMethod.GET)
    @ResponseBody
    public List searchIgmSubmittedByMlo(@PathVariable String type,@PathVariable Integer status, @PathVariable Long code,
                                        @PathVariable Integer queryStatus,@PathVariable Long orgTypeId)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.searchIgmSubmittedByMlo(type,status,code,queryStatus,orgTypeId);


        return list;
    }

    @RequestMapping(value = "/SearchIgmSubmittedBySAF/{type}/{status}/{code}/{queryStatus}/{orgTypeId}", method= RequestMethod.GET)
    @ResponseBody
    public List searchIgmSubmittedBySAF(@PathVariable String type,@PathVariable Integer status, @PathVariable Long code,
                                        @PathVariable Integer queryStatus,@PathVariable Long orgTypeId)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.searchIgmSubmittedBySAF(type,status,code,queryStatus,orgTypeId);


        return list;
    }


    @RequestMapping(value = "/SearchByMloCode/{type}/{status}/{code}/{queryStatus}/{orgTypeId}", method= RequestMethod.GET)
    @ResponseBody
    public List searchByMloCode(@PathVariable String type,@PathVariable Integer status, @PathVariable Long code,
                                        @PathVariable Integer queryStatus,@PathVariable String orgTypeId)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.searchByMloCode(type,status,code,queryStatus,orgTypeId);


        return list;
    }



}
