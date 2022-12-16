package com.food.roots.domain.resource;

import com.food.roots.domain.model.dto.CozinhaDTO;
import com.food.roots.domain.service.CozinhaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
        if (Objects.nonNull(cozinhaAtualizada)) {
            return ResponseEntity.ok().body(cozinhaAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public ResponseEntity<List<CozinhaDTO>> listar() {
        return ResponseEntity.ok().body(cozinhaService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cozinhaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
