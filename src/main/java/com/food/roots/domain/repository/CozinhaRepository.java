package com.food.roots.domain.repository;

import com.food.roots.domain.model.entity.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {
    List<Cozinha> findByNomeContaining(String nome);

    @Query("FROM Cozinha WHERE nome like %:cozinhaRestaurante%")
    List<Cozinha> buscarCozinhasPorNome(@Param("cozinhaRestaurante") String nome);
}
