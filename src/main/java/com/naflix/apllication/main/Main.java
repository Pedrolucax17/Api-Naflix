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
        int option = -1;
        while(option != 0){
            String menu = """
                1 - Buscar séries
                2 - Buscar episódios
                
                0 - Sair                                 
                """;

            System.out.println(menu);
            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1:
                    seachSerie();
                    break;
                case 2:
                    searchEpisode();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    private void seachSerie(){
        DataSeries serie = getDataSerie();
        System.out.println(serie);
    }

    private DataSeries getDataSerie(){
        System.out.print("Digite o nome da série: ");
        String nameSerie = sc.nextLine();

        String json = ConsumeApi.consumeApi(BASE_URL + nameSerie.replace(" ", "+") + API_KEY);

        return convertData.getData(json, DataSeries.class);
    }

    private void searchEpisode(){
        DataSeries serie = getDataSerie();

        List<DataSeason> seasons = new ArrayList<>();

        for(int i = 1; i <= serie.totalSeason(); i++){
            String json = ConsumeApi.consumeApi(BASE_URL + serie.title().replace(" ", "+") + "&season=" + i + API_KEY);
            DataSeason season = convertData.getData(json, DataSeason.class);
            seasons.add(season);
        }
        seasons.forEach(System.out::println);
    }
}
