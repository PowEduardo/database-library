package br.com.powtec.finance.database.library.repository;

import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.movement.CreditCardMovementModel;

@Repository
public interface CreditCardMovementRepository extends MovementRepository<CreditCardMovementModel>{

}
