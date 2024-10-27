package br.com.powtec.finance.database.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.enums.AssetTypeEnum;
import br.com.powtec.finance.database.library.model.AssetModel;

@Repository
public interface AssetRepository extends JpaRepository<AssetModel, Long>, JpaSpecificationExecutor<AssetModel> {
  public List<AssetModel> findAllByType(AssetTypeEnum type);
}
