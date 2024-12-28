package br.com.powtec.finance.database.library.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDetailsDTO extends AccountDTO{
  private Double balance;
}
