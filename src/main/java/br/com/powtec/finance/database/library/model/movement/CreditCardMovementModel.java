package br.com.powtec.finance.database.library.model.movement;

import java.util.List;

import br.com.powtec.finance.database.library.model.CreditCardInstallmentModel;
import br.com.powtec.finance.database.library.model.CreditCardModel;
import br.com.powtec.finance.database.library.model.MovementModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_movements_credit_card")
public class CreditCardMovementModel extends MovementModel {
  private Integer installment;
  @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
  private CreditCardModel card;
  private Boolean paid;
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "movement")
  private List<CreditCardInstallmentModel> installments;
}
