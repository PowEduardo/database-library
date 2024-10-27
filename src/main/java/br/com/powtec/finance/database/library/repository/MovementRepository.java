package br.com.powtec.finance.database.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.powtec.finance.database.library.model.MovementModel;

@Repository
public interface MovementRepository<T extends MovementModel>
        extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
}
