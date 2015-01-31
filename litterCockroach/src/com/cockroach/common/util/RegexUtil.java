package com.cockroach.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class RegexUtil
{
	public static void main(String[] args)
	{
		String law = "江苏涟水农村商业银行总行业务库查库流程<>》";
		law = StringUtils.replaceEach(law, new String[]{"江苏涟水农村商业银行股份有限公司", "》", "<", ">"}, new String[]{"", "", "", ""});
		System.out.println(law);
		
	}
	public static List<String> splitStringCell(String value)
	{
		List<String> slices = new ArrayList<String>();
		Scanner sc = new Scanner(value);
		while (sc.hasNext())
		{
			String s = sc.next().trim();
			for (String str : StringUtils.split(s, " "))
			{
				slices.add(str);
			}
		}
		
		return slices;
	}
}
