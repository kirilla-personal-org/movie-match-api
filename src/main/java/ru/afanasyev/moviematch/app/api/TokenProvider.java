package ru.afanasyev.moviematch.app.api;

public interface TokenProvider {
    /**
     * Получить доступный токен
     *
     * @return Доступный токен
     */
    String switchToken();
}
