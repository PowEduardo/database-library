package br.com.powtec.finance.database.library.model.dto;

import java.math.BigDecimal;
import java.time.YearMonth;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class CreditCardStatementDTO {
  private Long id;
  private YearMonth referenceMonth;
  private BigDecimal value;
  private BigDecimal discounts;
  private Boolean closed;
  
  // Relationships (optional)
  private List<CreditCardInstallmentDTO> installments;
}
