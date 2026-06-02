package br.com.powtec.finance.database.library.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a single transaction from external bank CSV export (e.g., Nubank)
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ExternalTransactionDTO {
  
  private LocalDate date;
  private String title;
  private BigDecimal amount;
  private Boolean included;  // Whether user selected this transaction for validation
}
