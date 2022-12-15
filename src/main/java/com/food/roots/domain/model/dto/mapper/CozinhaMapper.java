package com.food.roots.domain.model.dto.mapper;

import com.food.roots.domain.model.Cozinha;
import com.food.roots.domain.model.dto.CozinhaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CozinhaMapper {

    Cozinha toEntity(CozinhaDTO dto);
    CozinhaDTO toDTO(Cozinha entity);
    List<CozinhaDTO> listToDTO(List<Cozinha> entities);
}
