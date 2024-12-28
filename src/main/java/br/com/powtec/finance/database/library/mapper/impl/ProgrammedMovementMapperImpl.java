package br.com.powtec.finance.database.library.mapper.impl;

import java.util.List;

import br.com.powtec.finance.database.library.mapper.MovementMapper;
import br.com.powtec.finance.database.library.model.dto.ProgrammedMovementDTO;
import br.com.powtec.finance.database.library.model.movement.ProgrammedMovementModel;

public class ProgrammedMovementMapperImpl extends MovementAbstractMapper implements MovementMapper<ProgrammedMovementModel, ProgrammedMovementDTO> {

  @Override
  public ProgrammedMovementDTO toDto(ProgrammedMovementModel model) {
    ProgrammedMovementDTO dto = new ProgrammedMovementDTO();
    super.toDto(model, dto);
    dto.setDayOfOccurrence(model.getDayOfOccurrence());
    dto.setFirstOccurrenceDate(model.getFirstOccurrenceDate());
    dto.setLastOccurrenceDate(model.getLastOccurrenceDate());
    dto.setRecurrence(model.getRecurrence());
    return dto;
  }

  @Override
  public List<ProgrammedMovementDTO> toDtosList(List<ProgrammedMovementModel> movementsModel) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toDtosList'");
  }

  @Override
  public ProgrammedMovementDTO toDtoOnlyId(ProgrammedMovementModel model) {
    ProgrammedMovementDTO dto = new ProgrammedMovementDTO();
    dto.setId(model.getId());
    return dto;
  }

  @Override
  public ProgrammedMovementModel toModel(ProgrammedMovementDTO dto, Long parentId) {
    ProgrammedMovementModel model = new ProgrammedMovementModel();
    super.toModel(dto, model);
    model.setDayOfOccurrence(dto.getDayOfOccurrence());
    model.setFirstOccurrenceDate(dto.getFirstOccurrenceDate());
    model.setLastOccurrenceDate(dto.getLastOccurrenceDate());
    model.setRecurrence(dto.getRecurrence());
    return model;
  }

  @Override
  public List<ProgrammedMovementModel> toModelsList(List<ProgrammedMovementDTO> movementsDto, Long parentId) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'toModelsList'");
  }
  

}
