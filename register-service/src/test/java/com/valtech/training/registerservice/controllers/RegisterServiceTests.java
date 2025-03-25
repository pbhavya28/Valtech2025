package com.valtech.training.registerservice.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterServiceTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetUserByValidId() throws Exception {
		mockMvc.perform(get("/api/v1/users/2")).andDo(print()).andExpect(content().json("{'id': 2,'name': 'Indrajeet','age': 22,'mobile': '98989989','email': 'jckckas@in.com','subscriptionId': 1,'isKidAccount': false}"))
		.andExpectAll(status().isOk());
	}
	@Test
	public void testGetUserByInvalidId() throws Exception {
		mockMvc.perform(get("/api/v1/users/900")).andDo(print()).andExpect(status().isNotFound());
		
	}
	
}
