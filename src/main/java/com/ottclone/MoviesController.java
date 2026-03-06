package com.ottclone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ottclone.Entity.Movie;
import com.ottclone.Entity.MovieUpdateRequest;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    @Autowired
    MoviesService moviesService;
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(moviesService.getAllMovies());
    }
    @PostMapping("/add")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie mov){
        return ResponseEntity.ok(moviesService.addMovie(mov));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>  deleteMovie(@PathVariable String id){
        moviesService.deleteMovie(id);
        return ResponseEntity.ok("Successfully Deleted");
    }
    @PatchMapping("/patch/{id}")
    public ResponseEntity<Movie> patchMovie(@PathVariable String id, @RequestBody MovieUpdateRequest dto){
        return ResponseEntity.ok(moviesService.patchMovie(id,dto));
    }
    
    
}
