package br.com.powtec.finance.database.library.mapper;

import org.mapstruct.Mapper;

import br.com.powtec.finance.database.library.model.CreditCardStatementModel;
import br.com.powtec.finance.database.library.model.dto.CreditCardStatementDTO;

/**
 * Mapper for CreditCardStatement entity and DTO.
 * Handles mapping between CreditCardStatementModel and CreditCardStatementDTO.
 */
@Mapper(componentModel = "spring")
public interface CreditCardStatementMapper extends BaseCrudMapper<CreditCardStatementModel, CreditCardStatementDTO> {

}

