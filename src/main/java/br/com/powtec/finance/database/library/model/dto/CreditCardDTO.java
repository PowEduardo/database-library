package br.com.powtec.finance.database.library.model.dto;

import java.time.LocalDate;
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
public class CreditCardDTO {
  private Long id;
  private LocalDate createDate;
  private Integer statementDay;
  private String name;
  
  // Card specific fields
  private String cardName;
  private String cardNumber;
  private String cardType;
  private String bank;
  private Double balance;
  private Double creditLimit;
  
  // Relationships (optional, included on detailed queries)
  private List<CreditCardMovementDTO> movements;
  private List<CreditCardStatementDTO> statements;
}
