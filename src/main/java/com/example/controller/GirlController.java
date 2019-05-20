package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.Girl;
import com.example.domain.Result;
import com.example.repository.GirlRepository;
import com.example.service.GirlService;
import com.example.utils.ResultUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Aidon on 17/7/9.
 */
@RestController
public class GirlController {
	@Autowired
	private GirlRepository girlRepository;
	@Autowired
	private GirlService girlService;
	private static final Logger logger = LoggerFactory.getLogger(GirlController.class);

	//获取列表
	@GetMapping(value = "/girls")
	public List<Girl> girlList() {

		return girlRepository.findAll();
	}

	//添加
	@PostMapping(value = "/addGirl")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
		girl.setCupSize(girl.getCupSize());
		girl.setAge(girl.getAge());
		return ResultUtil.success(girlRepository.save(girl));
	}

	@GetMapping(value = "/girl/{id}")
	public Girl girlFindOne(@PathVariable("id") Integer id) {
		logger.info("日志：{}", JSONObject.toJSONString(id));
		return girlRepository.findOne(id);

	}

	@PutMapping(value = "/girls/{id}")
	public void girlUpdate() {
		//测试更新git
	}

	@DeleteMapping(value = "/girls/{id}")
	public void girlDel(@PathVariable("id") Integer id) {
		girlRepository.delete(id);
	}

	@GetMapping(value = "/girls/age/{id}")
	public void girlListByAge(@PathVariable("id") Integer id) throws Exception {
		girlService.getAge(id);
	}

	//添加
	@PostMapping(value = "/findByAges")
	public List<Girl> findByAges(@RequestParam("ages") Integer ages) {
		System.out.println(ages);
		List<Girl> ls = girlRepository.findByAge(ages);
		System.out.println(ls);
		List<Girl> la = girlRepository.findByAge(ages);
		System.out.println(la);
		return la;
	}
}
