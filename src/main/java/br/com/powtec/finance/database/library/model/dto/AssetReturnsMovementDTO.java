package br.com.powtec.finance.database.library.model.dto;

import java.time.LocalDate;

import br.com.powtec.finance.database.library.enums.AssetReturnsOperationEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AssetReturnsMovementDTO extends MovementDTO {

  private Integer amount;
  private AssetDTO asset;
  private AssetReturnsOperationEnum operation;
  private Double unitValue;
  private LocalDate exDividendDate;
  private LocalDate duDate;

}
