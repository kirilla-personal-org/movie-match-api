package ru.afanasyev.adapter.rest.v1.movie.dto;

import org.mapstruct.Mapper;
import ru.afanasyev.domain.movie.Movie;

@Mapper
public interface MovieDtoMapper {
    MovieDto mapToDto(Movie source);
}
