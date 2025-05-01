package br.com.powtec.finance.database.library.mapper.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.powtec.finance.database.library.mapper.VehicleMapper;
import br.com.powtec.finance.database.library.model.VehicleModel;
import br.com.powtec.finance.database.library.model.dto.VehicleDTO;

@Service
public class VehicleMapperImpl implements VehicleMapper {

    @Override
    public VehicleDTO toDto(VehicleModel model) {
        if (model == null) {
            return null;
        }

        return VehicleDTO.builder()
                .id(model.getId())
                .manufacturer(model.getManufacturer())
                .milage(model.getMilage())
                .model(model.getModel())
                .value(model.getValue())
                .version(model.getVersion())
                .year(model.getYear())
                .build();
    }

    @Override
    public VehicleModel toModel(VehicleDTO dto) {
        if (dto == null) {
            return null;
        }

        return VehicleModel.builder()
                .id(dto.getId())
                .manufacturer(dto.getManufacturer())
                .milage(dto.getMilage())
                .model(dto.getModel())
                .value(dto.getValue())
                .version(dto.getVersion())
                .year(dto.getYear())
                .build();
    }

    @Override
    public List<VehicleDTO> toDtosList(List<VehicleModel> modelList) {
        return modelList.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public VehicleDTO toDtoOnlyId(VehicleModel model) {
        if (model == null) {
            return null;
        }

        return VehicleDTO.builder()
                .id(model.getId())
                .build();
    }

    @Override
    public VehicleModel toModelById(Long id) {
        if (id == null) {
            return null;
        }

        return VehicleModel.builder()
                .id(id)
                .build();
    }

    @Override
    public List<VehicleModel> toModelsList(List<VehicleDTO> dtoList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toModelsList'");
    }

}
