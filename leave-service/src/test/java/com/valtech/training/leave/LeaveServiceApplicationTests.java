package com.valtech.training.leave;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.valtech.training.leave.vos.LeaveMasterVO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LeaveServiceApplicationTests {

	@LocalServerPort
	private Integer port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void createLeaveMasterTest() {
		String baseUrl = "http://localhost:"+port+"/api/v1/leaveMasters/";
		List leaveMasters = restTemplate.getForObject(baseUrl, List.class);
		if(leaveMasters.size() == 0) {
			restTemplate.postForObject(baseUrl,
					new LeaveMasterVO(0,5,5,5,7), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl,
					new LeaveMasterVO(0,4,4,4,8), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl,
					new LeaveMasterVO(0,3,5,4,6), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl,
					new LeaveMasterVO(0,5,4,5,9), LeaveMasterVO.class);
			restTemplate.postForObject(baseUrl,
					new LeaveMasterVO(0,4,3,5,10), LeaveMasterVO.class);
		}
	}

}
