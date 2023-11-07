package com.example.unleashapp.controllers;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.unleashapp.models.LitRequest;
import com.example.unleashapp.models.Movie;
import com.example.unleashapp.services.LitService;
import com.example.unleashapp.services.UnleashService;

import io.getunleash.UnleashContext;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

@RestController
public class MyController {
	//@Autowired
	private UnleashService unleashService;
	@Autowired
	private LitService litService;
	@PostMapping("/lit")
	public void getLit(@RequestBody LitRequest request) throws IOException
	{
		litService.getPage(request.getUrl(), request.getTitle(),request.getNum());
	}
	@GetMapping("/hello")
	public String sayHello(HttpServletRequest request) throws Exception
	{
		//System.out.println(unleashService.getUnleash().isEnabled("my_toggle"));
		Movie movie=new Movie();
		movie.setName("Shakti");
		movie.setYear("1983");
		Field[] fields= Movie.class.getDeclaredFields();
		//String[] fieldList=new String[4];
		List<Field> fieldList=new ArrayList<>();
		fieldList=Arrays.stream(fields).filter(s->{
			s.setAccessible(true);
			try {
				System.out.println(s.getName());
				return s.get(movie)!=null;
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}).collect(Collectors.toList());
		List<Integer> myList=new ArrayList<>();
		myList.add(100);
		myList.add(20);
		System.out.println(myList.contains(100));
		System.out.println(request.getParameter("author"));
		//return UUID.randomUUID().toString();
	//return fieldList.size();
		String rs="RamSita";
		String[] rs2=rs.split("-");
		System.out.println(rs2.length);
		//litService.getPage();
		if(true)
		{
		throw new Exception("hello");
		}
		return RequestMethod.GET.toString();
		
	}
	@GetMapping("/is_enabled")
	public boolean isEnabled()
	{
		UnleashContext context=UnleashContext.builder().environment("development").addProperty("appBrand", "BOS").build(); 
		return unleashService.getUnleash().isEnabled("my_toggle",context);
	}
	public UnleashService getUnleashService() {
		return unleashService;
	}
	public void setUnleashService(UnleashService unleashService) {
		this.unleashService = unleashService;
	}
	@GetMapping("getmovie")
	public Movie getMovie()
	{
		return unleashService.getMovie();
	}
	

}
