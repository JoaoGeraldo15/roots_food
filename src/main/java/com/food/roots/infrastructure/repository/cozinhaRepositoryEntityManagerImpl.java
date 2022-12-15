package com.food.roots.infrastructure.repository;

import com.food.roots.domain.model.Cozinha;
import com.food.roots.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class cozinhaRepositoryEntityManagerImpl implements CozinhaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public Cozinha cadastrar(Cozinha cozinha) {
        return entityManager.merge(cozinha);
    }

    @Override
    public Cozinha buscarPorId(Long id) {
        return entityManager.find(Cozinha.class, id);
    }

    @Transactional
    @Override
    public Cozinha atualizar(Long id, Cozinha cozinha) {
        cozinha.setId(id);
        return entityManager.merge(cozinha);
    }

    @Override
    public List<Cozinha> listar() {
        TypedQuery<Cozinha> cozinhas = entityManager.createQuery("from Cozinha", Cozinha.class);
        return cozinhas.getResultList();
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Cozinha cozinha = entityManager.find(Cozinha.class, id);
        entityManager.remove(cozinha);
    }
}
