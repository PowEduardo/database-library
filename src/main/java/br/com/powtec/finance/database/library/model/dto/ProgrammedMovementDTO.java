package br.com.powtec.finance.database.library.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.powtec.finance.database.library.enums.RecurrenceTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ProgrammedMovementDTO extends MovementDTO{
  RecurrenceTypeEnum recurrence;
  LocalDate firstOccurrenceDate;
  LocalDate lastOccurrenceDate;
  Integer dayOfOccurrence;
}
