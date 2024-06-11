package ru.afanasyev.moviematch.adapter.persistence;

import jakarta.persistence.QueryHint;
import org.hibernate.jpa.AvailableHints;
import org.hibernate.jpa.HibernateHints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import ru.afanasyev.moviematch.domain.persistent.PersistentMovie;

import java.util.Optional;

public interface MovieJpaRepository extends JpaRepository<PersistentMovie, Long> {
    @QueryHints(
        @QueryHint(name = HibernateHints.HINT_CACHEABLE, value = "true")
    )
    Optional<PersistentMovie> findByName(String name);
}
