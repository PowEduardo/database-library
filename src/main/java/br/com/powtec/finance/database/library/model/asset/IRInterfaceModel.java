package br.com.powtec.finance.database.library.model.asset;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IRInterfaceModel {
    BigDecimal averagePrice;
    BigDecimal totalValue;
    BigDecimal totalAmount;
    BigDecimal totalValueLastYear;
    BigDecimal totalJCP;
    BigDecimal totalDividend;
    BigDecimal totalSellValue;
    BigDecimal totalFutureJCP;
    BigDecimal totalFutureDividend;
}
