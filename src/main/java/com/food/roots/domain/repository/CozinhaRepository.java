package com.food.roots.domain.repository;

import com.food.roots.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository {

    public Cozinha cadastrar(Cozinha cozinha);

    public Cozinha buscarPorId(Long id);

    public Cozinha atualizar(Long id, Cozinha cozinha);

    public List<Cozinha> listar();

    void deletar(Long id);
}
