package ru.afanasyev.moviematch.adapter.rest.v1.movie.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.afanasyev.moviematch.domain.movie.Movie;
import ru.afanasyev.moviematch.domain.persistent.PersistentMovie;

@Mapper
public interface MovieDtoMapper {
    MovieDto mapToDto(Movie source);

    @Mapping(source = "length", target = "movieLength")
    MovieDto mapToDto(PersistentMovie source);
}
