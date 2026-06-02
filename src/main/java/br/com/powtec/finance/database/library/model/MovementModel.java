package br.com.powtec.finance.database.library.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import br.com.powtec.finance.database.library.enums.CategoryTypeEnum;
import br.com.powtec.finance.database.library.enums.MovementTypeEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Entity
@Getter
@NoArgsConstructor
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_movements")
public class MovementModel {

  LocalDate date;
  @CreationTimestamp
  LocalDateTime inclusionDateTime;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  @Enumerated(EnumType.STRING)
  MovementTypeEnum type;
  @Column(scale = 2)
  BigDecimal value;
  @Column(length = 100)
  String description;
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = true)
  AccountModel account;
  @OneToOne(mappedBy = "movement", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
  CreditCardStatementModel creditCardStatement;
  Boolean paid;
  @Enumerated(EnumType.STRING)
  CategoryTypeEnum category;

  @PrePersist
  public void prePersist() {
    if (paid == null) {
      paid = false;
    }
  }
}
