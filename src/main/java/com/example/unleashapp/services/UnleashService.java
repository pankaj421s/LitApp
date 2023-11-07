package com.example.unleashapp.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.unleashapp.models.Actor;
import com.example.unleashapp.models.Movie;

import io.getunleash.DefaultUnleash;
import io.getunleash.Unleash;
import io.getunleash.UnleashContext;
import io.getunleash.UnleashContextProvider;
import io.getunleash.Variant;
import io.getunleash.util.UnleashConfig;
//import jakarta.annotation.PostConstruct;
import jakarta.annotation.PostConstruct;

//@Service
public class UnleashService {
	Variant variant;
	private Unleash unleash;
	@PostConstruct
	public void init()
	{
		UnleashConfig config=UnleashConfig.builder().appName("unleash-app").instanceId("pk").environment("development")/*.unleashContextProvider(new UnleashContextProvider() {
			
			@Override
			public UnleashContext getContext() {
				// TODO Auto-generated method stub
				Map<String,String> cMap=new HashMap<>();
			//	cMap.put("appBrand", "BOS");
				return  new UnleashContext(null, null, null, cMap);
			}
		})*/.unleashAPI("http://localhost:4242/api/").synchronousFetchOnInitialisation(true).apiKey("*:development.56c6ddd9ea8639361accfb7823bbd58955f865d4e9f6a74ff7f07361").build();
		unleash=new DefaultUnleash(config);
		
		//UnleashContext
	}
	public Variant getVariant() {
		return variant;
	}
	public void setVariant(Variant variant) {
		this.variant = variant;
	}
	public Unleash getUnleash() {
		return unleash;
	}
	public void setUnleash(Unleash unleash) {
		this.unleash = unleash;
	}
	public Movie getMovie()
	{
		Movie movie=new Movie();
		movie.setId("12");
		movie.setName("Shakti");
		Actor actor=new Actor();
		actor.setName("Big B");
		actor.setAge(76);
		List<Actor> actors=new ArrayList<>();
		
		actors.add(actor);
		movie.setActors(actors);
		return movie;
		
	}
	

}
