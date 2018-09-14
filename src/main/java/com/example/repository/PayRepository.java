package com.example.repository;

import com.example.domain.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: ld
 * @Date: 2018/9/14 14:48
 * @Description:
 */
public interface PayRepository extends JpaRepository<Pay,Integer> {
}
