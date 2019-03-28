package com.example.service.impl;

import com.google.code.shardbatis.strategy.ShardStrategy;

/**
 * @Auther: ld
 * @Date: 2019/1/14 11:12
 * @Param ${tags}
 * @Description:
 */
public class UserShardStrategyImpl implements ShardStrategy {
    private final static int tableCount = 5;

    /**
     * 得到实际表名
     *
     * @param baseTableName 逻辑表名,一般是没有前缀或者是后缀的表名
     * @param params        mybatis执行某个statement时使用的参数
     * @param mapperId      mybatis配置的statement id
     * @return
     */
    @Override
    public String getTargetTableName(String baseTableName, Object params, String mapperId) {
        // TODO: 需要根据实际的参数或其他（比如当前时间）计算出一个满足要求的值
        int value = 2;
        try {
            int index = value % tableCount + 1;
            String strIndex = "0" + index;
            return baseTableName + "_" + strIndex;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        UserShardStrategyImpl userShardStrategy=new UserShardStrategyImpl();
        String tableName=userShardStrategy.getTargetTableName("user","","");
        System.out.println(tableName);
    }
}