package com.example.demo;

import java.sql.Connection;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements ApplicationRunner {
	
	private static Logger log = LoggerFactory.getLogger(TestRunner.class);

	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate JdbcTemplate;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("Runner!");
//		try(Connection connection = dataSource.getConnection();) {
//			Statement statement = connection.createStatement();
//			String sql = "CREATE TABLE user(\r\n" + 
//					"	id VARCHAR(20) PRIMARY KEY,\r\n" + 
//					"	name VARCHAR(20) NOT NULL,\r\n" + 
//					"	location VARCHAR(14)\r\n" + 
//					"	birthday DATE,\r\n" + 
//					"\r\n" + 
//					");";
//			statement.executeUpdate(sql);
//		} catch (Exception e) {
//			
//		}
//		
		String sql2 = "INSERT INTO user (id, name, location, birthday) VALUES ('user1', 'TY', 'Seoul', '19920114')";
		JdbcTemplate.execute(sql2);
	}

}
