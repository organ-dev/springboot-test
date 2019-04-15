package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.domain.BaseEvent;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Auther: ld
 * @Date: 2019/3/28 15:49
 * @Param ${tags}
 * @Description:
 */
@RestController
@RequestMapping(value = "xml")
class XmlMessageController {
    @RequestMapping(value = "/wx", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public String messageService(HttpServletRequest request) throws IOException {
        char[] buf = new char[1024];
        int length;
        StringBuilder builder = new StringBuilder();
        InputStreamReader inputStreamReader = new InputStreamReader(request.getInputStream(), "utf-8");
        while ((length = inputStreamReader.read(buf)) != -1) {
            builder.append(new String(buf, 0, length));
        }
        inputStreamReader.close();
        System.out.println(builder);
        XmlMapper xmlMapper = new XmlMapper();
        //忽略pojo中不存在的字段
        xmlMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, true);
        BaseEvent baseEvent = xmlMapper.readValue(builder.toString(), BaseEvent.class);

        System.out.println(baseEvent);

        return JSONObject.toJSONString(baseEvent);
    }
}

/*
例子：
http://localhost:8081/xml/wx
<note>
<ToUserName>George</ToUserName>
<FromUserName>John</FromUserName>
<Content>Reminder</Content>
<CreateTime>Don't forget the meeting!</CreateTime>
<MsgType>1!</MsgType>
<MsgId>aaa</MsgId>
</note>
*/

