package de.epam.application.train.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import de.epam.application.train.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class TrainControllerTest {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	private MockMvc service;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() {
		this.service = webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testInit() throws Exception {
		service.perform(get("/init")).andExpect(status().isNoContent());
	}

	@Test
	public void testGetTrains() throws Exception {
		service.perform(get("/init"));
		service.perform(get("/train"))//
				.andExpect(status().isOk())//
				.andExpect(content().contentType(contentType)) //
				.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2))) //
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].trainNumber", Matchers.is("278"))) //
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].trainNumber", Matchers.is("938")));

	}
}
