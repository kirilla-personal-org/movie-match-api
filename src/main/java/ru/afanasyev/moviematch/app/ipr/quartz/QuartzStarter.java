package ru.afanasyev.moviematch.app.ipr.quartz;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.UUID;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

@Configuration
@PropertySource("classpath:quartz.properties")
public class QuartzStarter {
    public static final String ID_KEY = "id";

    //@Bean - Расписание запусков quartz
    public Trigger trigger(JobDetail job) {
        return TriggerBuilder.newTrigger().forJob(job)
            .withIdentity("Qrtz_Trigger")
            .withDescription("Sample trigger")
            .withSchedule(simpleSchedule().repeatForever().withIntervalInMilliseconds(1000))
            .build();
    }

    @Bean
    public JobDetail jobDetail() {
        return createJobDetails("Qrtz_Job_Detail");
    }

    public JobDetail createJobDetails(String identity) {
        return JobBuilder.newJob().ofType(SampleJob.class)
            .storeDurably()
            .withIdentity(identity)
            .withDescription("Invoke Sample Job service...")
            .setJobData(createJobData())
            .build();
    }

    // ===================================================================================================================
    // = Implementation
    // ===================================================================================================================

    private JobDataMap createJobData() {
        JobDataMap map = new JobDataMap();
        map.put(ID_KEY, UUID.randomUUID());
        return map;
    }
}
