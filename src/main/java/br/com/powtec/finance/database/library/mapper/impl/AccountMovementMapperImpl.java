package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.mapper.MovementMapper;
import br.com.powtec.finance.database.library.model.AccountModel;
import br.com.powtec.finance.database.library.model.MovementModel;
import br.com.powtec.finance.database.library.model.dto.MovementDTO;

@Component
public class AccountMovementMapperImpl implements MovementMapper<MovementModel, MovementDTO> {

  @Override
  public MovementDTO toDto(MovementModel model) {
    return MovementDTO.builder()
        .id(model.getId())
        .date(model.getDate())
        .type(model.getType())
        .value(model.getValue())
        .description(model.getDescription())
        .build();
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
    model.setDate(dto.getDate());
    model.setType(dto.getType());
    model.setValue(dto.getValue());
    model.setId(dto.getId());
    model.setDescription(dto.getDescription());
    model.setAccount(AccountModel.builder().id(parentId).build());
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
