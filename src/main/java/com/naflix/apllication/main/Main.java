package com.naflix.apllication.main;

import com.naflix.apllication.model.DataEpisode;
import com.naflix.apllication.model.DataSeason;
import com.naflix.apllication.model.DataSeries;
import com.naflix.apllication.service.ConsumeApi;
import com.naflix.apllication.service.ConvertData;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private Scanner sc = new Scanner(System.in);
    private final String BASE_URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=1e8a0a02";
    private ConvertData convertData = new ConvertData();
    @Autowired
    private ConsumeApi consumeApi;

    public void showMenu(){

        System.out.print("Digite o nome da série: ");
        String nameSerie = sc.nextLine();

        String json = ConsumeApi.consumeApi(BASE_URL + nameSerie.replace(" ", "+") + API_KEY);

        DataSeries series = convertData.getData(json, DataSeries.class);
        System.out.println(series);

        List<DataSeason> seasons = new ArrayList<>();

        for(int i = 1; i <= series.totalSeason(); i++){
            json = ConsumeApi.consumeApi(BASE_URL + nameSerie.replace(" ", "+") + "&season=" + i + API_KEY);
            DataSeason season = convertData.getData(json, DataSeason.class);
            seasons.add(season);
        }

        seasons.forEach(System.out::println);

        seasons.forEach(s -> s.episodes().forEach(e -> System.out.println(e.title())));

    }

}
