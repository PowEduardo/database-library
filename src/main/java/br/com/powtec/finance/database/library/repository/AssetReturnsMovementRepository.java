package br.com.powtec.finance.database.library.repository;

import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.movement.AssetReturnsMovementModel;

@Repository
public interface AssetReturnsMovementRepository extends MovementRepository<AssetReturnsMovementModel>{

}
