package com.naflix.streams.main;

import com.naflix.streams.model.DataSeason;
import com.naflix.streams.model.DataSerie;
import com.naflix.streams.service.ConsumeApi;
import com.naflix.streams.service.ConvertData;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Main {

    private ConvertData convertData = new ConvertData();

    private Scanner sc = new Scanner(System.in);
    private final String BASE_URL = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=1e8a0a02";

    public void showMenu(){
        System.out.println("Digite a séria que você deseja: ");
        String serie = sc.nextLine();
        String json = ConsumeApi.consumeApi(BASE_URL + serie + API_KEY);
        DataSerie searchSerie = convertData.getDatas(json, DataSerie.class);
        System.out.println(json);
        System.out.println(searchSerie);

        List<DataSeason> seasons = new ArrayList<>();

        System.out.println("***TEMPORADAS***");
        for(int i = 1; i <= searchSerie.totalSeasons(); i++){
            String newJson = ConsumeApi.consumeApi(BASE_URL + serie + "&season=" + i + API_KEY);
            DataSeason season = convertData.getDatas(newJson, DataSeason.class);
            seasons.add(season);
            System.out.println(season);
        }

        System.out.println("***EPISODIOS***");
        seasons.forEach(t -> t.episodes().forEach(e -> System.out.println(e.title())));

    }
}