package ru.afanasyev.moviematch.adapter.kinopoisk;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class RestTemplateProvider {
    private static final String KINOPOISK_URL = "https://api.kinopoisk.dev";
    private static final String TOKEN_HEADER_NAME = "X-API-KEY";

    public RestTemplateBuilder build(String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(TOKEN_HEADER_NAME, token);
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        return new RestTemplateBuilder()
            .setRestTemplate(restTemplate)
            .setEntity(entity);
    }

    @NoArgsConstructor
    @Setter
    @Accessors(chain = true)
    static class RestTemplateBuilder {
        private RestTemplate restTemplate;
        private HttpEntity<String> entity;

        public <T> T exchange(String path, HttpMethod method, Class<T> clazz) {
            return restTemplate.exchange(KINOPOISK_URL + path, method, entity, clazz).getBody();
        }
    }
}
