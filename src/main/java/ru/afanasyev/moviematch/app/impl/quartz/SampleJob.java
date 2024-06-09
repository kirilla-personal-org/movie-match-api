package ru.afanasyev.moviematch.app.impl.quartz;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static ru.afanasyev.moviematch.app.impl.quartz.QuartzStarter.ID_KEY;

@Component
@Slf4j
@RequiredArgsConstructor
public class SampleJob implements Job {
    private final Scheduler scheduler;
    private final QuartzStarter starter;

    @SneakyThrows
//    @Scheduled(fixedDelay = 1000)
    public void runJob() {
        JobDetail jobDetail = starter.createJobDetails(UUID.randomUUID().toString());
        Trigger trigger = TriggerBuilder.newTrigger().forJob(jobDetail).startNow().build();
        scheduler.scheduleJob(jobDetail, trigger);
    }


    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Object id = context.getJobDetail().getJobDataMap().get(ID_KEY);
        log.info("Executing job with id: {}", id);
    }
}
