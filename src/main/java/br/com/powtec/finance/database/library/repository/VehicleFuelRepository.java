package br.com.powtec.finance.database.library.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.base.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.vehicle.VehicleFuelModel;

@Repository("vehicleFuelRepository")
public interface VehicleFuelRepository extends BaseCrudRepository<VehicleFuelModel>{

    @Query("SELECT v FROM VehicleFuelModel v WHERE v.date < :date AND v.vehicle.id = :vehicleId ORDER BY v.date DESC limit 1")
    VehicleFuelModel findLastByDateAndVehicleId(@Param("date") LocalDate date, @Param("vehicleId") Long vehicleId);

    @Query("SELECT v FROM VehicleFuelModel v WHERE v.date > :date AND v.vehicle.id = :vehicleId ORDER BY v.date ASC limit 1")
    VehicleFuelModel findNextByDateAndVehicleId(@Param("date") LocalDate date, @Param("vehicleId") Long vehicleId);
}
