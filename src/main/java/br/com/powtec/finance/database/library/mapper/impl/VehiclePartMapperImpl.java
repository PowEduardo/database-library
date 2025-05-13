package br.com.powtec.finance.database.library.mapper.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.powtec.finance.database.library.mapper.VehicleMapper;
import br.com.powtec.finance.database.library.mapper.VehiclePartMapper;
import br.com.powtec.finance.database.library.model.dto.VehiclePartDTO;
import br.com.powtec.finance.database.library.model.vehicle.VehiclePartModel;

@Service
public class VehiclePartMapperImpl implements VehiclePartMapper {

    @Autowired
    private VehicleMapper vehicleMapper;

    @Override
    public VehiclePartDTO toDto(VehiclePartModel model) {
        return VehiclePartDTO.builder()
                .description(model.getDescription())
                .id(model.getId())
                .isUpgrade(model.getIsUpgrade())
                .shop(model.getShop())
                .value(model.getValue())
                .vehicle(vehicleMapper.toDtoOnlyId(model.getVehicle()))
                .build();
    }

    @Override
    public List<VehiclePartDTO> toDtosList(List<VehiclePartModel> modelList) {
        return modelList.stream().map(this::toDto).toList();
    }

    @Override
    public VehiclePartDTO toDtoOnlyId(VehiclePartModel model) {
        return VehiclePartDTO.builder()
                .id(model.getId())
                .build();
    }

    @Override
    public VehiclePartModel toModel(VehiclePartDTO dto) {
        return VehiclePartModel.builder()
                .description(dto.getDescription())
                .id(dto.getId())
                .isUpgrade(dto.getIsUpgrade())
                .shop(dto.getShop())
                .value(dto.getValue())
                .vehicle(vehicleMapper.toModelById(dto.getVehicle().getId()))
                .build();
    }

    @Override
    public VehiclePartModel toModelById(Long id) {
        return VehiclePartModel.builder()
                .id(id)
                .build();
    }

    @Override
    public List<VehiclePartModel> toModelsList(List<VehiclePartDTO> dtoList) {
        return dtoList.stream().map(this::toModel).toList();
    }

}
