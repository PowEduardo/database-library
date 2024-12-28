package br.com.powtec.finance.database.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.AccountModel;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, Long>, JpaSpecificationExecutor<AccountModel> {

  @Query(value = "SELECT COALESCE(SUM(CASE WHEN movements.type = 'DEBIT' THEN movements.value * -1.0 ELSE movements.value END), 0) AS value FROM MovementModel AS movements JOIN movements.account AS account WHERE account.id = :accountId")
  Double sumMovementsByAccount(@Param("accountId") Long accountId);
}
