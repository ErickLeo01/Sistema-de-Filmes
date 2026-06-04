package com.erickleo.sistema_filmes.services;

import com.erickleo.sistema_filmes.entities.MoviesEntity;
import com.erickleo.sistema_filmes.repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public String registerMovie(MoviesEntity moviesEntity) {
        if(moviesRepository.findByNameIgnoreCase(moviesEntity.getName()) != null) {
            throw new RuntimeException("Filme já cadastrado!");
        }

        moviesRepository.save(moviesEntity);
        return "Filme: " + moviesEntity.getName() + " cadastrado com sucesso!" ;
    }

    public String updateMovie(MoviesEntity moviesEntity) {
        moviesRepository.findById(moviesEntity.getId() )
                .orElseThrow(() -> new RuntimeException("Filme não encontrado! Tente novamente"));
        moviesRepository.save(moviesEntity);
        return "A informações do filme: " + moviesEntity.getName() + " foram atualizadas com sucesso!";
    }

    public List<MoviesEntity> findByNote(Double note) {
        if(note < 0 || note > 10) {
            throw new RuntimeException("A nota do filme não pode ser menor que 0 e maior que 10");
        }
        return moviesRepository.findByNote(note);
    }

    public List<MoviesEntity> findByGenre(String genre) {
        return moviesRepository.findByGenreContainingIgnoreCase(genre);
    }

    public List<MoviesEntity> findAll() {
        return moviesRepository.findAll();
    }

    public String deleteMovie(UUID id) {
        if(moviesRepository.existsById(id) == false) {
        throw new RuntimeException("Filme não encontrado! Tente novamente");
        }
            moviesRepository.deleteById(id);
        return "Filme deletado com sucesso!";
    }

}