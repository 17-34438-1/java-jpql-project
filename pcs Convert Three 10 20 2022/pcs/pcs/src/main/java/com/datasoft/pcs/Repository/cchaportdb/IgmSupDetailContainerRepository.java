package com.datasoft.pcs.Repository.cchaportdb;



import com.datasoft.pcs.Model.cchaportdb.IgmSupDetailContainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IgmSupDetailContainerRepository  extends JpaRepository<IgmSupDetailContainer,Integer> {

    List<IgmSupDetailContainer> findByContNumberAndIgmSupplimentaryDetailImportRotationNoAndIgmSupplimentaryDetailBlNo(String contNumber, String import_Rotation_No, String bl_No);

}
