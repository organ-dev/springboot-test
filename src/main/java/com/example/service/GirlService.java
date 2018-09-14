package com.example.service;

import com.example.domain.Girl;
import com.example.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: ld
 * @Date: 2018/9/14 11:16
 * @Description:
 */
@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    public Girl getAge(Integer id) throws Exception {
        Girl gl = girlRepository.findOne(id);
        Integer age = gl.getAge();
        if (age < 10) {
//            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);

        } else if (age > 10 && age < 16) {
//            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        } else {
//            throw new GirlException(ResultEnum.SUCCESS);
        }
        return gl;
    }
}
