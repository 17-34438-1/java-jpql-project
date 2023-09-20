package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmDetailContainer;
import com.datasoft.pcs.Model.cchaportdb.IgmSupDetailContainer;
import com.datasoft.pcs.Model.cchaportdb.IgmSupplimentaryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IgmSupplimentaryDetailRepository  extends JpaRepository<IgmSupplimentaryDetail,Integer> {
//    List<IgmDetailContainer> findByContNumberAndIgmDetailsImportRotationNoAndIgmDetailsBlNo(String contNumber, String import_Rotation_No, String bl_No);
//    IgmDetailContainer findByContNumberAndIgmDetailsBlNoAndIgmDetailsImportRotationNo( String contNumber, String bl_No,String import_Rotation_No);

//    List<IgmSupplimentaryDetail> findByContNumberAndIgmSupplimentaryDetailsImportRotationNoAndIgmSupplimentaryDetailsBlNo(String contNumber, String import_Rotation_No, String bl_No);

}
