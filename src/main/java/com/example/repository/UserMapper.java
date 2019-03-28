package com.example.repository;

import com.example.domain.User;

/**
 * @Auther: ld
 * @Date: 2019/1/14 11:01
 * @Param ${tags}
 * @Description:
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(User record);
    int insertSelective(User record);
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);

}
