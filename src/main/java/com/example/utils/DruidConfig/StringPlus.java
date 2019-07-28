package com.example.utils.DruidConfig;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aidon on 19/7/28.
 */
public class StringPlus {
    /**
     * 金额去后面0
     * Author：William（徐威）
     * Create Time：2018-07-25
     *
     * @param money
     * @return
     */
    public static BigDecimal removeAmtLastZero(BigDecimal money) {
        String strMoney = money.toString();
        if (strMoney.indexOf('.') != -1) {
            String[] arr = strMoney.split("\\.");
            String strDecimals = arr[1];
            List<String> list = new ArrayList<String>();
            boolean isCanAdd = false;
            for (int i = strDecimals.length() - 1; i > -1; i--) {
                String ss = String.valueOf(strDecimals.charAt(i));
                if (!ss.equals("0")) {
                    isCanAdd = true;//从最后的字符开始算起，遇到第一个不是0的字符开始都是需要保留的字符
                }
                if (!ss.equals("0") || isCanAdd) {
                    list.add(ss);
                }
            }
            StringBuffer strZero = new StringBuffer();
            for (int i = list.size() - 1; i > -1; i--) {
                strZero.append(list.get(i));
            }
            strMoney = String.format("%s.%s", arr[0], strZero.toString());
        }

        return new BigDecimal(strMoney);
    }

}
