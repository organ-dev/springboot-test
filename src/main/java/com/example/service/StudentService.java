package com.example.service;

import com.example.domain.Student;

import java.util.List;

/**
 * @Auther: ld
 * @Date: 2018/10/25 13:51
 * @Description:
 */

public interface StudentService {
    List<Student> getStudents(String sid);
}
