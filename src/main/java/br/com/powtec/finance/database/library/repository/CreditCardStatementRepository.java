package br.com.powtec.finance.database.library.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.base.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.CreditCardStatementModel;

@Repository
public interface CreditCardStatementRepository extends BaseCrudRepository<CreditCardStatementModel> {

  Optional<CreditCardStatementModel> getByReferenceMonth(String referenceMonth);

}
