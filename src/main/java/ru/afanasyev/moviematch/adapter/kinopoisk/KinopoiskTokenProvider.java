package ru.afanasyev.adapter.kinopoisk;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.afanasyev.app.api.TokenProvider;

import java.util.Deque;

@Component
@Slf4j
public class KinopoiskTokenProvider implements TokenProvider {
    private final Deque<String> tokens;

    public KinopoiskTokenProvider(@Qualifier("kinopoisk-tokens") Deque<String> tokens) {
        this.tokens = tokens;
        log.info("Found {} kinopoisk tokens", tokens.size());
    }

    @Override
    public String switchToken() {
        if (tokens.isEmpty()) {
            throw new NullPointerException("No Available tokens");
        }
        String token = tokens.pollFirst();
        tokens.addLast(token);

        return token;
    }
}
