package br.com.powtec.finance.database.library.model.dto;

import java.math.BigDecimal;
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
    private BigDecimal consumption;
    private LocalDate date;
    private String description;
    private Long id;
    private BigDecimal liters;
    private Integer milage;
    private BigDecimal price;
    private FuelTypeEnum type;
    private BigDecimal value;
    private VehicleDTO vehicle;
    private Boolean isFulfilled;
}
