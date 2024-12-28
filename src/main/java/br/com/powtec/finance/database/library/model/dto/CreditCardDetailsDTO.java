package br.com.powtec.finance.database.library.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CreditCardDetailsDTO extends CreditCardDTO{

  private Double currentStatementValue;
  private Double lastStatementValue;

}
