package com.example.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.ActivateUserDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Aidon on 19/7/28.
 */
public class ParaDataTest {
    public static void main(String[] args) {
        ActivateUserDTO dto=new ActivateUserDTO();
        dto.setCard_id("pbLatjnrwUUdZI641gKdTMJzHGfc");
        Map<String,Object> m=new HashMap<>();
        m.put("name","name");
        m.put("url","https://www.qq.com");
        Map<String,Object> required=new HashMap<>();
        List ls=new ArrayList();
        Map<String,Object> richFieldList=new HashMap<>();
        richFieldList.put("type","FORM_FIELD_CHECK_BOX");
        richFieldList.put("name","职业");
        String[] s={"赛车手","旅行家"};
        richFieldList.put("values",s);
        ls.add(richFieldList);
        required.put("can_modify","false");
        required.put("rich_field_list",ls);
        dto.setService_statement(m);
        dto.setRequired_form(required);
        System.out.println(JSONObject.toJSONString(dto));
    }
}
