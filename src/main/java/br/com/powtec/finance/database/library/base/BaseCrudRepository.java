package br.com.powtec.finance.database.library.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BaseCrudRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
