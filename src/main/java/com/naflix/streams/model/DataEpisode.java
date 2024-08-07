package com.naflix.streams.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataEpisode(
        @JsonAlias("Title")
        String title,
        @JsonAlias("Released")
        String released,
        @JsonAlias("Episode")
        String episode,
        @JsonAlias("imdbRating")
        String imdbRating
) {
}
