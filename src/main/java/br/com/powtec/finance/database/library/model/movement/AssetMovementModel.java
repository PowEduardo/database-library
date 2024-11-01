package br.com.powtec.finance.database.library.model.movement;

import java.time.LocalDate;

import br.com.powtec.finance.database.library.enums.AssetOperationEnum;
import br.com.powtec.finance.database.library.model.AssetModel;
import br.com.powtec.finance.database.library.model.MovementModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_movements_asset")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssetMovementModel extends MovementModel {

  private Double amount;
  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  @JoinColumn(name = "asset_id")
  @NotNull
  private AssetModel asset;
  @Enumerated(EnumType.STRING)
  @NotNull
  private AssetOperationEnum operation;
  private Double unitValue;
  private LocalDate dueDate;
}
