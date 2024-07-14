package com.example.rest_api;

import com.example.rest_api.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired //스프링에서 관리하는 빈들 중 -> 자동으로 생성되는 Object Mapper를 가져오겠다~
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		UserRequest user = new UserRequest("민주킴", 21, "test@test.com", true);
		System.out.println("user = " + user);
//		user.setUserName("민주킴");
//		user.setUserAge(21);
//		user.setEmail("test@test.com");
//		user.setIsKorean(true);

		//직렬화
		String json = objectMapper.writeValueAsString(user);
		System.out.println(json);

		//역직렬화
		/*UserRequest dto = objectMapper.readValue(json, UserRequest.class);
		System.out.println(dto);*/
	}

}
