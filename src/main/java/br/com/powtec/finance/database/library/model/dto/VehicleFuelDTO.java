package br.com.powtec.finance.database.library.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.powtec.finance.database.library.enums.FuelTypeEnum;
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
public class VehicleFuelDTO {
    private Double consumption;
    private LocalDate date;
    private String description;
    private Long id;
    private Double liters;
    private Integer milage;
    private Double price;
    private FuelTypeEnum type;
    private Double value;
    private VehicleDTO vehicle;
    private Boolean isFulfilled;
}
