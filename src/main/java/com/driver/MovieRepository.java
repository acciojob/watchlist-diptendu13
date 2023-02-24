package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMap;

    public MovieRepository(){
        this.movieMap = new HashMap<>();
        this.directorMap = new HashMap<>();
        this.directorMovieMap = new HashMap<>();
    }
    // save movie function
    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(), movie);
    }
    // save director function
    public void saveDirector(Director director){
        directorMap.put(director.getName(), director);
    }
    // save movie-director pair function
    public void saveMovieDirectorPair(String movie, String director){
        if (movieMap.containsKey(movie) && directorMap.containsKey(director)){
            if (directorMovieMap.containsKey(director)){
                List<String> currentMovies = directorMovieMap.get(director);
                currentMovies.add(movie);
                directorMovieMap.put(director, currentMovies);
            }
            else{
                List<String> currentMovies = new ArrayList<>();
                currentMovies.add(movie);
                directorMovieMap.put(director, currentMovies);
            }
        }
    }
    // find movie function
    public Movie findMovie(String movieName){
        return movieMap.get(movieName);
    }
    // find director function
    public Director findDirector(String directorName){
        return directorMap.get(directorName);
    }
    // find list of movies from a director function
    public List<String> findMoviesFromDirector(String directorName){
        List<String> movieList = new ArrayList<>();
        if (directorMovieMap.containsKey(directorName)){
            movieList = directorMovieMap.get(directorName);
        }
        return movieList;
    }
    // find all movies function
    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }
    // delete director function
    public void deleteDirector(String directorName){
        List<String> movies = new ArrayList<>();
        if (directorMovieMap.containsKey(directorName)){
            movies = directorMovieMap.get(directorName);
            directorMovieMap.remove(directorName);
        }
        for (String movie : movies){
                movieMap.remove(movie);
        }
    }
    // delete all directors
    public void deleteAllDirectors(){
        for (String director : directorMovieMap.keySet()) {
            List<String> movies = directorMovieMap.get(director);
            for (String movie : movies){
                movieMap.remove(movie);
            }
            directorMap.remove(director);
        }
    }
}
