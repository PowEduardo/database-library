package br.com.powtec.finance.database.library.repository.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.model.CreditCardInstallmentModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class CreditCardInstallmentSpecification implements BaseCrudSpecification<CreditCardInstallmentModel> {

  @Override
  public Specification<CreditCardInstallmentModel> getQuery(String parameters) {
    return new Specification<>() {

      @SuppressWarnings("null")
      @Override
      @Nullable
      public Predicate toPredicate(Root<CreditCardInstallmentModel> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (parameters != null) {
          for (String param : parameters.split(",")) {
            String keyValue[] = param.split(":");
            if (keyValue[0].equals("statement")) {
              predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get(keyValue[0]).get("id"), keyValue[1])));
            } else if (keyValue[0].equals("date")){
              predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("movement").get("date"), keyValue[1])));
            } else if (keyValue[0].equals("movement")) {
              predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get(keyValue[0]).get("id"), keyValue[1])));
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
