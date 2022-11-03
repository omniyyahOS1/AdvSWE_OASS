package coms.w4156.moviewishlist.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import coms.w4156.moviewishlist.models.Movie;
import coms.w4156.moviewishlist.models.User;
import coms.w4156.moviewishlist.services.MovieService;
import coms.w4156.moviewishlist.services.UserService;

@Controller
public class GraphqlController {

    /**
     * Use dependency injection to inject an object of the UserService class.
     */
    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    /**
     * Fetch all users in the database.
     *
     * @return List of User objects
     */
    @QueryMapping
    public Collection<User> users() {
        return userService.getAll();
    }

    /**
     * Fetch a user by email.
     *
     * @param email - The email address of the user
     *
     * @return List of User objects
     */
    @QueryMapping
    public Optional<User> userByEmail(@Argument final String email) {
        System.out.print(email);
        return userService.findById(email);
    }

    /**
     * Fetch all movies in the database.
     *
     * @return List of User objects
     */
    @QueryMapping
    public Collection<Movie> movies() {
        return movieService.getAll();
    }
}
