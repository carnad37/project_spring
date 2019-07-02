package com.test.mok;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;



@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml")
public class ContextConfigTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setup(){
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void test() throws Exception{
		 this.mockMvc.perform(get("/"))
		 .andExpect(status().isOk())
		 .andExpect(model().attributeExists("serverTime"));
	}
	
	@Test
	public void helloTest() throws Exception{
		mockMvc.perform(get("/hello").param("name", "spring"))
		.andExpect(status().isOk()) 
		.andExpect(view().name("hello")) 
		.andExpect(model().attributeExists("greeting"));
		 
	}
	
	
	/*
	  
	 view()=>hello
	  
	 
	 */
	

}
