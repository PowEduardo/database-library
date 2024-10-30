package br.com.powtec.finance.database.library.model.movement;

import java.time.LocalDate;

import br.com.powtec.finance.database.library.enums.AssetReturnsOperationEnum;
import br.com.powtec.finance.database.library.model.AssetModel;
import br.com.powtec.finance.database.library.model.MovementModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_movements_asset_return")
public class AssetReturnsMovementModel extends MovementModel {

  private Integer amount;
  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  @JoinColumn(name = "asset_id")
  private AssetModel stock;
  @Enumerated(EnumType.STRING)
  private AssetReturnsOperationEnum operation;
  private Double unitValue;
  private LocalDate exDividendDate;
}
