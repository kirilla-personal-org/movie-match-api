package ru.afanasyev.adapter.kinopoisk.dto;

import lombok.Data;

@Data
public class RatingDto {
    private String kp;
    private String imdb;
    private String filmCritics;
    private String russianFilmCritics;
}
