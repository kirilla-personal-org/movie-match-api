package ru.afanasyev.moviematch.adapter.rest.v1.movie.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.afanasyev.moviematch.domain.movie.Movie;

@Mapper
public interface MovieDtoMapper {
    @Mapping(source = "length", target = "movieLength")
    MovieDto mapToDto(Movie source);
}
