package com.example.utils.watchUtil;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: ld
 * @Date: 2019/7/26 10:57
 * @Param ${tags}
 * @Description:
 */
public class DateDeserializer extends JsonDeserializer<Date> {
	@Override
	public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String date = p.getText();
		if (date.length() == 14) {
			SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			try {
				return dataFormat.parse(date);
			} catch (ParseException e) {
				throw new IOException(e);
			}
		} else {
			long time = Long.valueOf(date) * 1000;
			return new Date(time);
		}
	}
}
