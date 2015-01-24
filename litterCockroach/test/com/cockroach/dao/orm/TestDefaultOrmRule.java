package com.cockroach.dao.orm;

import junit.framework.TestCase;

import org.junit.Test;

import com.cockroach.dao.orm.DefaultOrmRule;
import com.cockroach.dao.orm.IOrmRule;

public class TestDefaultOrmRule extends TestCase
{
	private IOrmRule rule = new DefaultOrmRule();
	
	@Test
	public void testClassToTableName()
	{
		
		String tableName = rule.classToTableName("SysUnit");
		System.out.println(tableName);
	}
	
	public void testTableToClassName()
	{
		String className = rule.tableToClassName("SYS_UNIT");
		System.out.println(className);
	}
	
	public void testJavaFieldToDbColumn()
	{
		String dbColumnName = rule.javaFieldToDbColumn("idNo");
		System.out.println(dbColumnName);
	}
	
	public void testDbColumnToJavaField()
	{
		String fieldName = rule.dbColumnToJavaField("ID_NO_");
		System.out.println(fieldName);
	}
	
}
