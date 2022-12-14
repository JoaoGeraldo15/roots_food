package com.food.roots.infrastructure.repository;

import com.food.roots.domain.model.Cozinha;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
//public class CozinhaRepositoryEntityManagerImpl implements CozinhaRepository {
public class CozinhaRepositoryEntityManagerImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
//    @Override
    public Cozinha cadastrar(Cozinha cozinha) {
        return entityManager.merge(cozinha);
    }

//    @Override
    public Cozinha buscarPorId(Long id) {
        return entityManager.find(Cozinha.class, id);
    }

//    @Override
    public List<Cozinha> consultarPorNome(String nome) {
        return entityManager.createQuery("FROM Cozinha WHERE nome LIKE :nome", Cozinha.class)
                .setParameter("nome", "%" + nome + "%")
                .getResultList();
    }

    @Transactional
//    @Override
    public Cozinha atualizar(Long id, Cozinha cozinha) {
        cozinha.setId(id);
        return entityManager.merge(cozinha);
    }

//    @Override
    public List<Cozinha> listar() {
        TypedQuery<Cozinha> cozinhas = entityManager.createQuery("from Cozinha", Cozinha.class);
        return cozinhas.getResultList();
    }

//    @Override
    @Transactional
    public void deletar(Long id) {
        Cozinha cozinha = entityManager.find(Cozinha.class, id);
        entityManager.remove(cozinha);
    }
}
