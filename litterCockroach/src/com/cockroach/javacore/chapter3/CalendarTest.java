package com.cockroach.javacore.chapter3;

import java.text.DateFormatSymbols;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

/**
 * 展示当前月日历
 * @author kk_cockroach
 *
 */
public class CalendarTest
{
	private static Calendar now = Calendar.getInstance();
	
	/**
	 * 获取当前月的第一天
	 * @return
	 */
	public Calendar getMinOfMonthCalendar(Calendar c)
	{
		if (c == null)
		{
			c = now;
		}
		Calendar min = (Calendar)c.clone();
		min.set(Calendar.DAY_OF_MONTH, min.getMinimum(Calendar.DAY_OF_MONTH));
		
		return min;
	}
	
	/**
	 * 获取当前月的最后一天
	 * @param c
	 * @return
	 */
	public Calendar getMaxOfMonthCalendar(Calendar c)
	{
		if (c == null)
		{
			c = now;
		}
		Calendar max = (Calendar)c.clone();
		max.add(Calendar.MONTH, 1);
		max.set(Calendar.DAY_OF_MONTH, 1);
		max.add(Calendar.DAY_OF_MONTH, -1);
		return max;
	}
	
	@Test
	public void testPrintCalendar()
	{
		System.out.println("当前年度：" + now.get(Calendar.YEAR));
		System.out.println("====================================================");
		
		/*很骚的一种方法:通过Locale的不同获取的名称也会不一样*/
		String[] weekDayNames = new DateFormatSymbols().getShortWeekdays();
		for (String dayName : weekDayNames)
		{
			if (StringUtils.isEmpty(dayName))
			{
				continue;
			}
			System.out.print(dayName + "\t");
		}
		System.out.println();
		
		Calendar first = getMinOfMonthCalendar(now);
		int firstOfWeekday = first.get(Calendar.DAY_OF_WEEK);
		for (int i = 1; i < firstOfWeekday - 1; i ++)
		{
			System.out.print("\t");
		}
		
		Calendar c = (Calendar)first.clone();
		while (c.get(Calendar.MONTH) == now.get(Calendar.MONTH))
		{
			int day = c.get(Calendar.DAY_OF_MONTH);
			//System.out.print(day);
			if (c.compareTo(now) == 0)
			{
				System.out.printf("%3s*\t", day);
			}
			else
			{
				System.out.printf("%3s\t", day);
			}
			
			if (day % 7 == 0)
			{
				System.out.println();
			}
			c.add(Calendar.DAY_OF_MONTH, 1);
			
		}
		
	}

}
