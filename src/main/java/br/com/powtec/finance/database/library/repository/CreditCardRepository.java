package br.com.powtec.finance.database.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.powtec.finance.database.library.model.CreditCardModel;

public interface CreditCardRepository
    extends JpaRepository<CreditCardModel, Long>, JpaSpecificationExecutor<CreditCardModel> {

  @Query(value = "SELECT value " +
      "FROM tb_credit_card_statement " +
      "WHERE reference_month = " +
      "  CASE " +
      "    WHEN EXTRACT(DAY FROM CURRENT_DATE) <= 2 THEN TO_CHAR(CURRENT_DATE, 'MM/YYYY') " +
      "    ELSE TO_CHAR(CURRENT_DATE + INTERVAL '1 month', 'MM/YYYY') " +
      "  END", nativeQuery = true)
  Double getCurrentStatementValue();

  @Query(value = "SELECT value " +
      "FROM tb_credit_card_statement " +
      "WHERE reference_month = " +
      "  CASE " +
      "    WHEN EXTRACT(DAY FROM CURRENT_DATE) >= 2 THEN TO_CHAR(CURRENT_DATE, 'MM/YYYY') " +
      "    ELSE TO_CHAR(CURRENT_DATE - INTERVAL '1 month', 'MM/YYYY') " +
      "  END", nativeQuery = true)
  Double getLastStatementValue();
}
