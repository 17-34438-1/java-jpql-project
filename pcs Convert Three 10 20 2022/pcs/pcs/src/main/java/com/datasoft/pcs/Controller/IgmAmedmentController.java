package com.datasoft.pcs.Controller;

import com.datasoft.pcs.Model.DTO.ResponseMessage;
import com.datasoft.pcs.Service.IgmAmedmentChangeContainerStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/IgmAmedmentController")
public class IgmAmedmentController {

    @Autowired
    IgmAmedmentChangeContainerStatusService igmAmedmentChangeContainerStatusService;

    @RequestMapping(value = "/ViewIgmSubAmedmentList/{rotation}/{bl_no}/{container_no}", method= RequestMethod.GET)
    @ResponseBody
    public List getViewIgmSubDetailList(@PathVariable String rotation, @PathVariable String bl_no, @PathVariable String container_no
                                      )  {
        String Rotation=rotation.replace('_','/');
        System.out.println("rafiqul:"+Rotation);
        List list =new ArrayList<>();

        list=igmAmedmentChangeContainerStatusService.getViewIgmSubDetalList(Rotation,bl_no,container_no);


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

    @RequestMapping(value = "/IgmDetailContainerList/{container_no}/{bl_no}/{rotation}", method= RequestMethod.GET)
    @ResponseBody
    public String getViewIgmDetailContainer( @PathVariable String container_no  ,@PathVariable String bl_no,@PathVariable String rotation
    )  {
        String Rotation=rotation.replace('_','/');
        System.out.println("rafiqul:"+Rotation);


        String list=igmAmedmentChangeContainerStatusService.getViewIgmDetailContainerList(container_no,bl_no,Rotation);


        return list;
    }

    @RequestMapping(value = "/getViewIgmSubDetailContainer/{container_no}/{bl_no}/{rotation}/{igmType}/{priorValue}/{newValue}/{login_id}/{cont_status}", method= RequestMethod.POST)
    @ResponseBody
    public List getViewIgmSubDetailContainer(@PathVariable String container_no,@PathVariable String bl_no, @PathVariable String rotation , @PathVariable String igmType,@PathVariable  String priorValue,@PathVariable String newValue,@PathVariable  String login_id,@PathVariable String cont_status
    )  {
        String Rotation=rotation.replace('_','/');
        System.out.println("rafiqul:"+Rotation);
        List list =new ArrayList<>();
        list = igmAmedmentChangeContainerStatusService.getViewIgmSubDetailContainer(container_no,bl_no,Rotation,igmType,priorValue,newValue,login_id,cont_status);

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
