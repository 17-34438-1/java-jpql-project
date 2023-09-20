package com.datasoft.pcs.Repository.sparcsn4;

import com.datasoft.pcs.Model.sparcsn4.VslVesselVisitDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VslVesselVisitDetailsRepository  extends JpaRepository<VslVesselVisitDetails,Integer> {
    List<VslVesselVisitDetails> findByIbVyg(String rotation);

}
