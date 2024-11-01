package br.com.powtec.finance.database.library.mapper;

import java.util.List;

import br.com.powtec.finance.database.library.model.AssetModel;
import br.com.powtec.finance.database.library.model.dto.AssetDTO;

public interface AssetMapper {

  public AssetDTO toDto(AssetModel model);

  public List<AssetDTO> toDtosList(List<? extends AssetModel> movementsModel);

  public AssetDTO toDtoOnlyId(AssetModel model);

  public AssetModel toModel(AssetDTO dto);

  public AssetModel toModelById(Long id);

  public List<AssetModel> toModelsList(List<? extends AssetDTO> movementsDto);

  default AssetDTO buildDTO(AssetModel model, AssetDTO response) {
    response.setId(model.getId());
    response.setTicker(model.getTicker());
    response.setType(model.getType());
    response.setValue(model.getValue());
    return response;
  }

  default AssetModel buildModel(AssetDTO request, AssetModel model) {
    model.setId(request.getId());
    model.setTicker(request.getTicker());
    model.setType(request.getType());
    model.setValue(request.getValue());
    return model;
  }
}
