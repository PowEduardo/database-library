package br.com.powtec.finance.database.library.repository;

import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.base.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.CreditCardStatementModel;
import br.com.powtec.finance.database.library.model.dto.DashboardDetailsDTO;

@Repository
public interface CreditCardStatementRepository extends BaseCrudRepository<CreditCardStatementModel> {

  Optional<CreditCardStatementModel> getByReferenceMonth(YearMonth referenceMonth);

  @Query(value = """
          SELECT reference_month, SUM(value), paid
          FROM tb_credit_card_statement
          WHERE to_date(reference_month || '-01', 'YYYY-MM-DD')
          BETWEEN
                (to_date(:referenceMonth || '-01', 'YYYY-MM-DD') - INTERVAL '12 months')
            AND (to_date(:referenceMonth || '-01', 'YYYY-MM-DD') + INTERVAL '1 month')
          GROUP BY reference_month, value, paid
          ORDER BY reference_month ASC
      """, nativeQuery = true)
  List<DashboardDetailsDTO> nextAndPreviousStatements(@Param("referenceMonth")String referenceMonth);

  @Query(value = """
          SELECT reference_month, SUM(value), paid
          FROM tb_credit_card_statement
          WHERE to_date(reference_month || '-01', 'YYYY-MM-DD')
          BETWEEN
                (to_date(:referenceMonth || '-01', 'YYYY-MM-DD') - INTERVAL '12 months')
            AND (to_date(:referenceMonth || '-01', 'YYYY-MM-DD') + INTERVAL '1 month')
            AND card_id = :cardId
          GROUP BY reference_month, value, paid
          ORDER BY reference_month ASC
      """, nativeQuery = true)
  List<DashboardDetailsDTO> nextAndPreviousStatementsForSpecifycCard(@Param("referenceMonth")String referenceMonth, @Param("cardId")Long cardId);

  @Query(value = """
    SELECT SUM(value) FROM tb_credit_card_installment
    WHERE statement_id = :statementId
    """, nativeQuery = true)
  Double sumStatementValue(@Param("statementId") Long statementId);

  @Query(value = """
    SELECT SUM(value) FROM tb_credit_card_statement
    WHERE card_id = :cardId AND NOT paid
    """, nativeQuery = true)
  Double sumStatementValueFromCard(@Param("cardId") Long cardId);

}
