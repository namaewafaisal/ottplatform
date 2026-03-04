package com.ottclone.Entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movies")
public class Movie {

    @Id
    private String id;   // MongoDB _id mapped as String

    private String plot;
    private String fullplot;
    private List<String> genres;
    private Integer runtime;
    private List<String> cast;
    private String poster;
    private String title;
    private List<String> languages;
    private Date released;
    private List<String> directors;
    private String rated;
    private Awards awards;
    private String lastupdated;
    private Integer year;
    private Imdb imdb;
    private List<String> countries;
    private String type;
    private Tomatoes tomatoes;
    private Integer num_mflix_comments;
}