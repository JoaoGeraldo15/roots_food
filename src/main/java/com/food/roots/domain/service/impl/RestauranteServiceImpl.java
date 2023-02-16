package com.food.roots.domain.service.impl;

import com.food.roots.domain.model.dto.CozinhaDTO;
import com.food.roots.domain.model.dto.RestauranteDTO;
import com.food.roots.domain.model.dto.mapper.RestauranteMapper;
import com.food.roots.domain.model.entity.Restaurante;
import com.food.roots.domain.repository.RestauranteRepository;
import com.food.roots.domain.service.CozinhaService;
import com.food.roots.domain.service.RestauranteService;
import com.food.roots.domain.service.exception.BadRequestException;
import com.food.roots.domain.service.exception.EntidadeCozinhaNaoEncontradaException;
import com.food.roots.domain.service.exception.EntidadeRestauranteNaoEncontradaException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class RestauranteServiceImpl implements RestauranteService {

    private RestauranteRepository restauranteRepository;

    private CozinhaService cozinhaService;

    private RestauranteMapper mapper;

    @Override
    public RestauranteDTO cadastrar(RestauranteDTO restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        CozinhaDTO cozinha = obterCozinhaOuLancarError(cozinhaId);
        restaurante.setCozinha(cozinha);
        return mapper.toDTO(restauranteRepository.save(mapper.toEntity(restaurante)));
    }

    private CozinhaDTO obterCozinhaOuLancarError(Long cozinhaId) {
        CozinhaDTO cozinha;
        try {
            cozinha = cozinhaService.buscarPorId(cozinhaId);
        } catch (EntidadeCozinhaNaoEncontradaException e) {
            throw new BadRequestException("A cozinha informada não existe!");
        }
        return cozinha;
    }

    @Override
    public RestauranteDTO buscarPorId(Long id) {
        return mapper.toDTO(obterRestauranteOuLancarError(id));
    }

    @Override
    public List<RestauranteDTO> restaurantesPorNome(String nome) {
        return mapper.listToDTO(restauranteRepository.nome(nome));
    }

    @Override
    public RestauranteDTO atualizar(Long id, RestauranteDTO restaurante) {
        Restaurante restauranteAtual = obterRestauranteOuLancarError(id);
        if(Objects.nonNull(restaurante.getCozinha())) {
            restaurante.setCozinha(obterCozinhaOuLancarError(restaurante.getCozinha().getId()));
        }
        BeanUtils.copyProperties(restaurante, restauranteAtual, "id", "formasPagamento");
        return mapper.toDTO(restauranteRepository.save(restauranteAtual));
    }

    @Override
    public List<RestauranteDTO> listar() {
        return mapper.listToDTO(restauranteRepository.findAll());
    }

    @Override
    public void deletar(Long id) {
        Restaurante restaurante = obterRestauranteOuLancarError(id);
        restauranteRepository.delete(restaurante);
    }

    private Restaurante obterRestauranteOuLancarError(Long id) {
        return restauranteRepository.findById(id)
                .orElseThrow(() -> new EntidadeRestauranteNaoEncontradaException(String.format("Restaurante de id %d não foi encontrado", id)));
    }
}
