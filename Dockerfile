FROM openjdk:17
COPY build/libs/movie-match-plain.jar movie-match.jar
ENTRYPOINT ["java", "-jar", "/movie-match.jar"]