package ru.afanasyev.moviematch.domain.movie;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movie")
@Accessors(chain = true)
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "movie_length")
    private Integer length;
    @Column(name = "name")
    private String name;

    // TODO remove @Transient
    @Transient
    private Poster poster;
    @Transient
    private List<Genre> genres;
    @Transient
    private Integer year;
    @Transient
    private Rating rating;
}
