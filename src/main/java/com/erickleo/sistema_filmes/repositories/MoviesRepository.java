package com.erickleo.sistema_filmes.repositories;

import com.erickleo.sistema_filmes.entities.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MoviesRepository extends JpaRepository<MoviesEntity, UUID> {

    List<MoviesEntity> findByNote(Double note);
    List<MoviesEntity> findByGenreContainingIgnoreCase(String genre);
    MoviesEntity findByNameIgnoreCase(String name);
}