package br.com.powtec.finance.database.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.powtec.finance.database.library.model.movement.CreditCardMovementModel;

public interface CreditCardMovementRepository extends JpaRepository<CreditCardMovementModel, Long>, JpaSpecificationExecutor<CreditCardMovementModel>{

}
