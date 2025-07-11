package br.com.powtec.finance.database.library.model.vehicle;

import java.time.LocalDate;

import br.com.powtec.finance.database.library.enums.FuelTypeEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_vehicles_fuel_history")
public class VehicleFuelModel {
    private Double consumption;
    private LocalDate date;
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double liters;
    private Integer milage;
    private Double price;
    @Enumerated(EnumType.STRING)
    private FuelTypeEnum type;
    private Double value;
    @ManyToOne(cascade = CascadeType.REFRESH, optional = false, fetch = FetchType.LAZY)
    private VehicleModel vehicle;
    private Boolean isFulfilled;
}
