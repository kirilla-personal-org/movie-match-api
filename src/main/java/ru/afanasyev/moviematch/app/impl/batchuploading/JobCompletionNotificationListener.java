package ru.afanasyev.moviematch.app.impl.batchuploading;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;
import ru.afanasyev.moviematch.app.api.MovieRepository;

@Component
@Slf4j
@RequiredArgsConstructor
public class JobCompletionNotificationListener implements JobExecutionListener {
    private final MovieRepository movieRepository;

    @Override
    public void afterJob(JobExecution jobExecution) {
        long count = movieRepository.count();
        log.info("Job finished with status: {}, total movies in db: {}", jobExecution.getStatus(), count);
    }
}
