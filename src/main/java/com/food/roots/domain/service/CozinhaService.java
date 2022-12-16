package com.food.roots.domain.service;

import com.food.roots.domain.model.dto.CozinhaDTO;

import java.util.List;

public interface CozinhaService {

    /**
     * Cadastra uma nova cozinha
     * @param cozinha dados da nova cozinha
     * @return CozinhaDTO
     */
    public CozinhaDTO cadastrar(CozinhaDTO cozinha);

    /**
     * Retorna uma cozinha de acordo com o ID informado
     * @param id da cozinha que deseja buscar
     * @return CozinhaDTO
     */
    public CozinhaDTO buscarPorId(Long id);

    List<CozinhaDTO> cozinhasPorNome(String nome);

    /**
     * Atualiza os dados de uma cozinha de acordo com o id e informações passadas
     * @param id da cozinha a ser atualizada
     * @param cozinha com os dados para serem atualizados
     * @return CozinhaDTO
     */
    public CozinhaDTO atualizar(Long id, CozinhaDTO cozinha);

    /**
     * Listagem de cozinhas
     * @return List<CozinhaDTO>
     */
    public List<CozinhaDTO> listar();

    /**
     * Remove uma cozinha do banco
     * @param id
     */
    void deletar(Long id);
}
