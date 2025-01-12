package br.com.powtec.finance.database.library.repository;

import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.enums.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.CreditCardStatementModel;

@Repository
public interface CreditCardStatementRepository extends BaseCrudRepository<CreditCardStatementModel> {

}
