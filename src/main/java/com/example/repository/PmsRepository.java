package com.example.repository;

import com.example.domain.Pay;
import com.example.domain.PmsResultVo;

import java.util.List;

/**
 * @Auther: ld
 * @Date: 2019/4/8 16:06
 * @Date: 2019/4/8 16:06
 * @Param ${tags}
 * @Description:
 */
public interface PmsRepository {
	PmsResultVo queryPayList(Pay pay);
}
