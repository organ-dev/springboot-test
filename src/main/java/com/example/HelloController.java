package com.example;

import com.example.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Aidon on 17/7/6.
 */
@RestController
public class HelloController {
    @Autowired
    private GirlService girlService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String say() {
        String a = "12123";
        return "String Boot";

    }

    @GetMapping(value = "girl/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }

}
