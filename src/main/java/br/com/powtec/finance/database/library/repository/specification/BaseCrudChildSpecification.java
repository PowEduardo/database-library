package br.com.powtec.finance.database.library.repository.specification;

import org.springframework.data.jpa.domain.Specification;

public interface BaseCrudChildSpecification<T> {
  public Specification<T> getQuery(String parameters, Long parentId);
}
