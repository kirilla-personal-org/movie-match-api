create table recommendation_to_movie
(
    recommendation_id uuid,
    movie_id          bigint,
    primary key (recommendation_id, movie_id)
);