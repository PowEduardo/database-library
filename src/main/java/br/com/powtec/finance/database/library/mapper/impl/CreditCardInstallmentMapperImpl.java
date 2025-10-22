package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.mapper.BaseCrudMapper;
import br.com.powtec.finance.database.library.mapper.CreditCardInstallmentMapper;
import br.com.powtec.finance.database.library.mapper.CreditCardMovementMapper;
import br.com.powtec.finance.database.library.model.CreditCardInstallmentModel;
import br.com.powtec.finance.database.library.model.CreditCardStatementModel;
import br.com.powtec.finance.database.library.model.dto.CreditCardInstallmentDTO;
import br.com.powtec.finance.database.library.model.dto.CreditCardStatementDTO;
import br.com.powtec.finance.database.library.model.movement.CreditCardMovementModel;

@Component
public class CreditCardInstallmentMapperImpl
    implements CreditCardInstallmentMapper {

  @Autowired
  CreditCardMovementMapper movementMapper;
  @Autowired
  BaseCrudMapper<CreditCardStatementModel, CreditCardStatementDTO> statementMapper;

  @Override
  public CreditCardInstallmentDTO toDto(CreditCardInstallmentModel model) {
    return CreditCardInstallmentDTO.builder()
        .id(model.getId())
        .entryType(model.getEntryType())
        .installment(model.getInstallment())
        .referenceMonth(model.getReferenceMonth())
        .value(model.getValue())
        .movement(movementMapper.toDtoOnlyId(model.getMovement()))
        .statement(statementMapper.toDtoOnlyId(model.getStatement()))
        .description(model.getMovement().getDescription())
        .date(model.getMovement().getDate())
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
    return CreditCardInstallmentDTO.builder().id(model.getId()).build();
  }

  @Override
  public CreditCardInstallmentModel toModel(CreditCardInstallmentDTO dto) {
    CreditCardMovementModel movement = new CreditCardMovementModel();
    movement.setId(dto.getMovement().getId());
    return CreditCardInstallmentModel.builder()
      .entryType(dto.getEntryType())
      .id(dto.getId())
      .installment(dto.getInstallment())
      .movement(movement)
      .statement(statementMapper.toModel(dto.getStatement()))
      .referenceMonth(dto.getReferenceMonth())
      .value(dto.getValue())
    .build();
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
