package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatabaseUtility {
	
	static String host = "127.0.0.1";   // localhost2
	static String port = "3306";
	static String username = "root";
	static String password = "root";
	
	public static Object[][] getDatabaseData(String tableName) throws SQLException{
		// Connection URL - "jdbc:mysql://"+host+":"+port+"/databaseName"
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		                 //class//
		Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/OrangeHRM_Database",username,password);
		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery("select * from "+tableName+";");
		//result-set will pointer to current row i.e. first index(0)
		
		rs.last(); // will move to last row
		int rowCount = rs.getRow();  // no. of rows
 	    ResultSetMetaData rsmd = rs.getMetaData();
 	    int colCount = rsmd.getColumnCount();   // no. of columns
 	    
 	    Object[][] data = new Object[rowCount][colCount]; 
 	    rs.beforeFirst(); // column headings row
 	    
 	    int i =0;
     	    // rs.next() is used to go next row otherwise it will select first row(0) which contains column names/headings //
	    while(rs.next()) {    // if condition is true then it will execute 
	    	for(int j=0;j<colCount;++j) {
	    		data[i][j]= rs.getObject(j+1).toString(); // data will get call and stored in Object Array data type and convert all data into string
	    	} 
	    	++i;	
	    }
		return data;
	}
}
