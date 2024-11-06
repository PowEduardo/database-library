package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.enums.MovementTypeEnum;
import br.com.powtec.finance.database.library.mapper.MovementMapper;
import br.com.powtec.finance.database.library.model.MovementModel;
import br.com.powtec.finance.database.library.model.dto.MovementDTO;

@Component
public class AccountMovementMapperImpl extends MovementAbstractMapper
    implements MovementMapper<MovementModel, MovementDTO> {

  @Override
  public MovementDTO toDto(MovementModel model) {
    MovementDTO dto = new MovementDTO();
    super.toDto(model, dto);
    dto.setValue(model.getType() == MovementTypeEnum.DEBIT ? model.getValue() * -1.0 : model.getValue());
    return dto;
  }

  @Override
  public List<MovementDTO> toDtosList(List<MovementModel> movementsModel) {
    List<MovementDTO> dtosList = new ArrayList<>(movementsModel.size());
    for (MovementModel model : movementsModel) {
      dtosList.add(toDto(model));
    }
    return dtosList;
  }

  @Override
  public MovementDTO toDtoOnlyId(MovementModel model) {
    return MovementDTO.builder().id(model.getId()).build();
  }

  @Override
  public MovementModel toModel(MovementDTO dto, Long parentId) {
    MovementModel model = new MovementModel();
    super.toModel(dto, model);
    return model;
  }

  @Override
  public List<MovementModel> toModelsList(List<MovementDTO> movementsDto, Long parentId) {
    List<MovementModel> modelList = new ArrayList<>(movementsDto.size());
    for (MovementDTO model : movementsDto) {
      modelList.add(toModel(model, parentId));
    }
    return modelList;
  }

}
