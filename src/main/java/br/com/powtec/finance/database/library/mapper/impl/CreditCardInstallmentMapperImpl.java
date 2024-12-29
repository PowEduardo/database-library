package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.mapper.CreditCardInstallmentMapper;
import br.com.powtec.finance.database.library.mapper.CreditCardMovementMapper;
import br.com.powtec.finance.database.library.model.CreditCardInstallmentModel;
import br.com.powtec.finance.database.library.model.dto.CreditCardInstallmentDTO;

@Component
public class CreditCardInstallmentMapperImpl
    implements CreditCardInstallmentMapper {

      @Autowired
      CreditCardMovementMapper movementMapper;
  @Override
  public CreditCardInstallmentDTO toDto(CreditCardInstallmentModel model) {
    return CreditCardInstallmentDTO.builder()
        .id(model.getId())
        .entryType(model.getEntryType())
        .installment(model.getInstallment())
        .referenceMonth(model.getReferenceMonth())
        .value(model.getValue())
        .movement(movementMapper.toDto(model.getMovement()))
        .build();
  }

  @Override
  public List<CreditCardInstallmentDTO> toDtosList(List<CreditCardInstallmentModel> movementsModel) {
    List<CreditCardInstallmentDTO> dtosList = new ArrayList<>(movementsModel.size());
    for (CreditCardInstallmentModel model : movementsModel) {
      dtosList.add(toDto(model));
    }
    return dtosList;
  }

  @Override
  public CreditCardInstallmentDTO toDtoOnlyId(CreditCardInstallmentModel model) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toDtoOnlyId'");
  }

  @Override
  public CreditCardInstallmentModel toModel(CreditCardInstallmentDTO dto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toModel'");
  }

  @Override
  public CreditCardInstallmentModel toModelById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toModelById'");
  }

  @Override
  public List<CreditCardInstallmentModel> toModelsList(List<CreditCardInstallmentDTO> movementsDto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toModelsList'");
  }

}
