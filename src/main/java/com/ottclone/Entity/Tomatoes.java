package com.ottclone.Entity;

import lombok.Data;
import java.util.Date;
@Data

public class Tomatoes {

    private Viewer viewer;
    private Integer fresh;
    private Critic critic;
    private Integer rotten;
    private Date lastUpdated;

    @Data
    public static class Viewer {
        private Double rating;
        private Integer numReviews;
        private Integer meter;
    }

    @Data
    public static class Critic {
        private Double rating;
        private Integer numReviews;
        private Integer meter;
    }
}
