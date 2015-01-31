package com.cockroach.dao.orm;

import org.apache.commons.lang3.StringUtils;

public class DefaultOrmRule implements IOrmRule 
{
	
	@Override
	public String classToTableName(String className) 
	{
		/*SysUnit -> SYS_UNIT*/
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < className.length(); i ++)
		{
			char c = className.charAt(i);
			if (i == 0)
			{
				builder.append(c);
			}
			else
			{
				if (Character.isUpperCase(c))
				{
					builder.append("_").append(c);
				}
				else
				{
					builder.append(c);
				}
			}
		}
		return builder.toString().toUpperCase();
	}

	@Override
	public String tableToClassName(String tableName) 
	{
		/*SYS_UNIT -> SysUnit*/
		StringBuilder builder = new StringBuilder();
		String[] strings = StringUtils.split(tableName.toLowerCase(), "_");
		
		for (int i = 0; i < strings.length; i++)
		{
			builder.append(changeFirstCharacterUpper(strings[i]));
		}
		return builder.toString();
	}

	@Override
	public String javaFieldToDbColumn(String fieldName) 
	{
		/*idNo->ID_NO_*/
		StringBuilder builder = new StringBuilder();
		for (char c : fieldName.toCharArray())
		{
			if (Character.isUpperCase(c))
			{
				builder.append("_" + c);
			}
			else
			{
				builder.append(c);
			}
		}
		builder.append("_");
		return builder.toString().toUpperCase();
	}

	@Override
	public String dbColumnToJavaField(String columnName) 
	{
		/*ID_NO_ -> idNo */
		StringBuilder builder = new StringBuilder();
		String[] strings = StringUtils.split(columnName.toLowerCase(), "_");
		for (String s : strings)
		{
			builder.append(changeFirstCharacterUpper(s));
		}
		return builder.toString();
	}

	/**
	 * 将字符串首字符大写
	 * @param s
	 * @return
	 */
	private String changeFirstCharacterUpper(String s)
	{
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}
}
