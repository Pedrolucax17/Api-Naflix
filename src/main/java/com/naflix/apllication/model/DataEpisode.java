package com.naflix.apllication.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisode(
        @JsonAlias("Title")
        String title,
        @JsonAlias("Episode")
        Integer numberEp,
        @JsonAlias("imdbRating")
        String rating,
        @JsonAlias("Released")
        String released
) {
}
