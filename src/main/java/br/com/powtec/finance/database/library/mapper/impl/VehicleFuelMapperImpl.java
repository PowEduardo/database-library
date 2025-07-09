package br.com.powtec.finance.database.library.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import br.com.powtec.finance.database.library.mapper.VehicleFuelMapper;
import br.com.powtec.finance.database.library.model.dto.VehicleFuelDTO;
import br.com.powtec.finance.database.library.model.vehicle.VehicleFuelModel;
import br.com.powtec.finance.database.library.model.vehicle.VehicleModel;

@Configuration
public class VehicleFuelMapperImpl implements VehicleFuelMapper {

    @Override
    public VehicleFuelDTO toDto(VehicleFuelModel model) {
        if (model == null) return null;
        VehicleFuelDTO dto = new VehicleFuelDTO();
        dto.setId(model.getId());
        dto.setConsumption(model.getConsumption());
        dto.setDate(model.getDate());
        dto.setDescription(model.getDescription());
        dto.setLiters(model.getLiters());
        dto.setMilage(model.getMilage());
        dto.setPrice(model.getPrice());
        dto.setType(model.getType() != null ? model.getType() : null);
        dto.setValue(model.getValue());
        return dto;
    }

    @Override
    public List<VehicleFuelDTO> toDtosList(List<VehicleFuelModel> models) {
        if (models == null) return null;
        List<VehicleFuelDTO> dtos = new ArrayList<>();
        for (VehicleFuelModel model : models) {
            dtos.add(toDto(model));
        }
        return dtos;
    }

    @Override
    public VehicleFuelDTO toDtoOnlyId(VehicleFuelModel model) {
        if (model == null) return null;
        VehicleFuelDTO dto = new VehicleFuelDTO();
        dto.setId(model.getId());
        return dto;
    }

    @Override
    public VehicleFuelModel toModel(VehicleFuelDTO dto, Long parentId) {
        if (dto == null) return null;
        VehicleFuelModel model = new VehicleFuelModel();
        model.setId(dto.getId());
        model.setConsumption(dto.getConsumption());
        model.setDate(dto.getDate());
        model.setDescription(dto.getDescription());
        model.setLiters(dto.getLiters());
        model.setMilage(dto.getMilage());
        model.setPrice(dto.getPrice());
        model.setType(dto.getType() != null ? dto.getType() : null);
        model.setValue(dto.getValue());
        VehicleModel vehicle = new VehicleModel();
        vehicle.setId(parentId != null ? parentId : dto.getVehicle().getId());
        model.setVehicle(vehicle);
        return model;
    }

    @Override
    public List<VehicleFuelModel> toModelsList(List<VehicleFuelDTO> dtos, Long parentId) {
        if (dtos == null) return null;
        List<VehicleFuelModel> models = new ArrayList<>();
        for (VehicleFuelDTO dto : dtos) {
            models.add(toModel(dto, parentId));
        }
        return models;
    }

}
