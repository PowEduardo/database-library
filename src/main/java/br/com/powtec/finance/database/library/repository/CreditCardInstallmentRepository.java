package br.com.powtec.finance.database.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.CreditCardStatementModel;

@Repository
public interface CreditCardInstallmentRepository  extends JpaRepository<CreditCardStatementModel, Long>, JpaSpecificationExecutor<CreditCardStatementModel> {

}
