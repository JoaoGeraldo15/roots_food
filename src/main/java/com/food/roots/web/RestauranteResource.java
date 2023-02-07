package com.food.roots.web;

import com.food.roots.domain.model.dto.RestauranteDTO;
import com.food.roots.domain.service.RestauranteService;
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
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/api/restaurantes")
public class RestauranteResource {
    private final RestauranteService restauranteService;

    @PostMapping
    public ResponseEntity<RestauranteDTO> cadastrar(@RequestBody RestauranteDTO restaurante) {
        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteService.cadastrar(restaurante));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestauranteDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(restauranteService.buscarPorId(id));
    }

    @GetMapping("/por-nome")
    public ResponseEntity<List<RestauranteDTO>> restaurantesPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(restauranteService.restaurantesPorNome(nome));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestauranteDTO> atualizar(@PathVariable Long id, @RequestBody RestauranteDTO restaurante) {
        RestauranteDTO restauranteAtualizada = restauranteService.atualizar(id, restaurante);
        if (Objects.nonNull(restauranteAtualizada)) {
            return ResponseEntity.ok().body(restauranteAtualizada);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<RestauranteDTO>> listar() {
        return ResponseEntity.ok().body(restauranteService.listar());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        restauranteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
