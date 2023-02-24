package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    MovieService movieServices;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieServices.addMovie(movie);
        return new ResponseEntity<>("new movie added successfully", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieServices.addDirector(director);
        return new ResponseEntity<>("new director added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie, @RequestParam("director") String director){
        movieServices.createMovieDirectorPair(movie, director);
        return new ResponseEntity<>("new movie-director pair added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){
        Movie movie = movieServices.findMovie(movieName);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String directorName){
        Director director = movieServices.findDirector(directorName);
        return new ResponseEntity<>(director, HttpStatus.CREATED);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName){
        List<String> movies = movieServices.findMoviesFromDirector(directorName);
        return new ResponseEntity<List<String>>(movies, HttpStatus.CREATED);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieServices.findAllMovies();
        return new ResponseEntity<List<String>>(movies, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String directorName){
        movieServices.deleteDirector(directorName);
        return new ResponseEntity<>("director name deleted successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieServices.deleteAllDirectors();
        return new ResponseEntity<>("all directors and all movies by them deleted successfully", HttpStatus.OK);
    }
}
