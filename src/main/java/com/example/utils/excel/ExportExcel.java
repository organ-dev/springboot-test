package com.example.utils.excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: ld
 * @Date: 2020/1/14 15:55
 * @Param ${tags}
 * @Description: 导出excel
 */
public class ExportExcel {
	public static void main(String[] args) {
		String filePath = "d://测试.xlsx";
		List<List<Object>> data = new ArrayList<>();
		data.add(Arrays.asList("111", "222", "333"));
		data.add(Arrays.asList("111", "222", "333"));
		data.add(Arrays.asList("111", "222", "333"));
		List<String> head = Arrays.asList("日期","招商", "广发", "平安","合计");
		ExcelUtil.writeBySimple(filePath, data, head);

	}
}
