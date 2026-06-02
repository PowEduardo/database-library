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
 * Represents the complete external card statement data from bank export
 */
@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ExternalCardStatementDTO {
  
  private List<ExternalTransactionDTO> externalTransactions;
  private BigDecimal externalTotal;  // Sum of selected transactions (calculated on frontend)
}
