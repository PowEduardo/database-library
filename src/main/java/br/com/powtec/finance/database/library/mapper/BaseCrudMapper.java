package br.com.powtec.finance.database.library.mapper;

import java.util.List;

public interface BaseCrudMapper<T, Y> {

  public Y toDto(T model);

  public List<Y> toDtosList(List<T> movementsModel);

  public Y toDtoOnlyId(T model);

  public T toModel(Y dto);

  public T toModelById(Long id);

  public List<T> toModelsList(List<Y> movementsDto);
}
