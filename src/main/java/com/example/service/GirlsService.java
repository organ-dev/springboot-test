package com.example.service;

import com.example.domain.Girl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ld
 * @Date: 2019/6/18 11:11
 * @Param ${tags}
 * @Description:
 */
@Component
@Service

public interface GirlsService {
	public List<Girl> findByAge(Integer age);

	public void addGirl(Girl girl);
}
