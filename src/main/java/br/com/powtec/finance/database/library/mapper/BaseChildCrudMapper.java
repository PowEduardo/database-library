package br.com.powtec.finance.database.library.mapper;

import java.util.List;

public interface BaseChildCrudMapper<T, Y> {

    public Y toDto(T model);

    public List<Y> toDtosList(List<T> movementsModel);

    public Y toDtoOnlyId(T model);

    public T toModel(Y dto, Long parentId);

    public List<T> toModelsList(List<Y> movementsDto, Long parentId);
}
