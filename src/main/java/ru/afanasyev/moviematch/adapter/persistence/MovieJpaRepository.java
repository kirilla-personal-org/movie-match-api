package ru.afanasyev.moviematch.adapter.persistence;

import jakarta.persistence.QueryHint;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import ru.afanasyev.moviematch.domain.movie.Movie;

import java.util.Optional;

public interface MovieJpaRepository extends JpaRepository<Movie, Long> {
    @QueryHints(
        @QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "true")
    )
    Optional<Movie> findByName(String name);
}
