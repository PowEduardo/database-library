package br.com.powtec.finance.database.library.model.dao;

import java.math.BigDecimal;

public interface DashboardBarChartDetails {
    public String getReference();
    public BigDecimal getFirstValue();
    public BigDecimal getSecondValue();
}
