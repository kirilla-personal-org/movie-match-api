package ru.afanasyev.moviematch.adapter.rest.v1.movie.dto;

import org.mapstruct.Mapper;
import ru.afanasyev.moviematch.domain.movie.Movie;

@Mapper
public interface MovieDtoMapper {
    MovieDto mapToDto(Movie source);
}
