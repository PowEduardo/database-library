package br.com.powtec.finance.database.library.repository;

import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.base.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.vehicle.VehiclePartModel;

@Repository("vehiclePartRepository")
public interface VehiclePartRepository extends BaseCrudRepository<VehiclePartModel> {

}
