package br.com.powtec.finance.database.library.model.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
@JsonInclude(Include.NON_NULL)
public class VehiclePartDTO {

    private Long id;
    private String description;
    private Boolean isUpgrade;
    private String shop;
    private BigDecimal value;
    private VehicleDTO vehicle;
    private String partNumber;
}
