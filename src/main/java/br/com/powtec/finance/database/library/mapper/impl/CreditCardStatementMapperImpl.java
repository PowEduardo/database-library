package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.mapper.BaseCrudMapper;
import br.com.powtec.finance.database.library.model.CreditCardStatementModel;
import br.com.powtec.finance.database.library.model.dto.CreditCardStatementDTO;

@Component
public class CreditCardStatementMapperImpl implements BaseCrudMapper<CreditCardStatementModel, CreditCardStatementDTO> {

  @Lazy
  @Autowired(required = false)
  private CreditCardInstallmentMapperImpl installmentMapper;

  @Override
  public CreditCardStatementDTO toDto(CreditCardStatementModel model) {
    CreditCardStatementDTO dto = CreditCardStatementDTO.builder()
        .id(model.getId())
        .referenceMonth(model.getReferenceMonth())
        .value(model.getValue())
        .discounts(model.getDiscounts())
        .closed(model.getClosed())
        .build();
    
    // Map installments if they exist
    if (model.getInstallments() != null && !model.getInstallments().isEmpty() && installmentMapper != null) {
      dto.setInstallments(model.getInstallments().stream()
          .map(installmentMapper::toDto)
          .collect(Collectors.toList()));
    }
    
    return dto;
  }

  @Override
  public List<CreditCardStatementDTO> toDtosList(List<CreditCardStatementModel> modelList) {
    List<CreditCardStatementDTO> dtosList = new ArrayList<>(modelList.size());
    for (CreditCardStatementModel model : modelList) {
      dtosList.add(toDto(model));
    }
    return dtosList;
  }

  @Override
  public CreditCardStatementDTO toDtoOnlyId(CreditCardStatementModel model) {
    return CreditCardStatementDTO.builder()
        .id(model.getId())
        .build();
  }

  @Override
  public CreditCardStatementModel toModel(CreditCardStatementDTO dto) {
    return CreditCardStatementModel.builder()
        .id(dto.getId())
        .referenceMonth(dto.getReferenceMonth())
        .build();
  }

  @Override
  public CreditCardStatementModel toModelById(Long id) {
    return CreditCardStatementModel.builder()
        .id(id)
        .build();
  }

  @Override
  public List<CreditCardStatementModel> toModelsList(List<CreditCardStatementDTO> dtoList) {
    List<CreditCardStatementModel> modelList = new ArrayList<>(dtoList.size());
    for (CreditCardStatementDTO dto : dtoList) {
      modelList.add(toModel(dto));
    }
    return modelList;
  }

}
