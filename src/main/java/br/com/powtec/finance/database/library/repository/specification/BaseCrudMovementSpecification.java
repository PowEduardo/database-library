package br.com.powtec.finance.database.library.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.powtec.finance.database.library.model.MovementModel;

public interface BaseCrudMovementSpecification<T extends MovementModel> {
  public Specification<T> getQuery(String parameters, Long parentId);
}
