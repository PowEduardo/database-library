package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.mapper.AssetMapper;
import br.com.powtec.finance.database.library.mapper.MovementMapper;
import br.com.powtec.finance.database.library.model.AccountModel;
import br.com.powtec.finance.database.library.model.dto.AssetMovementDTO;
import br.com.powtec.finance.database.library.model.movement.AssetMovementModel;

@Component("assetMovementMapper")
public class AssetMovementMapperImpl extends MovementAbstractMapper implements MovementMapper<AssetMovementModel, AssetMovementDTO> {

  @Autowired
  private AssetMapper stockMapper;

  @Override
  public AssetMovementDTO toDto(AssetMovementModel model) {
    AssetMovementDTO response = new AssetMovementDTO();
    super.toDto(model, response);
    response.setAmount(model.getAmount());
    response.setAsset(stockMapper.toDtoOnlyId(model.getAsset()));
    response.setOperation(model.getOperation());
    response.setUnitValue(model.getUnitValue());
    response.setDueDate(model.getDueDate());
    return response;
  }

  @Override
  public List<AssetMovementDTO> toDtosList(List<AssetMovementModel> pageModel) {
    List<AssetMovementDTO> dtosList = new ArrayList<>(pageModel.size());
    for (AssetMovementModel model : pageModel) {
      dtosList.add(toDto(model));
    }
    return dtosList;
  }

  @Override
  public AssetMovementModel toModel(AssetMovementDTO request, Long assetId) {
    AssetMovementModel model = new AssetMovementModel();
    super.toModel(request, model);
    model.setAsset(stockMapper.toModelById(assetId));
    model.setAccount(AccountModel.builder().id(1L).build());
    model.setAmount(request.getAmount());
    model.setOperation(request.getOperation());
    model.setUnitValue(request.getUnitValue());
    model.setDueDate(request.getDueDate());

    return model;
  }

  @Override
  public List<AssetMovementModel> toModelsList(List<AssetMovementDTO> body, Long assetId) {
    List<AssetMovementModel> modelsList = new ArrayList<>(body.size());
    for (AssetMovementDTO movement : body) {
      modelsList.add(toModel(movement, assetId));
    }
    return modelsList;
  }

  @Override
  public AssetMovementDTO toDtoOnlyId(AssetMovementModel model) {
    AssetMovementDTO response = new AssetMovementDTO();
    response.setId(model.getId());
    return response;
  }

}
