package com.datasoft.pcs.Controller;

import com.datasoft.pcs.Service.CartTruckEntryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/CartEntry")
public class CartTicketController {


    @Autowired
    CartTruckEntryService cartTruckEntryService;

    @RequestMapping(value = "/CartEntryReport/{id}", method= RequestMethod.GET)
    @ResponseBody
    public List getViewCartTicket(@PathVariable String id) {
        List list =new ArrayList<>();
        list=cartTruckEntryService.getDoTruckDetailsEntry(id);
        return list;
    }

    @RequestMapping(value = "/CartEntryReport", method= RequestMethod.GET)
    @ResponseBody


    public List getDoTruckDetailsByLoadStAndGateOutStatusAndLastUpdate() {
        List list =new ArrayList<>();
        list=cartTruckEntryService.getDoTruckDetailsByLoadStAndGateOutStatusAndLastUpdate();
        return list;
    }


}
