package br.com.powtec.finance.database.library.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.base.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.AccountModel;

@Repository
public interface AccountRepository extends BaseCrudRepository<AccountModel> {

  @Query(value = """
    SELECT COALESCE(SUM(CASE 
    WHEN movements.type = 'DEBIT' THEN movements.value * -1.0 
    ELSE movements.value END), 0) AS value 
    FROM MovementModel AS movements 
    JOIN movements.account AS account 
    WHERE account.id = :accountId AND date <= CURRENT_DATE
  """)
  BigDecimal sumMovementsByAccount(@Param("accountId") Long accountId);
}
