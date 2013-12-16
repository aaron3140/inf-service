package com.tisson.webservice.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Validator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tisson.webservice.rest.domain.ShortcutTraderRequert;
import com.tisson.webservice.rest.domain.UserDTO;

public class ShortcutTraderControllerTest {

	MockMvc mockMvc;

	@InjectMocks
	ShortcutTraderController controller;

	@Mock
	Validator validator;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		this.mockMvc = standaloneSetup(controller).setMessageConverters(
				new MappingJackson2HttpMessageConverter()).build();
	}

	@Test
	public void thatViewUses() throws Exception {
		this.mockMvc.perform(
				get("/shortcutTrader").content(standardOrderJSON())
				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
				.accept(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isOk());
	}

	public static String standardOrderJSON() {
		String jsonStr = null;
		ShortcutTraderRequert stReq = new ShortcutTraderRequert();
//		stReq.setCer(cer);
		stReq.setChannelCode("20");
		stReq.setCustCode("ycie");
//		stReq.setIp("127.0.0.1");
		stReq.setKeep("440106003094201312101912309043");
		stReq.setMerId("8613062000084223");
		stReq.setSign("");
		stReq.setStaffCode("test201391");
		stReq.setSvcCode("INF2013");
		stReq.setTmnNum("500012000001");
		
		List<UserDTO> users = new ArrayList<UserDTO>();
		UserDTO e10 = new UserDTO();
		e10.setEmail("shuangming.yang@gmail.com");
		e10.setLoginName("aaronMing");
		e10.setName("杨双明");
		UserDTO e1 = new UserDTO();
		 BeanUtils.copyProperties(e10, e1, UserDTO.class);
		 e1.setEmail("18665563140@163.com");
		
		users.add(e10);
		users.add(e1);
		stReq.setUsers(users);
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonStr = mapper.writeValueAsString(stReq);
			System.out.println(jsonStr);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStr;
	}

	public static void main(String[] args) {
		standardOrderJSON();
	}

	// try {
	// System.out.println(
	// mapper.generateJsonSchema(ShortcutTraderRequert.class));
	// } catch (JsonMappingException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

}
