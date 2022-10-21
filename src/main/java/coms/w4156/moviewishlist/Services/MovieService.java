package coms.w4156.moviewishlist.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms.w4156.moviewishlist.models.Movie;
import coms.w4156.moviewishlist.repository.MovieRepository;

@Service
public class MovieService extends ServiceForRepository<Long, Movie, MovieRepository> {
    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }
}