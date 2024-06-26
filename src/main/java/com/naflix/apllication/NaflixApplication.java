package com.naflix.apllication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class NaflixApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NaflixApplication.class, args);
	}

	@Override
	public void run(String... args){

    }
}
