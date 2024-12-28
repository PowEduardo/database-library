package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.powtec.finance.database.library.mapper.AssetMapper;
import br.com.powtec.finance.database.library.mapper.MovementMapper;
import br.com.powtec.finance.database.library.model.AccountModel;
import br.com.powtec.finance.database.library.model.dto.AssetReturnsMovementDTO;
import br.com.powtec.finance.database.library.model.movement.AssetReturnsMovementModel;

@Component("assetReturnsMapper")
public class AssetReturnsMovementMapperImpl extends MovementAbstractMapper
    implements MovementMapper<AssetReturnsMovementModel, AssetReturnsMovementDTO> {

  @Autowired
  private AssetMapper stockMapper;

  @Override
  public AssetReturnsMovementDTO toDto(AssetReturnsMovementModel model) {
    AssetReturnsMovementDTO response = new AssetReturnsMovementDTO();
    AssetReturnsMovementModel returnsModel = (AssetReturnsMovementModel) model;
    super.toDto(returnsModel, response);
    response.setAmount(returnsModel.getAmount());
    response.setAsset(stockMapper.toDtoOnlyId(returnsModel.getStock()));
    response.setOperation(returnsModel.getOperation());
    response.setUnitValue(returnsModel.getUnitValue());
    response.setExDividendDate(returnsModel.getExDividendDate());
    response.setIrFee(model.getIrFee());
    return response;
  }

  @Override
  public List<AssetReturnsMovementDTO> toDtosList(List<AssetReturnsMovementModel> movementsModel) {
    List<AssetReturnsMovementDTO> movementsDto = new ArrayList<>(movementsModel.size());
    for (AssetReturnsMovementModel AssetReturnsMovementModel : movementsModel) {
      movementsDto.add(toDto(AssetReturnsMovementModel));
    }
    return movementsDto;
  }

  @Override
  public AssetReturnsMovementModel toModel(AssetReturnsMovementDTO request, Long id) {
    AssetReturnsMovementModel model = new AssetReturnsMovementModel();
    super.toModel(request, model);
    model.setStock(stockMapper.toModelById(id));
    model.setAccount(AccountModel.builder().id(1L).build());
    model.setAmount(request.getAmount());
    model.setOperation(request.getOperation());
    model.setUnitValue(request.getUnitValue());
    model.setExDividendDate(request.getExDividendDate());
    model.setIrFee(request.getIrFee());
    return model;
  }

  @Override
  public List<AssetReturnsMovementModel> toModelsList(List<AssetReturnsMovementDTO> movementsListDto, Long assetId) {
    List<AssetReturnsMovementModel> movementsListModel = new ArrayList<>(movementsListDto.size());
    for (AssetReturnsMovementDTO request : movementsListDto) {
      movementsListModel.add(toModel(request, assetId));
    }
    return movementsListModel;
  }

  @Override
  public AssetReturnsMovementDTO toDtoOnlyId(AssetReturnsMovementModel model) {
    AssetReturnsMovementDTO response = new AssetReturnsMovementDTO();
    response.setId(model.getId());
    return response;
  }

}
