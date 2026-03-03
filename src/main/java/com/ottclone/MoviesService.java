package com.ottclone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ottclone.Entity.Movie;

@Service
public class MoviesService {
    @Autowired
    MoviesRepo mr ;
    public List<Movie> getAllMovie(){
        return mr.findAll();
    }
    public Movie addMovie(Movie mov){
        return mr.save(mov);
    }
    
}
