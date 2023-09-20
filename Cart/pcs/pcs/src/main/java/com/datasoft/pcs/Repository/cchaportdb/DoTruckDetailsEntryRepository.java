package com.datasoft.pcs.Repository.cchaportdb;

import com.datasoft.pcs.Model.cchaportdb.DoTruckDetailsEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DoTruckDetailsEntryRepository extends JpaRepository<DoTruckDetailsEntry,Integer> {
    List<DoTruckDetailsEntry> findById(String id);
    List<DoTruckDetailsEntry> findByLoadStAndGateOutStatusAndLastUpdateContains(Integer loadSt, Integer gateOutStatus, LocalDate lastUpdate);
}
