package br.com.powtec.finance.database.library.repository.specification;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.model.MovementModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class MovementSpecification implements BaseCrudChildSpecification<MovementModel> {
  public Specification<MovementModel> getQuery(String parameters, Long accountId) {
    return new Specification<>() {

      @SuppressWarnings("null")
      @Override
      @Nullable
      public Predicate toPredicate(Root<MovementModel> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (accountId != 0) {
          predicates.add(criteriaBuilder.equal(root.get("account").get("id"), accountId));
        }
        if (parameters != null) {
          for (String param : parameters.split(",")) {
            String keyValue[] = param.split(":");
            if (keyValue[0].equals("date")) {
              String dateRange[] = keyValue[1].split(";");
              if (dateRange.length == 2) {
                predicates.add(criteriaBuilder.between(root.get("date"), LocalDate.parse(dateRange[0]), LocalDate.parse(dateRange[1])));
              } else if (dateRange.length == 1) {
                predicates.add(criteriaBuilder.greaterThan(root.get("date"), LocalDate.parse(dateRange[0])));
              } else {
                predicates.add(criteriaBuilder.equal(root.get("date"), LocalDate.parse(dateRange[0])));
              }
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
