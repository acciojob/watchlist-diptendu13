package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepositorys;
    // add movie function
    public void addMovie(Movie movie){
        movieRepositorys.saveMovie(movie);
    }
    // add director function
    public void addDirector(Director director){
        movieRepositorys.saveDirector(director);
    }
    // create movie-director pair function
    public void createMovieDirectorPair(String movie, String director){
        movieRepositorys.saveMovieDirectorPair(movie, director);
    }
    // find movie function
    public Movie findMovie(String movieName){
        return movieRepositorys.findMovie(movieName);
    }
    // find director function
    public Director findDirector(String directorName){
        return movieRepositorys.findDirector(directorName);
    }
    // find list of movies from a director function
    public List<String> findMoviesFromDirector(String directorName){
        List<String> moviesList = movieRepositorys.findMoviesFromDirector(directorName);
        return moviesList;
    }
    // find all movies function
    public List<String> findAllMovies(){
        List<String> movies = movieRepositorys.findAllMovies();
        return movies;
    }
    // delete director function
    public void deleteDirector(String directorName){
        movieRepositorys.deleteDirector(directorName);
    }
    // delete all directors and their movies
    public void deleteAllDirectors(){
        movieRepositorys.deleteAllDirectors();
    }
}
