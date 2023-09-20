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
                                        @PathVariable Integer status, @PathVariable Integer code, @PathVariable Integer queryStatus)  {
        List list =new ArrayList<>();

        list=viewIgmSubDetailService.getViewIgmSubDetalList(type,limit,start,status,code,queryStatus);


        return list;
    }
}
