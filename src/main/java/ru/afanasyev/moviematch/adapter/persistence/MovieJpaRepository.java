package ru.afanasyev.moviematch.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.afanasyev.moviematch.domain.persistent.PersistentMovie;

public interface MovieJpaRepository extends JpaRepository<PersistentMovie, Long> {
}
