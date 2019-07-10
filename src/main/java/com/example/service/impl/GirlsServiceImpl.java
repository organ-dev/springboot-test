package com.example.service.impl;

import com.example.domain.Girl;
import com.example.repository.GirlRepository;
import com.example.service.GirlsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: ld
 * @Date: 2019/6/18 17:11
 * @Param ${tags}
 * @Description:
 */
@Component
@Transactional(propagation = Propagation.REQUIRED)
//@com.alibaba.dubbo.config.annotation.Service(interfaceClass = GirlsService.class)
public class GirlsServiceImpl implements GirlsService {
	@Autowired
	private GirlRepository girlRepository;

	@Override
	public List<Girl> findByAge(Integer age) {
		return null;
	}


	@Override
	public void addGirl(Girl girl) {
		girlRepository.save(girl);
		throw new RuntimeException("test");
	}
}
