package com.erickleo.sistema_filmes.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class MoviesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O título do filme não pode ser nulo!")
    private String name;

    @NotBlank(message = "O gênero do filme não pode ser nulo!")
    private String genre;


    @NotNull(message = "A descrição do filme não pode ser nula!")
    private String duration;

    @NotNull(message = "A nota do filme não pode ser nula!")
    private Double note;

    @Column(length = 5000)
    @NotBlank(message = "A sinopse não pode ser nula!")
    private String synopsis;

}