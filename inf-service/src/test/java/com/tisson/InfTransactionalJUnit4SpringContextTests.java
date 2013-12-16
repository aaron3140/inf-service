package com.tisson;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ActiveProfiles("test")
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class InfTransactionalJUnit4SpringContextTests extends
		AbstractTransactionalJUnit4SpringContextTests {

	protected DataSource dataSource;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
		this.dataSource = dataSource;
	}
}
