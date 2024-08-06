create table movie
(
    id           bigint primary key generated always as identity,
    movie_length int,
    name         varchar
);