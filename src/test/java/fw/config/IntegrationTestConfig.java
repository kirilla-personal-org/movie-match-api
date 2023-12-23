package fw.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.io.IOException;
import java.io.Serial;

@Configuration
@ComponentScan
public class IntegrationTestConfig {
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder) {
        ObjectMapper objectMapper = jackson2ObjectMapperBuilder.createXmlMapper(false).build();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.setDefaultPrettyPrinter(new MyDefaultPrettyPrinter());
        return objectMapper;
    }

    private static class MyDefaultPrettyPrinter extends DefaultPrettyPrinter {
        @Serial
        private static final long serialVersionUID = 9003705494148916471L;

        public MyDefaultPrettyPrinter() {
            this._objectIndenter = new DefaultIndenter("  ", System.lineSeparator());
            this._arrayIndenter = _objectIndenter;
        }

        @Override
        public DefaultPrettyPrinter createInstance() {
            return new MyDefaultPrettyPrinter();
        }

        @Override
        public void writeObjectFieldValueSeparator(JsonGenerator jg) throws IOException {
            jg.writeRaw(": ");
        }
    }
}
