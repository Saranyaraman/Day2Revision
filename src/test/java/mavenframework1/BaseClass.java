package mavenframework1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	
	static WebDriver driver;
public	static Actions a;
public static Alert al;
public static Select s; 
public static Workbook book;
public static File f; 

	
//ChromeBrowser Launch
	public static void chromeBrowser() {
		System.setProperty("webdriver.chrome.driver","F:\\eclipse-committers-photon-R-win32-x86_64\\eclipse\\Selenium\\Driver\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	
//Launching URL
	public static void urlLaunch(String url) {
		driver.get(url);
	}
//Get URL Title
	public void urlTitle() {
		driver.getTitle();

	}
//Browser Close
	public static void browserClose() {
		driver.close();
	}
//Browser Quit
	public void browserQuit() {
		 driver.quit();
	}
//Send value for Text Box
	public static void textBox(WebElement ref,String value) {
		ref.sendKeys(value);
	}
//doubleClick
	public void buttonClick(WebElement ref) {
		a = new Actions(driver);
	a.moveToElement(ref).perform();
	}
//button Click
	public static void btnclick(WebElement ref) {
		ref.click();
	}
//Radio Button
	public void buttonradio(WebElement ref) {
		ref.click();
	}
//Checkbox
	public void boxcheck(WebElement ref) {
		ref.click();
	}
//Checks whether a radio button is selected or not.
	public void butttonselected(WebElement ref) {
		ref.isSelected();
	}
//Checks whether a radio button is displayed on the web page or not.
	public void buttondisplay(WebElement ref) {
		ref.isDisplayed();
	}
//Checks whether a radio button is enabled or not
	public void buttonenabled(WebElement ref) {
		ref.isEnabled();
	}
// Find Element by Id
	
	public void elementID(String ref) {
		driver.findElement(By.id(ref));
	}
//Find Element by Name
	public void ElementName(String ref) {
		driver.findElement(By.name(ref));
	}
//Find Element by Xpath
	public void ElementPath(String ref) {
		driver.findElement(By.xpath(ref));
	}
//Find element by tagname
	public void nametag(String ref) {
		driver.findElement(By.tagName(ref));
	}
//Find Element by Partail link 
	public void linkpartial(String ref) {
		driver.findElement(By.partialLinkText(ref));
	}
//Simple Alert
	public void alertSimple(WebElement ref) {
		ref.click();
	}
//Confirmation Alert Ok
	public void AlertConfirmation(WebElement ref) {
		 al = driver.switchTo().alert();
		 al.accept();
	}
//Confimration alert Cancel
	public void alertCancel(WebElement ref) {
		al = driver.switchTo().alert();
		 al.dismiss();
	}
/****Drop-down Actions****/
	public static void dropDown(WebElement ref,int index) {
		s = new Select(ref);
		s.selectByIndex(index);

	}
public static void dropDownvalue(WebElement ref,String value) {
	s = new Select(ref);
	s.selectByValue(value);
}
public static void dropDownVisible(WebElement ref, String text) {
s= new Select(ref);
s.selectByVisibleText(text);

}

//File handling read a file 
	public static String fileinput(int rownum,int cellnum) throws IOException {
		File f = new File("F:\\eclipse-committers-photon-R-win32-x86_64\\eclipse\\mavenframework1\\Excelworkbook\\Workbook.xlsx");
		FileInputStream	fin = new FileInputStream(f);
		//Get the Workbook
		         book = new XSSFWorkbook(fin);
		//Get the Sheet
		       Sheet sh = book.getSheet("Sheet1");
	//fetch a row
		      Row r = sh.getRow(rownum);
	//fetch a cell
		       Cell  c = r.getCell(cellnum);
	int type = c.getCellType();
	String name ="";
	if (type==1) {
		name =c.getStringCellValue();
	}
	else if (DateUtil.isCellDateFormatted(c)) {
		Date date = c.getDateCellValue();
		SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
		name = form.format(date);
	}
	else {
		double d = c.getNumericCellValue();
		long lo =(long)d;
		name= String.valueOf(lo);
	}
	return name;
	}
	
/**** File Handling Write into file 
 * @return 
 * @return 
 * @throws IOException *****/
public static String fileWrite(int rownum,int column,String value) throws IOException {
		File f = new File("F:\\eclipse-committers-photon-R-win32-x86_64\\eclipse\\mavenframework1\\Excelworkbook\\Workbook.xlsx");
		 FileInputStream fin = new FileInputStream(f);
		//Get the Workbook
		         book = new XSSFWorkbook(fin);
		//Get the Sheet
		         Sheet sh = book.getSheet("Sheet1");
		//Create a Row
		       Row  r = sh.createRow(rownum);
		//Create a cell
		        Cell c = r.createCell(column);
		//Set a value to the created cell 
		        c.setCellValue(value);
		     int type = c.getCellType();
		   //  FileOutputStream of = new FileOutputStream(f);
		    //	book.write(of);
		    	String name ="";
		    	if (type==1) {
		    		name =c.getStringCellValue();
		    		FileOutputStream of = new FileOutputStream(f);
			    	book.write(of);
		    	}
		    	else if (DateUtil.isCellDateFormatted(c)) {
		    		Date date = c.getDateCellValue();
		    		SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
		    		name = form.format(date);
		    		FileOutputStream of = new FileOutputStream(f);
			    	book.write(of);
		    	}
		    	else {
		    		double d = c.getNumericCellValue();
		    		long lo =(long)d;
		    		name= String.valueOf(lo);
		    		FileOutputStream of = new FileOutputStream(f);
			    	book.write(of);
		    	}
		    	return name;
		    	
		    	}
		        
	
//File Write
public static void fileUpdate1() throws IOException {
	File f = new File("F:\\eclipse-committers-photon-R-win32-x86_64\\eclipse\\mavenframework1\\Excelworkbook\\Workbook.xlsx");
	FileInputStream fin = new FileInputStream(f);
	book = new XSSFWorkbook(fin);
	Sheet sh = book.getSheet("Sheet1");
	FileOutputStream of = new FileOutputStream(f);
	book.write(of);
	System.out.println("done");
}

}
		
	
		
	

	

