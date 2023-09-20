package com.datasoft.pcs.Repository.sparcsn4;
import com.datasoft.pcs.Model.sparcsn4.RefRoutingPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RefRoutingPointRepository extends JpaRepository<RefRoutingPoint,Integer> {
    List<RefRoutingPoint> findAll();
}
