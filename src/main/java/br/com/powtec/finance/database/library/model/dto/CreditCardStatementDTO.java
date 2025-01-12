package br.com.powtec.finance.database.library.model.dto;

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
public class CreditCardStatementDTO {
  private Long id;
  private String referenceMonth;
  private Double value;
  private Double discount;
}
