package br.com.powtec.finance.database.library.model.dto;

import br.com.powtec.finance.database.library.model.CreditCardModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CreditCardMovementDTO extends MovementDTO{
  private Integer installment;
  private CreditCardModel card;
  private Boolean paid;
}
