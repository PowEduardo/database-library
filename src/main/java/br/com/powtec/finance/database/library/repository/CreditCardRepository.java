package br.com.powtec.finance.database.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.powtec.finance.database.library.model.CreditCardModel;

public interface CreditCardRepository extends JpaRepository<CreditCardModel, Long>, JpaSpecificationExecutor<CreditCardModel>{

}
