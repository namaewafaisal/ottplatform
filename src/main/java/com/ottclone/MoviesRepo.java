package com.ottclone;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ottclone.Entity.Movie;

public interface MoviesRepo extends MongoRepository<Movie,String> {

    
} 
