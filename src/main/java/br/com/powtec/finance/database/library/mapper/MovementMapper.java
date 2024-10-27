package br.com.powtec.finance.database.library.mapper;

import java.util.List;

import br.com.powtec.finance.database.library.model.MovementModel;
import br.com.powtec.finance.database.library.model.dto.MovementDTO;

public interface MovementMapper<T extends MovementModel, Y extends MovementDTO> {

  public Y toDto(T model);

  public List<Y> toDtosList(List<T> movementsModel);

  public Y toDtoOnlyId(T model);

  public T toModel(Y dto, Long parentId);

  public List<T> toModelsList(List<Y> movementsDto, Long parentId);
}
