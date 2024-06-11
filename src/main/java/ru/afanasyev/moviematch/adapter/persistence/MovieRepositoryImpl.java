package ru.afanasyev.moviematch.adapter.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.afanasyev.moviematch.app.api.MovieRepository;
import ru.afanasyev.moviematch.domain.persistent.PersistentMovie;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieRepositoryImpl implements MovieRepository {
    private final MovieJpaRepository repository;

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Optional<PersistentMovie> findByName(String name) {
        return repository.findByName(name);
    }
}
