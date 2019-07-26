package com.example.repository;

import com.example.domain.Girl;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Aidon on 17/7/9.
 */
@CacheConfig(cacheNames = "girls")
@Transactional
public interface GirlRepository extends JpaRepository<Girl, Integer> {
//	@Query(value = "from Girl where age=?1 ", countQuery = "select count(*) from Girl where age=?1", nativeQuery = true)
	public List<Girl> findByAge(@Param("age") Integer age);

	@Modifying
	@Transactional
	@Query(value = "UPDATE Girl set age=age-1 where id=?1 and age>0")
	public Integer updateGirlByIdAndAge(@Param("id") Integer id);

}
