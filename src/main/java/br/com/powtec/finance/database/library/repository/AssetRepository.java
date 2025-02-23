package br.com.powtec.finance.database.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.enums.AssetTypeEnum;
import br.com.powtec.finance.database.library.model.AssetModel;

@Repository
public interface AssetRepository extends JpaRepository<AssetModel, Long>, JpaSpecificationExecutor<AssetModel> {
  List<AssetModel> findAllByType(AssetTypeEnum type);

  @Query("""
      SELECT SUM(m.amount * m.unitValue) / SUM(m.amount)
      FROM AssetMovementModel m
      WHERE m.asset.id = :id
      AND m.operation = 'BUY'
      AND YEAR(m.date) <= :year
      """)
  Double calcAveragePrice(@Param("id") Long id, @Param("year") Integer year);

  @Query("""
      SELECT SUM(
        CASE
          WHEN m.operation = 'BUY' THEN m.amount
          ELSE m.amount * -1
        END
      ) AS current_amount
      FROM AssetMovementModel m
      WHERE m.asset.id = :id
      AND YEAR(m.date) <= :year
      """)
  Double calcCurrentAmount(@Param("id") Long id, @Param("year") Integer year);

  @Query("""
      SELECT SUM(m.amount * m.unitValue) / SUM(m.amount)
      FROM AssetMovementModel m
      WHERE m.asset.id = :id
      AND m.operation = 'BUY'
      AND YEAR(m.date) <= (:year - 1)
      """)
  Double calcAveragePriceYearBefore(@Param("id") Long id, @Param("year") Integer year);

  @Query("""
      SELECT SUM(
        CASE
          WHEN m.operation = 'BUY' THEN m.amount
          ELSE m.amount * -1
        END
      ) AS current_amount
      FROM AssetMovementModel m
      WHERE m.asset.id = :id
      AND YEAR(m.date) <= (:year -1)
      """)
  Double calcCurrentAmountYearBefore(@Param("id") Long id, @Param("year") Integer year);
}
