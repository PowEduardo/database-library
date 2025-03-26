package br.com.powtec.finance.database.library.model.asset;

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
    Double averagePrice;
    Double totalValue;
    Double totalAmount;
    Double totalValueLastYear;
    Double totalJCP;
    Double totalDividend;
    Double totalSellValue;
    Double totalFutureJCP;
    Double totalFutureDividend;
}
