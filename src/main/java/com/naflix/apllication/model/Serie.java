package com.naflix.apllication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.OptionalDouble;

@Setter
@Getter
@NoArgsConstructor
@Entity(name = "Serie")
@Table(name = "tbl_serie")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(name = "total_season")
    private Integer totalSeason;
    private Double rating;

    @Enumerated(EnumType.STRING)
    private Category genre;
    private String actors;
    private String plot;
    private String poster;

    public Serie(DataSeries dataSeries){
        this.title = dataSeries.title();
        this.totalSeason = dataSeries.totalSeason();
        this.rating = OptionalDouble.of(Double.parseDouble(dataSeries.rating())).orElse(0.0);
        this.genre = Category.fromString(dataSeries.category().split(",")[0].trim());
        this.actors = dataSeries.actors();
        this.plot = dataSeries.plot();
        this.poster = dataSeries.poster();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return Objects.equals(title, serie.title) && Objects.equals(totalSeason, serie.totalSeason) && Objects.equals(rating, serie.rating) && genre == serie.genre && Objects.equals(actors, serie.actors) && Objects.equals(plot, serie.plot) && Objects.equals(poster, serie.poster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, totalSeason, rating, genre, actors, plot, poster);
    }

    @Override
    public String toString() {
        return "Genre=" + genre +
                ", title='" + title + '\'' +
                ", totalSeason=" + totalSeason +
                ", rating=" + rating +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
