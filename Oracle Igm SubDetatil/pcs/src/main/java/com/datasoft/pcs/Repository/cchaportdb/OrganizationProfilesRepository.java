package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.IgmDetailContainer;
import com.datasoft.pcs.Model.cchaportdb.OrganizationProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizationProfilesRepository extends JpaRepository<OrganizationProfiles,Integer> {

   // List<OrganizationProfiles> findByIgmDetailContainersIgmDetailId(Integer id);


}
