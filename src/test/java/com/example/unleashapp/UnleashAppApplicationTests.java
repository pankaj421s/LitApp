package com.example.unleashapp;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.example.unleashapp.controllers.MyController;
import com.example.unleashapp.services.UnleashService;

@SpringBootTest
class UnleashAppApplicationTests {
	@InjectMocks
	private MyController myController;
	@Mock
	private UnleashService unleashService;
	private MockMvc mockMVC;
	

	@Test
	void contextLoads() {
		System.out.println(myController.getUnleashService());
		
	}

}
