package com.example.repository;

import com.example.domain.Pay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: ld
 * @Date: 2019/4/8 16:59
 * @Param ${tags}
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PmsRepositoryTest {
	@Autowired
	PmsRepository pmsRepository;

	@Test
	public void queryPayList() {
		Pay pay = new Pay();
		pmsRepository.queryPayList(pay);
	}
}