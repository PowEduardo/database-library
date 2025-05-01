package br.com.powtec.finance.database.library.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class VehicleDTO {
    private Long id;
    private String manufacturer;
    private Integer milage;
    private String model;
    private Double value;
    private String version;
    private Integer year;
}
