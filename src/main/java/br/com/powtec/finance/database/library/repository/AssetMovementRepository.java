package br.com.powtec.finance.database.library.repository;

import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.movement.AssetMovementModel;

@Repository
public interface AssetMovementRepository extends MovementRepository<AssetMovementModel>{

}
