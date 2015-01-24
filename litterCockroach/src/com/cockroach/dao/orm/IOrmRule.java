package com.cockroach.dao.orm;

public interface IOrmRule 
{
	/**
	 * 类名称转换为表名称
	 * @param className 类名称
	 * @return 表名
	 */
	String classToTableName(String className);
	
	/**
	 * 表名称转换为类名称
	 * @param tableName 表名称
	 * @return 类名称
	 */
	String tableToClassName(String tableName);
	
	/**
	 * 类属性名称转换为数据库表列名称
	 * @param fieldName 属性名称
	 * @return	数据库列名
	 */
	String javaFieldToDbColumn(String fieldName);
	
	/**
	 * 数据库表列名称转换为类属性名称
	 * @param columnName	数据库列名称
	 * @return	对象属性名称
	 */
	String dbColumnToJavaField(String columnName);
	
}
