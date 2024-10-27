package br.com.powtec.finance.database.library.model.movement;

import br.com.powtec.finance.database.library.enums.AssetOperationEnum;
import br.com.powtec.finance.database.library.model.MovementModel;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_movements_public_pension")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublicPensionMovementModel extends MovementModel {
  AssetOperationEnum operation;
}
