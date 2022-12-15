package com.food.roots.domain.resource;

import com.food.roots.domain.model.dto.CozinhaDTO;
import com.food.roots.domain.service.CozinhaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/cozinhas")
public class CozinhaResource {
    private final CozinhaService cozinhaService;

    @PostMapping
    public ResponseEntity<CozinhaDTO> cadastrar(@RequestBody CozinhaDTO cozinha) {
        return ResponseEntity.ok().body(cozinhaService.cadastrar(cozinha));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CozinhaDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(cozinhaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CozinhaDTO> atualizar(@PathVariable Long id, @RequestBody CozinhaDTO cozinha) {
        return ResponseEntity.ok().body(cozinhaService.atualizar(id, cozinha));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CozinhaDTO>> listar() {
        return ResponseEntity.ok().body(cozinhaService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cozinhaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
