package com.example.repository;

import com.example.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: ld
 * @Date: 2018/10/25 13:39
 * @Description:
 */
@Mapper
public interface StudentMapper {
    List<Student> getStudents(String sid);
}
