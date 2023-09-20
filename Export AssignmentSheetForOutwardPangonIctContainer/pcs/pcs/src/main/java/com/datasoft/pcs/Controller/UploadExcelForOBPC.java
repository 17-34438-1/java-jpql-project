package com.datasoft.pcs.Controller;

import com.datasoft.pcs.Service.UploadExcelforOBPCandRLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value="/Pangaon")
public class UploadExcelForOBPC {
    @Autowired
    UploadExcelforOBPCandRLService uploadExcelforOBPCandRLService;

    // Upload Excel File For Pangaon
    @RequestMapping(value = "/UploadExcelFileForPangaon", method= RequestMethod.POST)
    @ResponseBody
    public List uploadExcelFileForPangaon(@RequestParam("excelfile") MultipartFile multipartFile, @RequestParam("loginId") String loginId, @RequestParam("ip") String ip) throws IOException, IOException {
        List list =new ArrayList<>();
        uploadExcelforOBPCandRLService.storeFile(multipartFile);
        list=uploadExcelforOBPCandRLService.uploadExcelFile(multipartFile,loginId,ip);

        return list;
    }


}
