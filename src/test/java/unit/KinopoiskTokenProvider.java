package unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.afanasyev.adapter.kinopoisk.KinopoiskTokenProvider;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KinopoiskTokenProviderTest {
    private KinopoiskTokenProvider tokenProvider;

    @BeforeEach
    void setUp() {
        Deque<String> tokens = new ArrayDeque<>();
        tokens.addLast("first-1");
        tokens.addLast("second-2");
        tokenProvider = new KinopoiskTokenProvider(tokens);
    }

    @Test
    void getNextToken() {
        String token1 = tokenProvider.switchToken();
        String token2 = tokenProvider.switchToken();
        String token3 = tokenProvider.switchToken();

        assertEquals(token1, token3);
    }
}
