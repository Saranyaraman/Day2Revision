package mavenframework1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class fileHandling extends BaseClass{
	public static void main(String[] args) throws IOException, InterruptedException {
		chromeBrowser();
		urlLaunch("https://adactinhotelapp.com/");
		driver.manage().window().maximize();

		WebElement user_name = driver.findElement(By.id("username"));
		textBox(user_name, fileinput(1, 0));
		
		WebElement pass_word = driver.findElement(By.id("password"));
		textBox(pass_word, fileinput(1, 1));

// Login Btn Click
		WebElement login_btn = driver.findElement(By.id("login"));
		btnclick(login_btn);

// Search Hotel Page
		WebElement location = driver.findElement(By.id("location"));
		dropDown(location, 1);

		WebElement hotels = driver.findElement(By.id("hotels"));
		dropDownvalue(hotels, "Hotel Creek");

		WebElement room_type = driver.findElement(By.id("room_type"));
		dropDown(room_type, 0);

		WebElement numberof_rooms = driver.findElement(By.id("room_nos"));
		dropDown(numberof_rooms, 2);

		WebElement check_in = driver.findElement(By.id("datepick_in"));
		check_in.clear();
		check_in.sendKeys("01/07/2021");

		WebElement check_out = driver.findElement(By.id("datepick_out"));
		check_out.clear();
		check_out.sendKeys("05/07/2021");

		WebElement rooms = driver.findElement(By.name("adult_room"));
		dropDown(rooms, 2);

		WebElement child_room = driver.findElement(By.name("child_room"));
		dropDownvalue(child_room, "3");

		WebElement btn = driver.findElement(By.id("Submit"));
		btnclick(btn);

		WebElement select_hotel = driver.findElement(By.id("radiobutton_1"));
		btnclick(select_hotel);
		
// click on continue
		WebElement continue_click = driver.findElement(By.id("continue"));
		btnclick(continue_click);

/**** Book A Hotel Page ****/

// Fill First name
		WebElement first_name = driver.findElement(By.id("first_name"));
		textBox(first_name, fileinput(1, 2));
		
// Fill Last name
		WebElement last_name = driver.findElement(By.id("last_name"));
		textBox(last_name, fileinput(1, 3));
		
// Fill Address
		WebElement address = driver.findElement(By.id("address"));
		textBox(address, fileinput(1, 4));
		
// Fill Credit Card Number
		WebElement credit_Card = driver.findElement(By.id("cc_num"));
		textBox(credit_Card, fileinput(1, 5));
		
// Select Card Type
		WebElement credit_type = driver.findElement(By.id("cc_type"));
		dropDown(credit_type, 2);

// Select Expiry Month
		WebElement expiry_month = driver.findElement(By.id("cc_exp_month"));
		dropDownvalue(expiry_month, "2");
		
// Select Expiry Year
		WebElement expiry_year = driver.findElement(By.id("cc_exp_year"));
		dropDownvalue(expiry_year, "2022");

// Select Cvv Number
		WebElement cvv_no = driver.findElement(By.id("cc_cvv"));
		textBox(cvv_no, fileinput(1, 6));

// Hit Book Now
		WebElement book_now = driver.findElement(By.id("book_now"));
		btnclick(book_now);
		
// Order_no Confirmation
		Thread.sleep(5000);
		WebElement order_no = driver.findElement(By.id("order_no"));
		String order_number = order_no.getAttribute("value");
		System.out.println(order_number);
		
//Create Order Number text row in Excel file 
		Thread.sleep(5000);
		
/*fileWrite(0, 7, "Order Number");
fileWrite(1, 7, order_number);
//fileUpdate1();*/
		
File f = new File("F:\\eclipse-committers-photon-R-win32-x86_64\\eclipse\\mavenframework1\\Excelworkbook\\Workbook.xlsx");
//R/W file 
FileInputStream fin = new FileInputStream(f);

//Get the Workbook
Workbook book = new XSSFWorkbook(fin);

//Get the Sheet
Sheet sh = book.getSheet("Sheet1");

//fetch a row
Row r = sh.createRow(0);
//create a cell
Cell c = r.createCell(7);
//set a value for the cell
c.setCellValue("Order Number");	
Row r1 = sh.getRow(1);
Cell c1 = r1.createCell(7);
c1.setCellValue(order_number);
/*Row r2 =sh.createRow(0);
Cell c2 = r1.createCell(8);
c2.setCellValue("test");
Row r3 =sh.createRow(1);
Cell c3 = r1.createCell(8);
c3.setCellValue("123");*/

//File write
		FileOutputStream of = new FileOutputStream(f);
		book.write(of);
		System.out.println(order_number);

	
		}
	}

