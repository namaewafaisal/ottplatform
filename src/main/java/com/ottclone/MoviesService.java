package com.ottclone;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ottclone.Entity.Movie;
import com.ottclone.Entity.MovieUpdateRequest;

@Service
public class MoviesService {
    @Autowired
    MoviesRepo moviesRepo ;
    public List<Movie> getAllMovies(){
        return moviesRepo.findAll();
    }
    public Movie addMovie(Movie movie){
        return moviesRepo.save(movie);
    }
    public void deleteMovie(String id) {
        Movie movie = moviesRepo.findById(id).orElseThrow(() -> new RuntimeException("Movie not Found"));
        moviesRepo.deleteById(id);
        return;
    }

	public Movie patchMovie(String id, MovieUpdateRequest dto) {
		Movie movie = moviesRepo.findById(id).orElseThrow(() -> new RuntimeException("Movie not Found"));
        BeanUtils.copyProperties(dto, movie, getNullPropertyNames(dto));
        return moviesRepo.save(movie);
    }
    
}
