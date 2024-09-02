package ru.afanasyev.moviematch.adapter.kinopoisk.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.afanasyev.moviematch.domain.movie.Movie;

@Mapper
public interface MovieDomainMapper {
    @Mapping(target = "length", source = "movieLength")
    Movie mapToDomain(MovieDto source);
}
