package br.com.powtec.finance.database.library.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.movement.AssetMovementModel;

@Repository("assetMovementRepository")
public interface AssetMovementRepository
        extends MovementRepository<AssetMovementModel> {
    List<AssetMovementModel> findAllByAssetId(Long id);
}
