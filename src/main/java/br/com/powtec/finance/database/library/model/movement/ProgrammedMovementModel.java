package br.com.powtec.finance.database.library.model.movement;

import java.time.LocalDate;

import br.com.powtec.finance.database.library.enums.RecurrenceTypeEnum;
import br.com.powtec.finance.database.library.model.MovementModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Entity
@Getter
@NoArgsConstructor
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_movements_programmed")
public class ProgrammedMovementModel extends MovementModel {

  @Enumerated(EnumType.STRING)
  RecurrenceTypeEnum recurrence;
  LocalDate firstOccurrenceDate;
  LocalDate lastOccurrenceDate;
  Integer dayOfOccurrence;

  
}
