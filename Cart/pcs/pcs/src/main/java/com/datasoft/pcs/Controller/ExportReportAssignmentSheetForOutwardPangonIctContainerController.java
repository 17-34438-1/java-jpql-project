package com.datasoft.pcs.Controller;

import com.datasoft.pcs.Service.ExportReportAssignmentSheetForOutwardPangonIctContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/ExportReportAssignmentSheetForOutwardPangonIctContainer")
public class ExportReportAssignmentSheetForOutwardPangonIctContainerController {
    @Autowired
    ExportReportAssignmentSheetForOutwardPangonIctContainer exportReportAssignmentSheetForOutwardPangonIctContainer;
    @RequestMapping(value = "/AssignmentSheetForOutwardPangon/{rotation}", method= RequestMethod.GET)
    @ResponseBody
    public List getAssignmentSheetForOutwardPangon(@PathVariable String rotation) {
        List list =new ArrayList<>();
        list=exportReportAssignmentSheetForOutwardPangonIctContainer.getAssignmentSheetForOutwardPangonIctContainer(rotation);
        return list;
    }

}
