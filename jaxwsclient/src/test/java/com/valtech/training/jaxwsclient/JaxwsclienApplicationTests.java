package com.valtech.training.jaxwsclient;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.jaws.HelloWorld;
import com.valtech.training.jaws.webservices.Movie;
import com.valtech.training.jaws.webservices.MovieServiceWS;

@SpringBootTest
class JaxwsclienApplicationTests {

	@Autowired
	private MovieServiceWS movieServiceWS;
	
	@Autowired
	private HelloWorld helloWorld;
	
	@Test
	void contextLoads() {
		System.out.println(helloWorld.hello("Jax WS"));
		movieServiceWS.createMovie(new Movie("Sultan","Drama","Hindi",List.of("Salman Khan","Anushka Sharma")));
		movieServiceWS.createMovie(new Movie("Chak De!","Drama","Hindi",List.of("Shah Rukh Khan")));
		System.out.println(movieServiceWS.getAllMovies());
	}

}
