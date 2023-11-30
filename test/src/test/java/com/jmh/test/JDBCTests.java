package com.jmh.test;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Oracle19 버전인 경우 => "jdbc:oracle:thin:@localhost:1521:orcl"
    // Oracle11 버전인 경우 => "jdbc:oracle:thin:@localhost:1521:XE"
	
	@Test
	public void testConnection() {
		
		try(Connection con = 
				DriverManager.getConnection(
                
						"jdbc:oracle:thin:@localhost:1521:orcl",
						"practice",
						"1234")){
			System.out.println(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}
}
