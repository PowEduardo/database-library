package br.com.powtec.finance.database.library.mapper;

import br.com.powtec.finance.database.library.model.MovementModel;
import br.com.powtec.finance.database.library.model.dto.MovementDTO;

public interface MovementMapper<T extends MovementModel, Y extends MovementDTO> extends BaseChildCrudMapper<T, Y> {

}
