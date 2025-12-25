package br.com.powtec.finance.database.library.model;

import java.time.YearMonth;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import br.com.powtec.finance.database.library.converter.YearMonthConverter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_credit_card_statement")
public class CreditCardStatementModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Convert(converter = YearMonthConverter.class)
  @Column(name = "reference_month", columnDefinition = "VARCHAR(7)")
  @NotNull
  private YearMonth referenceMonth;
  @NotNull
  private Double discounts;
  @NotNull
  private Double value;
  @NotNull
  private Boolean paid;
  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  private CreditCardModel card;
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  MovementModel movement;
}
