package com.ottclone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ottclone.Entity.Movie;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Autowired
    MoviesService ms;
    @GetMapping("/all")
    public List<Movie> getMethodName() {
        return ms.getAllMovie();
    }
    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie mov){
        return ms.addMovie(mov);
    }
    
    
}
