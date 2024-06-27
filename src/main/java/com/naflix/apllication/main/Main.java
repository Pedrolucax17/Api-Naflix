package com.naflix.apllication.main;

import com.naflix.apllication.model.DataEpisode;
import com.naflix.apllication.model.DataSeason;
import com.naflix.apllication.model.DataSeries;
import com.naflix.apllication.service.ConsumeApi;
import com.naflix.apllication.service.ConvertData;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {
    private ConvertData convertData = new ConvertData();
    @Autowired
    private ConsumeApi consumeApi;

    public void showMenu(){
        String json = ConsumeApi.consumeApi("https://www.omdbapi.com/?t=the+boys&apikey=1e8a0a02");

        DataSeries series = convertData.getData(json, DataSeries.class);
        System.out.println(series);

        json = ConsumeApi.consumeApi("https://www.omdbapi.com/?t=the+boys&season=1&episode=1&apikey=1e8a0a02");
        DataEpisode episode = convertData.getData(json, DataEpisode.class);
        System.out.println(episode);

        json = ConsumeApi.consumeApi("https://www.omdbapi.com/?t=the+boys&season=1&apikey=1e8a0a02");
        DataSeason season = convertData.getData(json, DataSeason.class);
        System.out.println(season);

    }

}
