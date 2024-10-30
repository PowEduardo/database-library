package br.com.powtec.finance.database.library.model.movement;

import java.time.LocalDate;

import br.com.powtec.finance.database.library.model.MovementModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_movements_fixed_income")
@Getter
@Setter
public class FixedIncomeMovementModel extends MovementModel {

  LocalDate dueDate;

}
