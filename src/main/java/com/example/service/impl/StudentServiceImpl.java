package com.example.service.impl;

import com.example.domain.Student;
import com.example.repository.StudentMapper;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: ld
 * @Date: 2018/10/25 13:52
 * @Description:
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getStudents(String sid) {
        return studentMapper.getStudents(sid);
    }
}
