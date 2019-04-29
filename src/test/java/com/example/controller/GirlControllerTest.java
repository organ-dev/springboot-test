package com.example.controller;

import com.example.SpringbootApplication;
import com.example.domain.Girl;
import com.example.repository.GirlRepository;
import com.example.utils.seq.BusinessSeqService;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;


/**
 * Created by Aidon on 17/7/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
@AutoConfigureMockMvc
public class GirlControllerTest {
	@Autowired
	private MockMvc mvc;
	@Autowired
	GirlRepository girlRepository;

	@Autowired
	BusinessSeqService businessSeqService;

	@Test
	public void girlList() throws Exception {
		//get 可以根据情况替换，post，put
//        mvc.perform(MockMvcRequestBuilders.get("/girls")).
//                andExpect(MockMvcResultMatchers.status().isOk());
		List<Girl> ls = girlRepository.findAll();
		System.out.println(ls);
		String payId = businessSeqService.getPayId();
		String orderid = businessSeqService.getOrderId();
		System.out.println(payId);
		System.out.println(orderid);
	}

	@Test
	public void getGirls() {
		HttpClient httpClient = new DefaultHttpClient();
		//HttpPost httpPost = new HttpPost("http://localhost:8080/zgcssca/ssca_api/getQueryReserveOpenCustomerInfo");
		HttpPost httpPost = new HttpPost("http://localhost:8081/pay/getPayById?id=5");
//        StringEntity entity1 = new StringEntity(jsonStr, "UTF-8");
//        entity1.setContentType("application/json");
//        httpPost.setEntity(entity1);
		httpPost.setHeader("Content-Type", "application/json; charset=UTF-8");

		try {
			HttpResponse response = httpClient.execute(httpPost);
			byte[] contentInBytes = new byte[1024];
			int statusCode = response.getStatusLine().getStatusCode();
			response.getEntity().getContent().read(contentInBytes);
			String res = new String(contentInBytes, "UTF-8");
			System.out.println("statusCode:" + statusCode + ";content:" + res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}