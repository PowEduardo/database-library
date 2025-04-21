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
      SELECT ROUND(SUM(m.amount * m.unitValue) / SUM(m.amount), 2)
      FROM AssetMovementModel m
      WHERE m.asset.id = :id
      AND m.operation IN ('BUY', 'SPLIT')
      AND YEAR(m.date) <= :year
      """)
  Double calcAveragePrice(@Param("id") Long id, @Param("year") Integer year);

  @Query("""
      SELECT SUM(
        CASE
          WHEN m.operation IN ('BUY', 'SPLIT') THEN m.amount
          ELSE m.amount * -1
        END
      ) AS current_amount
      FROM AssetMovementModel m
      WHERE m.asset.id = :id
      AND YEAR(m.date) <= :year
      """)
  Double calcCurrentAmount(@Param("id") Long id, @Param("year") Integer year);

  @Query("""
      SELECT ROUND(SUM(m.amount * m.unitValue) / SUM(m.amount), 2)
      FROM AssetMovementModel m
      WHERE m.asset.id = :id
      AND m.operation IN ('BUY', 'SPLIT')
      AND YEAR(m.date) <= (:year - 1)
      """)
  Double calcAveragePriceYearBefore(@Param("id") Long id, @Param("year") Integer year);

  @Query("""
      SELECT SUM(
        CASE
          WHEN m.operation IN ('BUY', 'SPLIT') THEN m.amount
          ELSE m.amount * -1
        END
      ) AS current_amount
      FROM AssetMovementModel m
      WHERE m.asset.id = :id
      AND YEAR(m.date) <= (:year -1)
      """)
  Double calcCurrentAmountYearBefore(@Param("id") Long id, @Param("year") Integer year);
  @Query("""
      SELECT SUM(m.value) AS total_jcp
      FROM AssetReturnsMovementModel m
      WHERE m.stock.id = :id
      AND YEAR(m.date) = (:year)
      AND m.operation = 'JCP'
      """)
  Double calcJCP(@Param("id") Long id, @Param("year") Integer year);

  @Query("""
      SELECT SUM(m.value) AS total_jcp
      FROM AssetReturnsMovementModel m
      WHERE m.stock.id = :id
      AND YEAR(m.exDividendDate) = (:year)
      AND (YEAR(m.date) > (:year) OR m.date IS NULL)
      AND m.operation = 'JCP'
      """)
  Double calcFutureJCP(@Param("id") Long id, @Param("year") Integer year);
  @Query("""
      SELECT SUM(m.value) AS total_dividend
      FROM AssetReturnsMovementModel m
      WHERE m.stock.id = :id
      AND YEAR(m.date) = (:year)
      AND m.operation != 'JCP'
      """)
  Double calcDividend(@Param("id") Long id, @Param("year") Integer year);

  @Query("""
      SELECT SUM(m.value) AS total_dividend
      FROM AssetReturnsMovementModel m
      WHERE m.stock.id = :id
      AND YEAR(m.exDividendDate) = (:year)
      AND YEAR(m.date) > (:year)
      AND m.operation != 'JCP'
      """)
  Double calcFutureDividend(@Param("id") Long id, @Param("year") Integer year);

  @Query("""
      SELECT SUM(m.amount * m.unitValue) / SUM(m.amount)
      FROM AssetMovementModel m
      WHERE m.asset.id = :id
      AND m.operation = 'SELL'
      AND YEAR(m.date) = :year
      """)
  Double calcSellValue(@Param("id") Long id, @Param("year") Integer year);
}
