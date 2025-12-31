package br.com.powtec.finance.database.library.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

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
  private BigDecimal value;
  private EntryTypeEnum entryType;
  private CreditCardMovementDTO movement;
  private CreditCardStatementDTO statement;
  private String description;
  private LocalDate date;
}
