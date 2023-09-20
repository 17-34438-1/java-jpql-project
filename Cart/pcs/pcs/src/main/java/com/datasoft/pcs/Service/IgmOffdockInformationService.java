package com.datasoft.pcs.Service;

import com.datasoft.pcs.Model.ctmsmis.OffdockInformation;
import com.datasoft.pcs.Repository.ctmsmis.OffdockInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IgmOffdockInformationService {
    @Autowired
    OffdockInformationRepository offdockInformationRepository;

    public List myoffDociew(){
        List<OffdockInformation> offdockInformations=new ArrayList<>();

        offdockInformations=offdockInformationRepository.findAll();

       return offdockInformations;
        }
}
