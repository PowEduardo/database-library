package br.com.powtec.finance.database.library.model.movement;

import br.com.powtec.finance.database.library.enums.AssetOperationEnum;
import br.com.powtec.finance.database.library.model.MovementModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_movements_public_pension")
public class PublicPensionMovementModel extends MovementModel {
  AssetOperationEnum operation;
}
