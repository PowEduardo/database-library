package br.com.powtec.finance.database.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.VehicleModel;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleModel, Long>, JpaSpecificationExecutor<VehicleModel> {

}
