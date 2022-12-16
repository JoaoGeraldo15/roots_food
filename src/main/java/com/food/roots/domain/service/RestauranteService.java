package com.food.roots.domain.service;

import com.food.roots.domain.model.dto.RestauranteDTO;

import java.util.List;

public interface RestauranteService {

    /**
     * Cadastra um novo restaurante
     * @param restaurante dados da nova restaurante
     * @return RestauranteDTO
     */
    public RestauranteDTO cadastrar(RestauranteDTO restaurante);

    /**
     * Retorna um restaurante de acordo com o ID informado e caso não exista será lançado uma exception
     * @param id da restaurante que deseja buscar
     * @return RestauranteDTO
     */
    public RestauranteDTO buscarPorId(Long id);

    List<RestauranteDTO> restaurantesPorNome(String nome);

    /**
     * Atualiza os dados de um restaurante de acordo com o id e informações passadas
     * @param id da restaurante a ser atualizada
     * @param restaurante com os dados para serem atualizados
     * @return RestauranteDTO
     */
    public RestauranteDTO atualizar(Long id, RestauranteDTO restaurante);

    /**
     * Listagem de restaurantes
     * @return List<RestauranteDTO>
     */
    public List<RestauranteDTO> listar();

    /**
     * Remove um restaurante do banco
     * @param id
     */
    void deletar(Long id);
}
