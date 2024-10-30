package br.com.powtec.finance.database.library.model;

import br.com.powtec.finance.database.library.enums.IndexerEnum;
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
@Table(name = "tb_asset_fixed_income")
public class AssetFixedIncomeModel extends AssetModel {

  private IndexerEnum indexer;
  private Double interestRate;
}
