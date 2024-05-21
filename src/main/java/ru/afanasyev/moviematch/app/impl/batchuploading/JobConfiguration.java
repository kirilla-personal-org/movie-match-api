package ru.afanasyev.moviematch.app.impl.batchuploading;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import ru.afanasyev.moviematch.domain.movie.Movie;
import ru.afanasyev.moviematch.domain.persistent.PersistentMovie;

import javax.sql.DataSource;

@Configuration
public class JobConfiguration {
    @Bean
    @StepScope
    public JdbcBatchItemWriter<PersistentMovie> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PersistentMovie>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO movie (movie_length, name) VALUES (:length, :name)")
            .dataSource(dataSource)
            .build();
    }

    @Bean
    public Job importMovieJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step step1) {
        return new JobBuilder("importMovieJob", jobRepository)
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(
        JobRepository jobRepository,
        PlatformTransactionManager transactionManager,
//        FlatFileItemReader<Movie> reader,
        ReaderConfiguration.OutboundMovieReader reader,
        JdbcBatchItemWriter<PersistentMovie> writer,
        ProcessorConfiguration processorConfiguration
    ) {
        return new StepBuilder("step1", jobRepository)
            .<Movie, PersistentMovie>chunk(10, transactionManager)
            .reader(reader)
            .processor(processorConfiguration)
            .writer(writer)
            .build();
    }
}
