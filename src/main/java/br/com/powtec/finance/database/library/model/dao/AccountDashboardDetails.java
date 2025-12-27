package br.com.powtec.finance.database.library.model.dao;

import java.math.BigDecimal;

public interface AccountDashboardDetails {

    BigDecimal getIncome();

    BigDecimal getExpense();

    BigDecimal getBalance();

    Integer getTotalPaid();
    
    Integer getTotalUnpaid();
}
