package com.naflix.apllication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Episode {
    private Integer season;
    private String title;
    private Integer numberEp;
    private Double rating;
    private LocalDate released;

    private Episode(Integer season, DataEpisode dataEpisode){
        this.season = season;
        this.title = dataEpisode.title();
        this.numberEp = dataEpisode.numberEp();
        try{
            this.rating = Double.valueOf(dataEpisode.rating());
        }catch (NumberFormatException e){
            this.rating = 0.0;
        }
        this.released = LocalDate.parse(dataEpisode.released());

    }

    @Override
    public String toString() {
        return "Episode{" +
                "season=" + season +
                ", title='" + title + '\'' +
                ", numberEp=" + numberEp +
                ", rating=" + rating +
                ", relesead=" + released +
                '}';
    }

}
