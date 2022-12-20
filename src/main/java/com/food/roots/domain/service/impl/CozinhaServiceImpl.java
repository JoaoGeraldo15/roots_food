package com.food.roots.domain.service.impl;

import com.food.roots.domain.model.Cozinha;
import com.food.roots.domain.model.dto.CozinhaDTO;
import com.food.roots.domain.model.dto.mapper.CozinhaMapper;
import com.food.roots.domain.repository.CozinhaRepository;
import com.food.roots.domain.service.CozinhaService;
import com.food.roots.domain.service.exception.EntidadeEmUsoException;
import com.food.roots.domain.service.exception.EntidadeNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CozinhaServiceImpl implements CozinhaService {

    private CozinhaRepository cozinhaRepository;

    private CozinhaMapper mapper;

    @Override
    public CozinhaDTO cadastrar(CozinhaDTO cozinha) {
        return mapper.toDTO(cozinhaRepository.save(mapper.toEntity(cozinha)));
    }

    @Override
    public CozinhaDTO buscarPorId(Long id) {
        return mapper.toDTO(obterCozinhaOuLancarError(id));
    }

    @Override
    public List<CozinhaDTO> cozinhasPorNome(String nome) {
        return mapper.listToDTO(cozinhaRepository.findByNomeContaining(nome));
    }

    @Override
    public CozinhaDTO atualizar(Long id, CozinhaDTO cozinha) {
        Cozinha cozinhaAtual = obterCozinhaOuLancarError(id);
        BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
        return mapper.toDTO(cozinhaRepository.save(cozinhaAtual));
    }

    @Override
    public List<CozinhaDTO> listar() {
        return mapper.listToDTO(cozinhaRepository.findAll());
    }

    @Override
    public void deletar(Long id) {
        Cozinha cozinha = obterCozinhaOuLancarError(id);
        try {
            cozinhaRepository.delete(cozinha);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cozinha de código %d não pode ser removida, pois está em uso", id));
        }

    }

    private Cozinha obterCozinhaOuLancarError(Long id) {
        return cozinhaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format("Cozinha de id: %d não encontrada", id)));
    }
}
