package br.com.powtec.finance.database.library.repository.specification;

import org.springframework.data.jpa.domain.Specification;

public interface BaseCrudSpecification<T> {
  public Specification getQuery(String parameters);
}
