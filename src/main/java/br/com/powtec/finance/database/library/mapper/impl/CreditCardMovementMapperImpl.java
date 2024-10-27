package br.com.powtec.finance.database.library.mapper.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.powtec.finance.database.library.mapper.CreditCardMapper;
import br.com.powtec.finance.database.library.mapper.MovementMapper;
import br.com.powtec.finance.database.library.model.dto.CreditCardMovementDTO;
import br.com.powtec.finance.database.library.model.movement.CreditCardMovementModel;

public class CreditCardMovementMapperImpl extends MovementAbstractMapper implements MovementMapper<CreditCardMovementModel, CreditCardMovementDTO> {

  @Autowired
  CreditCardMapper cardMapper;
  @Override
  public CreditCardMovementDTO toDto(CreditCardMovementModel model) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toDto'");
  }

  @Override
  public List<CreditCardMovementDTO> toDtosList(List<CreditCardMovementModel> movementsModel) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toDtosList'");
  }

  @Override
  public CreditCardMovementDTO toDtoOnlyId(CreditCardMovementModel model) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toDtoOnlyId'");
  }

  @Override
  public CreditCardMovementModel toModel(CreditCardMovementDTO dto, Long parentId) {
    CreditCardMovementModel model = new CreditCardMovementModel();
    super.toModel(dto, model);
    model.setCard(cardMapper.toModelById(parentId));
    model.setPaid(dto.getPaid());
    model.setInstallment(dto.getInstallment());
    return model;
  }

  @Override
  public List<CreditCardMovementModel> toModelsList(List<CreditCardMovementDTO> movementsDto, Long parentId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toModelsList'");
  }

}
