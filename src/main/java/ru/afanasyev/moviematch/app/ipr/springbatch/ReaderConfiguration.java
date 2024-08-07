package ru.afanasyev.moviematch.app.ipr.springbatch;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.afanasyev.moviematch.app.api.GetRandomMovieOutbound;
import ru.afanasyev.moviematch.domain.movie.Movie;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class ReaderConfiguration {
    //https://becomegeeks.com/blog/
    // mastering-real-time-data-processing-with-kafkaitemreader-and-kafkaitemwriter-in-spring-batch/
    // Kafka readers

    //    @Bean
    //    public class JsonItemReader extends KafkaItemReader<Movie> {
    //        public JsonItemReader() {
    //            super(new DefaultKafkaConsumerFactory<>(new HashMap<>()), Arrays.asList("input_topic_1", "input_topic_2"));
    //        }
    //    }

//  Работающий бин
//    @Bean
//    @StepScope
//    public FlatFileItemReader<Movie> reader(@Value("#{jobParameters['file.input']}") String input) {
//        FlatFileItemReaderBuilder<Movie> movieFlatFileItemReaderBuilder = new FlatFileItemReaderBuilder<>();
//        BeanWrapperFieldSetMapper<Movie> mapper = new BeanWrapperFieldSetMapper<>();
//        mapper.setTargetType(Movie.class);
//        return movieFlatFileItemReaderBuilder
//            .name("movieReader")
//            .resource(new FileSystemResource(input))
//            .delimited()
//            .names("name", "movieLength")
//            .fieldSetMapper(mapper)
//            .build();
//    }

    @Bean
    @StepScope
    public OutboundMovieReader outboundMovieReader(GetRandomMovieOutbound getRandomMovieOutbound) {
        AtomicInteger readSize = new AtomicInteger(3);
        return () -> {
            if (readSize.get() <= 0) {
                return null;
            }
            readSize.getAndDecrement();
            return getRandomMovieOutbound.getRandomMovie();
        };
    }

    public interface OutboundMovieReader extends ItemReader<Movie> {

    }
}
