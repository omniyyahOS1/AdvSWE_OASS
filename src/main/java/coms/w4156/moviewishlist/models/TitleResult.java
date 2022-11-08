package coms.w4156.moviewishlist.models;

public record TitleResult(
    Long id,
    String name,
    String type,
    Long year,
    String imdb_id,
    Long tmdb_id,
    String tmdb_type
) {}
