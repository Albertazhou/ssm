package com.cetc.weiwen.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QRCodeControllerTest {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		//构造一个伪造的mvc运行环境
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	
	/**测试get请求
	 * 
	 * @throws Exception
	 */
	@Test
	public void whenQuerySuccess() throws Exception {
		String result = mockMvc.perform(
				//使用对象接收多个参数在get请求中
				get("/user").param("username", "jojo").param("age", "18").param("ageTo", "60").param("xxx", "yyy")
						// .param("size", "15")
						// .param("page", "3")
						// .param("sort", "age,desc")
						.contentType(MediaType.APPLICATION_JSON_UTF8))
				//在github中查找jsonPath的使用-->$.length()
				.andExpect(status().isOk()).andExpect(jsonPath("$.length()").value(3))
				.andReturn().getResponse().getContentAsString();
		
		System.out.println(result);
	}
	
	/**
	 * 测试post请求
	 * @throws Exception
	 */
	@Test
	public void whenCreateFail() throws Exception {
		
		Date date = new Date();
		System.out.println(date.getTime());
		String content = "{\"phone\":\"13207495121\",\"password\":123456"+"}";
		String reuslt = mockMvc.perform(post("/weiwen-api/user/login").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content))
				.andReturn().getResponse().getContentAsString();
		System.out.println(reuslt);
	}
	/**
	 * 测试put请求
	 * @throws Exception
	 */
	@Test
	public void whenUpdateSuccess() throws Exception {
		
		Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
		System.out.println(date.getTime());
		String content = "{\"id\":\"1\", \"username\":\"tom\",\"password\":null,\"birthday\":"+date.getTime()+"}";
		String reuslt = mockMvc.perform(put("/user/1").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(content))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value("1"))
				.andReturn().getResponse().getContentAsString();
		
		System.out.println(reuslt);
	}
	/**测试delete请求
	 * 
	 * @throws Exception
	 */
	@Test
	public void whenDeleteSuccess() throws Exception {
		mockMvc.perform(delete("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
	}

}