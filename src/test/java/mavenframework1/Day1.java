package mavenframework1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Day1 {
	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\eclipse-committers-photon-R-win32-x86_64\\eclipse\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
//Implicit Wait
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
//User name & Password
		WebElement user_name = driver.findElement(By.id("username"));
		user_name.sendKeys("saranyaraman");
		WebElement pass_word = driver.findElement(By.id("password"));
		pass_word.sendKeys("saranya");
//Login Btn Click
		driver.findElement(By.id("login")).click();
//Search Hotel Page
		WebElement location  = driver.findElement(By.id("location"));
		Select s = new Select(location);
		s.selectByIndex(1);
		
		WebElement hotels = driver.findElement(By.id("hotels"));
		Select s1 = new Select(hotels);
		s1.selectByValue("Hotel Creek");
		
		WebElement room_type = driver.findElement(By.id("room_type"));
		Select s2 = new Select(room_type);
		s2.selectByVisibleText("Deluxe");
		
		WebElement numberof_rooms = driver.findElement(By.id("room_nos"));
		Select x = new Select(numberof_rooms);
		x.selectByIndex(3);
		
		 WebElement check_in = driver.findElement(By.id("datepick_in"));
		check_in.clear();
		check_in.sendKeys("01/07/2021");
		
		WebElement check_out = driver.findElement(By.id("datepick_out"));
		check_out.clear();
		check_out.sendKeys("05/07/2021");
		
		WebElement rooms = driver.findElement(By.name("adult_room"));
		Select s3 = new Select(rooms);
		s3.selectByIndex(2);
		WebElement child_room = driver.findElement(By.name("child_room"));
		Select s4 = new Select(child_room);
		s4.selectByValue("3");
		driver.findElement(By.id("Submit")).click();
		WebElement select_hotel = driver.findElement(By.id("radiobutton_0"));
		select_hotel.click();
//click on continue
		driver.findElement(By.id("continue")).click();
		
/****Book A Hotel Page****/
		
//Fill First name 
		WebElement first_name = driver.findElement(By.id("first_name"));
		first_name.sendKeys("saranya");
//Fill Last name
		WebElement last_name = driver.findElement(By.id("last_name"));
		last_name.sendKeys("raman");
//Fill Address
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys("Test Chennai");
//Fill Credit Card Number
		WebElement credit_Card = driver.findElement(By.id("cc_num"));
		credit_Card.sendKeys("3256789545781245");
//Select Card Type
		WebElement credit_type = driver.findElement(By.id("cc_type"));
		Select s5 = new Select(credit_type);
		s5.selectByIndex(2);
//Select Expiry Month
		WebElement expiry_month = driver.findElement(By.id("cc_exp_month"));
		Select s6 = new Select(expiry_month);
		s6.selectByValue("2");
//Select Expiry Year
		WebElement expiry_year = driver.findElement(By.id("cc_exp_year"));
		Select s7 = new Select(expiry_year);
		s7.selectByValue("2022");
//Select Cvv Number
		WebElement cvv_no = driver.findElement(By.id("cc_cvv"));
		cvv_no.sendKeys("252");
//Hit Book Now
	 driver.findElement(By.id("book_now")).click();
//Get Order No
	 WebElement order_no = driver.findElement(By.id("order_no"));
	 String order_number = order_no.getAttribute("value");
	 System.out.println("Booking Confirmation Order no : "+order_number);
		
	}

}
