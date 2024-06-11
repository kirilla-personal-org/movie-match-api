package ru.afanasyev.moviematch.app.impl.springbatch;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Slf4j
@RequiredArgsConstructor
public class UploadMoviesUseCase {
    private final JobLauncher jobLauncher;
    private final Job job;
    @Value("${file.input:}")
    private String input;

    @SneakyThrows
//    @EventListener(ApplicationReadyEvent.class)
    public void uploadFromCsv() {
        log.info("Uploading movies started");
        JobParametersBuilder jobParameters = new JobParametersBuilder();
        jobParameters.addString("file.input", input);
        jobLauncher.run(job, jobParameters.toJobParameters());
    }

    @SneakyThrows
//    @EventListener(ApplicationReadyEvent.class)
    public void uploadFromOutbound() {
        log.info("Uploading movies started");
        JobParametersBuilder jobParameters = new JobParametersBuilder();
        jobParameters.addString("startTime", Instant.now().toString());
        jobLauncher.run(job, jobParameters.toJobParameters());
    }
}
