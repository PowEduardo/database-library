package br.com.powtec.finance.database.library.repository.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.model.CreditCardModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class CreditCardSpecification implements BaseCrudSpecification<CreditCardModel> {

  @Override
  public Specification<CreditCardModel> getQuery(String parameters) {
    return new Specification<>() {

      @SuppressWarnings("null")
      @Override
      @Nullable
      public Predicate toPredicate(Root<CreditCardModel> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (parameters != null) {
          for (String param : parameters.split(",")) {
            String keyValue[] = param.split(":");

            predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get(keyValue[0]), keyValue[1])));
          }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
      }

    };
  }

}
