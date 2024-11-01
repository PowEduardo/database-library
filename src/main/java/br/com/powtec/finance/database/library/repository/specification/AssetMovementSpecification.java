package br.com.powtec.finance.database.library.repository.specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.model.movement.AssetMovementModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Component
public class AssetMovementSpecification {

  public static Specification<AssetMovementModel> getQuery(String parameters, Long assetId) {
    return new Specification<>() {

      @SuppressWarnings("null")
      @Override
      @Nullable
      public Predicate toPredicate(Root<AssetMovementModel> root, CriteriaQuery<?> query,
          CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (assetId != 0) {
          predicates.add(criteriaBuilder.equal(root.get("asset").get("id"), assetId));
        }
        if (parameters != null) {
          for (String param : parameters.split(",")) {
            String keyValue[] = param.split(":");
            if (keyValue[0].equals("assetType")) {
              predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("asset").get("type"), keyValue[1])));
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
