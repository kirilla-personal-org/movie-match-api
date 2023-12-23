package ru.afanasyev.adapter;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.afanasyev.app.api.TokenProvider;

@Getter
@Slf4j
public abstract class AbstractMovieAdapter {
    protected final TokenProvider tokenProvider;
    protected String token;

    protected AbstractMovieAdapter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
        token = tokenProvider.switchToken();
    }

    public void switchToken() {
        token = tokenProvider.switchToken();
        log.info("Switching token to: {}", token);
    }
}
