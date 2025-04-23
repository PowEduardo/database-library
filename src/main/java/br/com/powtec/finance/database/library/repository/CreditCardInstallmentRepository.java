package br.com.powtec.finance.database.library.repository;

import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.base.BaseCrudRepository;
import br.com.powtec.finance.database.library.model.CreditCardInstallmentModel;

@Repository("creditCardInstallmentRepository")
public interface CreditCardInstallmentRepository extends BaseCrudRepository<CreditCardInstallmentModel> {

}
