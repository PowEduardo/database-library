package br.com.powtec.finance.database.library.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehiclePartDTO {

    private Long id;
    private String description;
    private Boolean isUpgrade;
    private String shop;
    private Double value;
    private VehicleDTO vehicle;
}
