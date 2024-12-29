package br.com.powtec.finance.database.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.movement.CreditCardMovementModel;

@Repository
public interface CreditCardMovementRepository extends JpaRepository<CreditCardMovementModel, Long>, JpaSpecificationExecutor<CreditCardMovementModel>{

}
