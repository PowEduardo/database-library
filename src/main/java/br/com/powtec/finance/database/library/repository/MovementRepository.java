package br.com.powtec.finance.database.library.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.base.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.MovementModel;
import br.com.powtec.finance.database.library.model.dao.AccountDashboardDetails;
import br.com.powtec.finance.database.library.model.dao.DashboardBarChartDetails;

@Repository
@Primary
public interface MovementRepository<T extends MovementModel> extends BaseCrudRepository<T> {
    @Query(value = """
            WITH months AS (
                SELECT generate_series(
                    date_trunc('month', to_date(:startRange, 'YYYY-MM')),
                    date_trunc('month', to_date(:endRange, 'YYYY-MM')),
                    interval '1 month'
                ) AS month
            )
            SELECT
                to_char(m.month, 'YYYY-MM') AS reference,
                COALESCE(SUM(CASE WHEN t.type = 'CREDIT' THEN t.value END), 0)::numeric AS firstValue,
                COALESCE(SUM(CASE WHEN t.type = 'DEBIT'  THEN t.value END), 0)::numeric AS secondValue
            FROM months m
            LEFT JOIN tb_movements t
              ON date_trunc('month', t.date) = m.month
            LEFT JOIN tb_movements_asset t2
                ON t2.id = t.id
              WHERE t.account_id = :accountId AND t2.id IS NULL
            GROUP BY m.month
            ORDER BY m.month;
                    """, nativeQuery = true)
    public List<DashboardBarChartDetails> getAggregatedIncomeExpenseByMonth(@Param("accountId") Long accountId,
            @Param("startRange") String startRange, @Param("endRange") String endRange);

    @Query(value = """
            WITH months AS (
                SELECT generate_series(
                    date_trunc('month', to_date(:startRange, 'YYYY-MM')),
                    date_trunc('month', to_date(:endRange, 'YYYY-MM')),
                    interval '1 month'
                ) AS month
            )
            SELECT
                COALESCE(SUM(CASE WHEN t.type = 'CREDIT' THEN t.value END), 0)::numeric AS income,
                COALESCE(SUM(CASE WHEN t.type = 'DEBIT'  THEN t.value END), 0)::numeric AS expense,
                COALESCE(SUM(CASE
                    WHEN t.type = 'CREDIT' THEN t.value
                    WHEN t.type = 'DEBIT'  THEN -t.value
                END), 0)::numeric AS balance,
                COALESCE(COUNT(CASE WHEN t.paid THEN 1 END), 0)::integer AS total_paid,
	            COALESCE(COUNT(CASE WHEN NOT t.paid THEN 1 END), 0)::integer AS total_unpaid
            FROM months m
            LEFT JOIN tb_movements t
              ON date_trunc('month', t.date) = m.month
              LEFT JOIN tb_movements_asset t2
                ON t2.id = t.id
              WHERE t.account_id = :accountId AND t2.id IS NULL
                    """, nativeQuery = true)
    public List<AccountDashboardDetails> getBalanceForAggregatedIncomeExpenseByMonth(
            @Param("accountId") Long accountId,
            @Param("startRange") String startRange, @Param("endRange") String endRange);
}
