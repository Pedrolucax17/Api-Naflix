package com.naflix.apllication.model;

import java.util.Objects;
import java.util.OptionalDouble;

public class Serie {
    private String title;
    private Integer totalSeason;
    private Double rating;
    private Category genre;
    private String actors;
    private String plot;
    private String poster;

    public Serie(DataSeries dataSeries){
        this.title = dataSeries.title();
        this.totalSeason = dataSeries.totalSeason();
        this.rating = OptionalDouble.of(Double.parseDouble(dataSeries.rating())).orElse(0.0);
        this.genre = Category.fromString(dataSeries.category());
        this.actors = dataSeries.actors();
        this.plot = dataSeries.plot();
        this.poster = dataSeries.poster();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalSeason() {
        return totalSeason;
    }

    public void setTotalSeason(Integer totalSeason) {
        this.totalSeason = totalSeason;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Category getGenre() {
        return genre;
    }

    public void setGenre(Category genre) {
        this.genre = genre;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
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
        return "Serie{" +
                "title='" + title + '\'' +
                ", totalSeason=" + totalSeason +
                ", rating=" + rating +
                ", genre=" + genre +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
