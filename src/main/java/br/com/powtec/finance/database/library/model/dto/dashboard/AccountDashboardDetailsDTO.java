package br.com.powtec.finance.database.library.model.dto.dashboard;

import java.math.BigDecimal;
import java.time.YearMonth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.powtec.finance.database.library.enums.TimeGranularityEnum;
import br.com.powtec.finance.database.library.model.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class AccountDashboardDetailsDTO{

    private AccountDTO account;
    private BigDecimal balance;
    private YearMonth startRange;
    private YearMonth endRange;
    private BigDecimal totalIncome;
    private BigDecimal totalExpense;
    private TimeGranularityEnum granularity;
    private Integer totalPaid;
    private Integer totalUnpaid;
    
}
