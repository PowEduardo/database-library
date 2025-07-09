package br.com.powtec.finance.database.library.repository.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.model.vehicle.VehicleFuelModel;
import jakarta.annotation.Nullable;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

@Component
public class VehicleFuelSpecification implements BaseCrudChildSpecification<VehicleFuelModel> {

    @Override
  public Specification<VehicleFuelModel> getQuery(String parameters, Long parentId) {
    return new Specification<>() {

      @SuppressWarnings("null")
      @Override
      @Nullable
      public Predicate toPredicate(Root<VehicleFuelModel> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (parentId != null && parentId > 0) {
          predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("vehicle").get("id"), parentId)));
        }
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
