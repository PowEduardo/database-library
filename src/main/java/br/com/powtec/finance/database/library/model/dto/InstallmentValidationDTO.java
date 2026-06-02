package br.com.powtec.finance.database.library.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Validation result for a single installment
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class InstallmentValidationDTO {
  
  private Long installmentId;
  private Integer installmentNumber;
  private BigDecimal installmentValue;
  private Boolean hasMatch;  // Whether this installment has a matching transaction in external data
  private ExternalTransactionDTO matchedTransaction;  // The matched external transaction, if any
}
