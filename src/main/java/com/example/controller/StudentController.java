package com.example.controller;

import com.example.domain.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: ld
 * @Date: 2018/10/25 13:54
 * @Description:
 */
@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/getStudent")
    @ResponseBody
    public List<Student> getStudent(@RequestParam String id) {
        List<Student> students = studentService.getStudents(id);
        return students;
    }
}
