package br.com.powtec.finance.database.library.model.vehicle;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "tb_vehicles")
public class VehicleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    private Integer milage;
    private String model;
    private BigDecimal value;
    private String version;
    private Integer year;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<VehiclePartModel> vehiclePart;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<VehicleFuelModel> vehicleFuel;
}
