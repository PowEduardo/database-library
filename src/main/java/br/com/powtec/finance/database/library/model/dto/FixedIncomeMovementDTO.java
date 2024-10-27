package br.com.powtec.finance.database.library.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class FixedIncomeMovementDTO extends MovementDTO {

  LocalDate dueDate;

}
