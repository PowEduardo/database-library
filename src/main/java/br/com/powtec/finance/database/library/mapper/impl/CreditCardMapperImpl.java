package br.com.powtec.finance.database.library.mapper.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.mapper.CreditCardMapper;
import br.com.powtec.finance.database.library.model.CreditCardModel;
import br.com.powtec.finance.database.library.model.dto.CreditCardDTO;

@Component("creditCardMapper")
public class CreditCardMapperImpl implements CreditCardMapper {

  @Override
  public CreditCardDTO toDto(CreditCardModel model) {
    return CreditCardDTO.builder()
        .createDate(model.getCreateDate())
        .id(model.getId())
        .name(model.getName())
        .statementDay(model.getStatementDay())
        .build();
  }

  @Override
  public List<CreditCardDTO> toDtosList(List<CreditCardModel> movementsModel) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toDtosList'");
  }

  @Override
  public CreditCardDTO toDtoOnlyId(CreditCardModel model) {
    return CreditCardDTO.builder().id(model.getId()).build();
  }

  @Override
  public CreditCardModel toModel(CreditCardDTO dto) {
    return CreditCardModel.builder()
        .createDate(dto.getCreateDate())
        .id(dto.getId())
        .name(dto.getName())
        .statementDay(dto.getStatementDay())
        .build();
  }

  @Override
  public CreditCardModel toModelById(Long id) {
    return CreditCardModel.builder().id(id).build();
  }

  @Override
  public List<CreditCardModel> toModelsList(List<CreditCardDTO> movementsDto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toModelsList'");
  }

}
