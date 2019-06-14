package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.Girl;
import com.example.domain.Result;
import com.example.repository.GirlRepository;
import com.example.service.GirlService;
import com.example.utils.ResultUtil;
import com.example.utils.seq.BusinessSeqService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	@Autowired
	BusinessSeqService businessSeqService;
	@PersistenceContext
	private EntityManager em;
	private static final Logger logger = LoggerFactory.getLogger(GirlController.class);
	private String str = "";
	private String finalTime = "";

	@PostConstruct
	private void init() {
//		Girl girl = girlRepository.findOne(1);
//		str = girl.getName();
	}

	//获取列表
	@GetMapping(value = "/girls")
	public List<Girl> girlList() {
		String payId = businessSeqService.getPayId();
		System.out.println(payId);
		System.out.println("test999");
		return girlRepository.findAll();
	}

	//添加
	@PostMapping(value = "/addGirl")
	public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
		}
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
	public Page<Girl> findByAges(@RequestParam("ages") Integer ages) {
		System.out.println(ages);
//		Pageable pageable = new PageRequest(0, 10);
		Girl girl = new Girl();
		// order by
		Sort sort = new Sort(Sort.Direction.DESC, "createDate");
		PageRequest pageRequest = new PageRequest(0, 10, sort);
		girl.setAge(18);
		girl.setName("a18");
		//设置查询条件
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withMatcher("age", ExampleMatcher.GenericPropertyMatchers.exact())
				.withMatcher("name", ExampleMatcher.GenericPropertyMatchers.exact());

		Example<Girl> example = Example.of(girl, matcher);
		Page<Girl> girls = girlRepository.findAll(example, pageRequest);
		return girls;
	}

	@PostMapping(value = "/updateGirlByIdAndAge")
	public Integer updateGirlByIdAndAge(@RequestParam("id") String id) {
		System.out.println("tetete");
		Integer num = girlRepository.updateGirlByIdAndAge(Integer.parseInt(id));
		System.out.println("tetete");
		return num;
	}

	@Transactional
	@PostMapping(value = "/updateAge")
	public void updateAge(@RequestParam("id") Integer id) {
		Girl girl = em.find(Girl.class, id);
		girl.setAge(20);
		try {
			em.merge(girl);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
