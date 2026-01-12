package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.mapper.BaseCrudMapper;
import br.com.powtec.finance.database.library.model.CreditCardStatementModel;
import br.com.powtec.finance.database.library.model.dto.CreditCardStatementDTO;

@Component
public class CreditCardStatementMapperImpl implements BaseCrudMapper<CreditCardStatementModel, CreditCardStatementDTO> {

  @Override
  public CreditCardStatementDTO toDto(CreditCardStatementModel model) {
    return CreditCardStatementDTO.builder()
        .id(model.getId())
        .referenceMonth(model.getReferenceMonth())
        .value(model.getValue())
        .discounts(model.getDiscounts())
        .closed(model.getClosed())
        .build();
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
