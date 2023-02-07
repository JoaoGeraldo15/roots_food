package com.food.roots.domain.model.dto.mapper;

import com.food.roots.domain.model.entity.Restaurante;
import com.food.roots.domain.model.dto.RestauranteDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestauranteMapper {

    Restaurante toEntity(RestauranteDTO dto);

    RestauranteDTO toDTO(Restaurante entity);

    List<RestauranteDTO> listToDTO(List<Restaurante> entities);
}
