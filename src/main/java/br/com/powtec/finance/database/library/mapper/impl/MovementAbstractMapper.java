package br.com.powtec.finance.database.library.mapper.impl;

import br.com.powtec.finance.database.library.model.MovementModel;
import br.com.powtec.finance.database.library.model.dto.MovementDTO;

public abstract class MovementAbstractMapper {
  protected void toDto(MovementModel model, MovementDTO dto) {
    dto.setDate(model.getDate());
    dto.setDescription(model.getDescription());
    dto.setId(model.getId());
    dto.setType(model.getType());
    dto.setValue(model.getValue());
  }

  protected void toModel(MovementDTO dto, MovementModel model) {
    model.setDate(dto.getDate());
    model.setDescription(dto.getDescription());
    model.setId(dto.getId());
    model.setType(dto.getType());
    model.setValue(dto.getValue());
  }
}
