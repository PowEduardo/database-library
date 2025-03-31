package br.com.powtec.finance.database.library.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.movement.AssetReturnsMovementModel;

@Repository
public interface AssetReturnsMovementRepository extends MovementRepository<AssetReturnsMovementModel>{

    @Query("""
        SELECT SUM(
          CASE
            WHEN m.operation = 'BUY' THEN m.amount
            ELSE m.amount * -1
          END
        ) AS current_amount
        FROM AssetMovementModel m
        WHERE m.asset.id = :id
        AND DATE(m.date) <= :date
        """)
    Integer calcAmount(@Param(value = "id") Long id, @Param(value = "date") LocalDate date);

}
