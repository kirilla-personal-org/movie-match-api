package ru.afanasyev.moviematch.adapter.kinopoisk.dto;

import org.mapstruct.Mapper;
import ru.afanasyev.moviematch.domain.movie.Movie;

@Mapper
public interface MovieDomainMapper {
    Movie mapToDomain(MovieDto source);
}
