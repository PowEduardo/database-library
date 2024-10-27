package br.com.powtec.finance.database.library.model;

import br.com.powtec.finance.database.library.enums.AssetOperationEnum;
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