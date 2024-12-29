package br.com.powtec.finance.database.library.model.dto;

import br.com.powtec.finance.database.library.enums.EntryTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
public class CreditCardInstallmentDTO {

  private Long id;
  private Integer installment;
  private String referenceMonth;
  private Double value;
  private EntryTypeEnum entryType;
  private CreditCardMovementDTO movement;
}
