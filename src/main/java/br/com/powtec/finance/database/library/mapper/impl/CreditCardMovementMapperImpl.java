package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.mapper.CreditCardMapper;
import br.com.powtec.finance.database.library.mapper.CreditCardMovementMapper;
import br.com.powtec.finance.database.library.model.dto.CreditCardMovementDTO;
import br.com.powtec.finance.database.library.model.movement.CreditCardMovementModel;

@Component
public class CreditCardMovementMapperImpl extends MovementAbstractMapper
    implements CreditCardMovementMapper {

  @Autowired
  CreditCardMapper cardMapper;

  @Override
  public CreditCardMovementDTO toDto(CreditCardMovementModel model) {
    CreditCardMovementDTO dto = new CreditCardMovementDTO();
    super.toDto(model, dto);
    dto.setInstallment(model.getInstallment());
    dto.setPaid(model.getPaid());
    return dto;
  }

  @Override
  public List<CreditCardMovementDTO> toDtosList(List<CreditCardMovementModel> movementsModel) {
    List<CreditCardMovementDTO> dtosList = new ArrayList<>(movementsModel.size());
    for (CreditCardMovementModel model : movementsModel) {
      dtosList.add(toDto(model));
    }
    return dtosList;
  }

  @Override
  public CreditCardMovementDTO toDtoOnlyId(CreditCardMovementModel model) {
    CreditCardMovementDTO dto = new CreditCardMovementDTO();
    dto.setId(model.getId());
    return dto;
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
    List<CreditCardMovementModel> dtosList = new ArrayList<>(movementsDto.size());
    for (CreditCardMovementDTO dto : movementsDto) {
      dtosList.add(toModel(dto, parentId));
    }
    return dtosList;
  }

}
