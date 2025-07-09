package br.com.powtec.finance.database.library.repository;

import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.base.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.vehicle.VehicleFuelModel;

@Repository("vehicleFuelRepository")
public interface VehicleFuelRepository extends BaseCrudRepository<VehicleFuelModel>{

}
