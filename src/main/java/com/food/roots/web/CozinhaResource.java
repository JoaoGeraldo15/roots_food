package com.food.roots.web;

import com.food.roots.domain.model.dto.CozinhaDTO;
import com.food.roots.domain.service.CozinhaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cozinhas")
public class CozinhaResource {
    private final CozinhaService cozinhaService;

    @PostMapping
    public ResponseEntity<CozinhaDTO> cadastrar(@RequestBody CozinhaDTO cozinha) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaService.cadastrar(cozinha));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CozinhaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(cozinhaService.buscarPorId(id));
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<CozinhaDTO>> cozinhasPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(cozinhaService.cozinhasPorNome(nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CozinhaDTO> atualizar(@PathVariable Long id, @RequestBody CozinhaDTO cozinha) {
        CozinhaDTO cozinhaAtualizada = cozinhaService.atualizar(id, cozinha);
        return ResponseEntity.ok().body(cozinhaAtualizada);
    }

    @GetMapping
    public ResponseEntity<List<CozinhaDTO>> listar() {
        return ResponseEntity.ok().body(cozinhaService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cozinhaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
