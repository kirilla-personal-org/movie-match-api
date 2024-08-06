package ru.afanasyev.moviematch.app.ipr.springbatch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import ru.afanasyev.moviematch.domain.movie.Movie;
import ru.afanasyev.moviematch.domain.persistent.PersistentMovie;

@Component
public class ProcessorConfiguration implements ItemProcessor<Movie, PersistentMovie> {
    @Override
    public PersistentMovie process(Movie item) throws Exception {
        return new PersistentMovie()
            .setLength(item.getMovieLength())
            .setName(item.getName());
    }
}
