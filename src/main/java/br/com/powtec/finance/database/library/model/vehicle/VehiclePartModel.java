package br.com.powtec.finance.database.library.model.vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "tb_vehicles_parts")
public class VehiclePartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Boolean isUpgrade;
    private String partNumber;
    @Column(length = 1000)
    private String shop;
    private Double value;
    @ManyToOne(optional = false, fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private VehicleModel vehicle;
}
