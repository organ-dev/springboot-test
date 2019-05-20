package com.example.repository;

import com.example.domain.Girl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * Created by Aidon on 17/7/9.
 */
@CacheConfig(cacheNames = "girls")
public interface GirlRepository extends JpaRepository<Girl, Integer> {

	public List<Girl> findByAge(Integer age);


}
