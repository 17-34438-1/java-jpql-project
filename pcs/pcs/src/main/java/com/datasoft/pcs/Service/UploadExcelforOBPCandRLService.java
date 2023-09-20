package com.datasoft.pcs.Service;


import com.datasoft.pcs.Model.DTO.UploadExcel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UploadExcelforOBPCandRLService {


    private final Path fileStorageLocation ;



    @Autowired
    public UploadExcelforOBPCandRLService(Environment env){
        this.fileStorageLocation = Paths.get(env.getProperty("app.file.upload-excelForObpc-dir", "./uploads/excelForObpc/excelfiles"))
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new RuntimeException(
                    "Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public UploadExcelforOBPCandRLService(Path fileStorageLocation) {
        this.fileStorageLocation = fileStorageLocation;
    }


    public String storeFile(MultipartFile file) {
        // Normalize file name
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTime=formatter.format(new Date());
        String dateTimeArr[] = dateTime.split(" ");
        String date="";
        String time="";
        String hour="";
        String minute="";
        String second="";

        date=dateTimeArr[0];
        time=dateTimeArr[1];
        String timeArr[]=time.split(":");
        hour=timeArr[0];
        minute=timeArr[1];
        second=timeArr[2];



        String fileName =
                date+"_"+hour+"-"+minute+"-"+second+"_"+file.getOriginalFilename();

        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }



    public List uploadExcelFile(MultipartFile multipartFile, String updateby, String ip)  throws IOException {
        List resultList=new ArrayList();
        UploadExcel resultModel=new UploadExcel();
        Integer excelTotalRow=0;
        Integer totalResultRow=0;
        Integer i=1;
        HSSFWorkbook workbook=new HSSFWorkbook(multipartFile.getInputStream());
        HSSFSheet worksheet=workbook.getSheetAt(0);
        excelTotalRow=worksheet.getPhysicalNumberOfRows();
        System.out.println(excelTotalRow);

        while (i<excelTotalRow){
            String cellValue="";
            try{
                HSSFRow row=worksheet.getRow(i);
                Cell cell=row.getCell(2);
                cellValue=cell.getStringCellValue().trim();

            }catch (NullPointerException e){

            }

            System.out.println(cellValue+" i: "+ i);
            if(!cellValue.equals("")){
                totalResultRow=totalResultRow+1;


            }
            i=i+1;
        }
        System.out.println("totalRow :"+totalResultRow);

        Integer row=1;
        Integer stat=0;
        i=0;
        while(row < (totalResultRow+1)){
            Integer yes=0;
            String mlo="";
            String cont_no="";
            String visit="";
            Integer weight=0;
            String category="";
            String status="";
            String seal="";
            mlo=worksheet.getRow(row).getCell(1).getStringCellValue();
            cont_no=worksheet.getRow(row).getCell(2).getStringCellValue();
            visit=worksheet.getRow(row).getCell(6).getStringCellValue();
            weight=(int) worksheet.getRow(row).getCell(7).getNumericCellValue();

            seal=worksheet.getRow(row).getCell(10).getStringCellValue();
            cont_no=cont_no.replaceAll("[^A-Za-z0-9]","").trim();
            System.out.println("cont_no "+cont_no);
            System.out.println("row "+row);

            if(yes>0){
                stat = stat+1;
            }
            else{
                stat = stat;
            }
            row=row+1;
        }

        resultList.add(resultModel);

        return resultList;
    }



}
