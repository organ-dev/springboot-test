package com.example.controller;

import com.example.domain.Girl;
import com.example.domain.Result;
import com.example.repository.GirlRepository;
import com.example.utils.ResultUtil;
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
        return girlRepository.findOne(id);

    }

    @PutMapping(value = "/girls/{id}")
    public void girlUpdate() {

    }

    @DeleteMapping(value = "/girls/{id}")
    public void girlDel(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping(value = "/girls/age")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }
}
