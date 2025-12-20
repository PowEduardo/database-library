package br.com.powtec.finance.database.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.base.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.CreditCardModel;

@Repository("creditCardRepository")
public interface CreditCardRepository
        extends BaseCrudRepository<CreditCardModel> {
                
    @Query(value = "SELECT ROUND(SUM(value),2) " +
            "FROM tb_credit_card_installment " +
            "WHERE reference_month = " +
            "  CASE " +
            "    WHEN EXTRACT(DAY FROM CURRENT_DATE) <= 2 THEN TO_CHAR(CURRENT_DATE, 'YYYY-MM') " +
            "    ELSE TO_CHAR(CURRENT_DATE + INTERVAL '1 month', 'YYYY-MM') " +
            "  END", nativeQuery = true)
    Double getCurrentStatementValue();

    @Query(value = "SELECT SUM(value) " +
            "FROM tb_credit_card_installment " +
            "WHERE reference_month = " +
            "  CASE " +
            "    WHEN EXTRACT(DAY FROM CURRENT_DATE) >= 2 THEN TO_CHAR(CURRENT_DATE, 'YYYY-MM') " +
            "    ELSE TO_CHAR(CURRENT_DATE - INTERVAL '1 month', 'YYYY-MM') " +
            "  END", nativeQuery = true)
    Double getLastStatementValue();

    @Query(value = "SELECT SUM(value) " +
            "FROM tb_credit_card_installment " +
            "WHERE reference_month = " +
            "  CASE " +
            "    WHEN EXTRACT(DAY FROM CURRENT_DATE) >= 2 THEN TO_CHAR(CURRENT_DATE + INTERVAL '2 month', 'YYYY-MM') " +
            "    ELSE TO_CHAR(CURRENT_DATE + INTERVAL '1 month', 'YYYY-MM') " +
            "  END", nativeQuery = true)
    Double getNextStatementValue();
}
