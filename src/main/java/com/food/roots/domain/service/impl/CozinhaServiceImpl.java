package com.food.roots.domain.service.impl;

import com.food.roots.domain.model.dto.CozinhaDTO;
import com.food.roots.domain.model.dto.mapper.CozinhaMapper;
import com.food.roots.domain.repository.CozinhaRepository;
import com.food.roots.domain.service.CozinhaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CozinhaServiceImpl implements CozinhaService {

    private CozinhaRepository cozinhaRepository;

    private CozinhaMapper mapper;

    @Override
    public CozinhaDTO cadastrar(CozinhaDTO cozinha) {
        return mapper.toDTO(cozinhaRepository.cadastrar(mapper.toEntity(cozinha)));
    }

    @Override
    public CozinhaDTO buscarPorId(Long id) {
        return mapper.toDTO(cozinhaRepository.buscarPorId(id));
    }

    @Override
    public CozinhaDTO atualizar(Long id, CozinhaDTO cozinha) {
        return mapper.toDTO(cozinhaRepository.atualizar(id, mapper.toEntity(cozinha)));
    }

    @Override
    public List<CozinhaDTO> listar() {
        return mapper.listToDTO(cozinhaRepository.listar());
    }

    @Override
    public void deletar(Long id) {
        cozinhaRepository.deletar(id);
    }
}
