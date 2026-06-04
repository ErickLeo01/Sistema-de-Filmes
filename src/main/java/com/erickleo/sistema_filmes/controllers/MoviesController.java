package com.erickleo.sistema_filmes.controllers;


import com.erickleo.sistema_filmes.entities.MoviesEntity;
import com.erickleo.sistema_filmes.repositories.MoviesRepository;
import com.erickleo.sistema_filmes.services.MoviesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/filme")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @PostMapping("/registrarFilme")
    public String registerMovie(@Valid @RequestBody MoviesEntity moviesEntity) {
        return moviesService.registerMovie(moviesEntity);
    }

    @PutMapping("/atualizarFilme")
    public String updateMovie(@Valid @RequestBody MoviesEntity moviesEntity) {
    return moviesService.updateMovie(moviesEntity);
    }

    @GetMapping("/buscarPorNota")
    public List<MoviesEntity> findByNote(@Valid @RequestParam Double note) {
        return moviesService.findByNote(note);
    }

    @GetMapping("/buscarPorGenero")
    public List<MoviesEntity> findByGenre(@Valid @RequestParam String genre) {
        return moviesService.findByGenre(genre);
    }

    @GetMapping("/mostrarTodosFilmes")
    public List<MoviesEntity> findAll() {
        return moviesService.findAll();
    }

    @DeleteMapping("/deletarFilme/{id}")
    public String deleteMovie(@Valid @PathVariable UUID id) {
        return moviesService.deleteMovie(id);
    }
}