package dbtesting1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;

import com.mysql.cj.conf.ConnectionPropertiesTransform;

public class mytest {
	
	//WebDriver driver = new ChromeDriver();
	
	Random rand = new Random();
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	int randomnumber = rand.nextInt(500);
	
	@BeforeTest
	public void mysetup() throws SQLException {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","Khaddashlove@1");
	
	}
	
	@Test(priority = 1 , invocationCount = 50)
	public void AddData () throws SQLException {
		 randomnumber = rand.nextInt(500);
		 
		System.out.println(randomnumber);
		String query = "insert into customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit)VALUES ( "+randomnumber+", 'Sunrise Ventures', 'Anderson', 'Michael', '212-555-1234', '123 Main Street', 'Suite 200', 'New York', 'NY', '10001', 'USA', 1621, 50000.00)";
		stmt =con.createStatement();
		int rowinserted = stmt.executeUpdate(query);
		System.out.println(rowinserted);
		
	}
	 @Test(priority = 2)
	 public void updateData() throws SQLException {
		 String query = "update customers set contactFirstName = 'mothafer'where customerNumber ="+randomnumber;
		 stmt =con.createStatement();
		 int numberrowUpdat= stmt.executeUpdate(query);
		 System.out.println(numberrowUpdat);
	 }
	 
	 @Test(priority = 3)
	 public void GetData() throws SQLException {
		 stmt=con.createStatement();
		 rs = stmt.executeQuery("select *from customers where customerNumber ="+randomnumber);
		 while (rs.next()) {
			 
			 String firstname = rs.getString("contactFirstName");
			 String lastName = rs.getString("contactLastName");
			 
//			 driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
//			 
//			 WebElement fiestnameInput = driver.findElement(By.id("firstname"));
//			 WebElement lastnameInout = driver.findElement(By.id("lastname"));
//			 fiestnameInput.sendKeys(firstname);
//			 lastnameInout.sendKeys(lastName);
//			 
			 
			 
		 }
		 
		 
		 
	 }
	@Test(priority = 4 ,enabled = false)
	public void deleteData() throws SQLException {
		String query ="delete from customers where customerNumber =501";
		stmt=con.createStatement();
		
		
		
	}
	
	
	
	
	

	}