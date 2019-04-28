package com.example.utils.seq;

import com.example.SpringbootApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: ld
 * @Date: 2019/4/28 13:47
 * @Param ${tags}
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringbootApplication.class)
@AutoConfigureMockMvc
public class BusinessSeqServiceTest {
//	@Autowired
//	BusinessSeqService businessSeqService;
//	@Test
//	public void getAggrMerCustNo() {
//		String str=businessSeqService.getAggrMerCustNo();
//		System.out.println(str);
//	}

	@Test
	public void getOrderId() {
	}

	@Test
	public void getPayId() {
	}
}