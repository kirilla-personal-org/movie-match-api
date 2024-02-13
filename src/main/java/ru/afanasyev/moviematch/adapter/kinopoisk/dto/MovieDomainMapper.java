package ru.afanasyev.adapter.kinopoisk.dto;

import org.mapstruct.Mapper;
import ru.afanasyev.domain.movie.Movie;

@Mapper
public interface MovieDomainMapper {
    Movie mapToDomain(MovieDto source);
}
