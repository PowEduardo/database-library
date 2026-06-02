package br.com.powtec.finance.database.library.model.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Overall validation result for a statement against external data
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class StatementValidationResultDTO {
  
  private Boolean isValid;  // All installments have matches
  private BigDecimal externalTotal;  // Sum of external transactions provided
  private BigDecimal statementTotal;  // Sum of statement installments
  private Boolean totalMatches;  // External total equals statement total
  private List<InstallmentValidationDTO> installmentValidations;  // Status per installment
  private List<ExternalTransactionDTO> unmatchedExternalTransactions;  // CSV rows with no match
}
