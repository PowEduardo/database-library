package br.com.powtec.finance.database.library.mapper;

import java.util.List;

public interface BaseCrudMapper<T, Y> {

  public T toDto(Y model);

  public List<T> toDtosList(List<? extends Y> movementsModel);

  public T toDtoOnlyId(Y model);

  public Y toModel(T dto);

  public Y toModelById(Long id);

  public List<Y> toModelsList(List<? extends T> movementsDto);
}
