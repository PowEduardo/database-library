package br.com.powtec.finance.database.library.repository.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.model.movement.CreditCardMovementModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component("creditCardMovementSpecification")
public class CreditCardMovementSpecification implements BaseCrudMovementSpecification<CreditCardMovementModel>{

  @Override
  public Specification<CreditCardMovementModel> getQuery(String parameters, Long parentId) {
    return new Specification<CreditCardMovementModel>() {

      @SuppressWarnings("null")
      @Override
      @Nullable
      public Predicate toPredicate(Root<CreditCardMovementModel> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (parameters != null) {
          for (String param : parameters.split(",")) {
            String keyValue[] = param.split(":");
            if (parentId!=null) {
              predicates.add(criteriaBuilder
                  .and(criteriaBuilder.equal(root.get("card").get("id"), parentId)));
            } else {
              predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get(keyValue[0]), keyValue[1])));
            }
          }
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
      }

    };
  }

}
