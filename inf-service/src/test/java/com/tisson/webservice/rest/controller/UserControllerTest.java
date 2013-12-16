package com.tisson.webservice.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

public class UserControllerTest {

	MockMvc mockMvc;

	@InjectMocks
	UserController controller;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.mockMvc = standaloneSetup(controller).setMessageConverters(
				new MappingJackson2HttpMessageConverter()).build();
	}

	@Test
	public void thatViewUses() throws Exception {
		this.mockMvc.perform(
				get("/user/getUser?loginName=aaronMing").accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void thatCreateUses() throws Exception {
		this.mockMvc
				.perform(
						post("/user")
								 .content("{ \"loginName\":  42 }")
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isOk());
	}

}
