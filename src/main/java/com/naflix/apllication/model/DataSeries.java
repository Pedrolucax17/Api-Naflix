package com.naflix.apllication.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.aspectj.apache.bcel.classfile.Unknown;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataSeries(
        @JsonAlias("Title")
        String title,
        @JsonAlias("totalSeasons")
        Integer totalSeason,
        @JsonAlias("imdbRating")
        String rating,
        @JsonAlias("Genre")
        String category,
        @JsonAlias("Actors")
        String actors,
        @JsonAlias("Plot")
        String plot,
        @JsonAlias("Poster")
        String poster

) {
}
