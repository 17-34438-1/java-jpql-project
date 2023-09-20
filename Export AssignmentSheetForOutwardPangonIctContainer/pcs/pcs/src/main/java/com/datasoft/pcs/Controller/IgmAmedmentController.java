package com.datasoft.pcs.Controller;


import com.datasoft.pcs.Service.IgmAmedmentChangeContainerStatusService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/IgmAmedmentController")
public class IgmAmedmentController {

    @Autowired
    IgmAmedmentChangeContainerStatusService igmAmedmentChangeContainerStatusService;

    @RequestMapping(value = "/ViewIgmSubAmedmentList/{container_no}/{rotation}/{bl_no}", method= RequestMethod.GET)
    @ResponseBody
    public List getViewIgmSubDetailList(@PathVariable String container_no,@PathVariable String rotation, @PathVariable String bl_no
                                      )  {
        String Rotation=rotation.replace('_','/');

        List list =new ArrayList<>();
        list=igmAmedmentChangeContainerStatusService.getViewIgmSubDetalList(container_no,Rotation,bl_no);
        return list;
    }

    @RequestMapping(value = "/ViewIgmDetailContainerList/{container_no}/{rotation}/{bl_no}", method= RequestMethod.GET)
    @ResponseBody
    public List getViewIgmDetailContainerList( @PathVariable String container_no ,@PathVariable String rotation, @PathVariable String bl_no
                                      )  {
        String Rotation=rotation.replace('_','/');
        System.out.println("rafiqul:"+Rotation);
        List list =new ArrayList<>();

        list=igmAmedmentChangeContainerStatusService.getViewIgmDetailContainerLists(container_no,Rotation,bl_no);


        return list;
    }
   @RequestMapping(value = "/ViewIgmDetailsList/{rotation}/{bl_no}/{container_no}", method= RequestMethod.GET)
    @ResponseBody
    public List getViewIgmDetailsLists( @PathVariable String rotation, @PathVariable String bl_no,@PathVariable String container_no
                                      )  {
        String Rotation=rotation.replace('_','/');
        System.out.println("rafiqul:"+Rotation);
        List list =new ArrayList<>();

        list=igmAmedmentChangeContainerStatusService.getViewIgmDetailsLists(Rotation,bl_no,container_no);


        return list;
    }



    @RequestMapping(value = "/getViewIgmSubDetailContainer/{container_no}/{rotation}/{bl_no}/{contStatus}/{igmType}/{login_id}", method= RequestMethod.GET)

    @ResponseBody

    public List getViewIgmSubDetailContainer(@PathVariable String container_no,@PathVariable String rotation , @PathVariable String bl_no,@PathVariable  String contStatus, @PathVariable String igmType,@PathVariable  String login_id)  {
        String Rotation=rotation.replace('_','/');
        System.out.println("rafiqul:"+Rotation);
        List list =new ArrayList<>();
        list = igmAmedmentChangeContainerStatusService.getViewIgmSubDetailContainer(container_no,Rotation,bl_no,contStatus,igmType,login_id);

        return list;

    }



    @RequestMapping(value = "/getViewIgmSubDetalListForUpdate/{container}/{rotation}/{bl_no}", method= RequestMethod.PUT)
    @ResponseBody
    public List getViewIgmSubDetalListForUpdate(@PathVariable String container,@PathVariable String rotation,@PathVariable String bl_no)  {
        String Rotation=rotation.replace('_','/');
        List list =new ArrayList<>();
        list = igmAmedmentChangeContainerStatusService.getViewIgmSubDetalListForUpdate(container,Rotation,bl_no);

        return list;

    }



    @RequestMapping(value = "/ViewIgmSubDetailContainerList/{container_no}/{rotation}/{bl_no}", method= RequestMethod.POST)
    @ResponseBody
    public List getViewIgmSubDetailContainerList(@PathVariable String container_no ,@PathVariable String rotation, @PathVariable String bl_no)  {
        String Rotation=rotation.replace('_','/');
        System.out.println("rafiqul:"+Rotation);
        List list =new ArrayList<>();

        list=igmAmedmentChangeContainerStatusService.getViewIgmSubDetailContainerLists(container_no,Rotation,bl_no);


        return list;
    }

//    @RequestMapping(value = "/pdoList/Data", method = RequestMethod.POST, consumes="application/json")
//    public List listTestforDischarge(@RequestBody PodList podlist) throws SQLException {
//        String place_code = podlist.getPlace_code();
//        return podList.PODLIST(place_code);
//    }





}
