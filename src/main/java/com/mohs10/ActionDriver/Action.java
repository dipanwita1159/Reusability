package com.mohs10.ActionDriver;


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.MediaEntityBuilder;

import com.mohs10.base.StartBrowser;

public class Action extends com.mohs10.base.StartBrowser{
public static WebDriver driver;
 WebElement ele;
 WebElement element;
 WebElement e;
 //public Action aDriver=new Action();



public void validateNumber(By locator,String mobNumber)   
{  
//validates phone numbers having 10 digits (9998887776)  
	
if (mobNumber.matches("\\d{10}"))  {
ele=driver.findElement(locator);
ele.sendKeys(mobNumber);}

//validates phone numbers having digits, -, . or spaces  

else if (mobNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))  
{	ele=driver.findElement(locator);
	ele.sendKeys(mobNumber);
	}
else if (mobNumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))  
{	ele=driver.findElement(locator);
ele.sendKeys(mobNumber);}
//validates phone numbers having digits and extension (length 3 to 5)  
else if (mobNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))  
{	ele=driver.findElement(locator);
ele.sendKeys(mobNumber);}
//validates phone numbers having digits and area code in braces  
else if (mobNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))  
{	ele=driver.findElement(locator);
ele.sendKeys(mobNumber);}
else if (mobNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))  
{	ele=driver.findElement(locator);
ele.sendKeys(mobNumber);}
else if (mobNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))  
{	ele=driver.findElement(locator);
ele.sendKeys(mobNumber);} 
//return false if any of the input matches is not found  
else  
{	ele=driver.findElement(locator);
}  
}


public void zipcode(By locator, String zipCodeInput) {
	//input will be 6 digit zipcode only
	if (zipCodeInput.matches("\\d{6}")) {
		ele=driver.findElement(locator);
		ele.sendKeys(zipCodeInput);
		System.out.println(zipCodeInput +" is the Zip code");
		
	}
	else {
		System.out.println("No zipcode is inputed");
	}
	
}
public void Emailid(By locator,String emailid) {
	
	  ArrayList<String> emails = new ArrayList<String>();
	  emails.add(emailid);
	 
	
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";  
    //Compile regular expression to get the pattern  
    Pattern pattern = Pattern.compile(regex);
   // String pat=pattern.toString();//
    //Iterate emails array list  
	
	for (String email : emails) { // Create instance of matcher Matcher matcher
		Matcher matcher = pattern.matcher(email);
		
		System.out.println(email + " : " + matcher.matches());
		
		 if(matcher.matches()) {
			  
			  ele=driver.findElement(locator); 
			  ele.sendKeys(emailid);
			  
			  System.out.println(emailid +" is the valid email");
			  break;
			  
			  
			  } else 
			  { 
				  System.out.println(email+" not a valid email id");
				  }
	  
	  }
	

	 
	 
}

//Method to capture the message showing in the console window while entering the data

/*
 * public void Email2(By locator, By locator1, By locator2, String Email, String
 * classvalue) { ArrayList<String> emails = new ArrayList<String>();
 * emails.add(Email);
 * 
 * String regex = "^[A-Za-z0-9+_.-]+@(.+)$"; // Compile regular expression to
 * get the pattern Pattern pattern = Pattern.compile(regex); // String
 * pat=pattern.toString();//
 * 
 * // Iterate emails array list for (String email : emails) { // Create instance
 * of matcher Matcher matcher Matcher matcher = pattern.matcher(email);
 * 
 * System.out.println(email + " : " + matcher.matches()); ele =
 * driver.findElement(locator); ele.sendKeys(Email); // ele.click(); e =
 * driver.findElement(locator2); e.click(); element =
 * driver.findElement(locator1); String str = element.getAttribute("class");
 * 
 * if (matcher.matches() && str.contains(classvalue)) { System.out.println(Email
 * + " is the valid email"); Assert.assertTrue(false,
 * "test of accordian passed"); } else { System.out.println(Email +
 * " not a valid email id"); Assert.assertTrue(true,
 * "test of accordian failed"); System.out.println(str);
 * 
 * } } }
 */






public void password(By locator,String pwd) {
	 ArrayList<String> emails = new ArrayList<String>();
	  emails.add(pwd);
	  String regex = "^[A-Za-z0-9_@.%#*&!$]{7,17}$";  
	    //Compile regular expression to get the pattern  
	    Pattern pattern = Pattern.compile(regex);
	   // String pat=pattern.toString();//
	    //Iterate emails array list  
		
		for (String email : emails)
		{ // Create instance of matcher Matcher matcher
		Matcher matcher = pattern.matcher(email);
			
			System.out.println(email + " : " + matcher.matches());
			
			 if(matcher.matches()) {
				  
				  ele=driver.findElement(locator); 
				  ele.sendKeys(pwd);
				  System.out.println(pwd +" is the valid password");
				  break;
				  
				  
				  } else 
				  { 
					  System.out.println(email+" not a valid password");
					  }
		}
		
}
public void age(By locator,String age) {
	//input will be 6 digit age only
		if (age.matches("^([1-9]).{0,1}$")) {
			ele=driver.findElement(locator);
			ele.sendKeys(age);
			System.out.println(age +" is the age");
			
		}
		else {
			System.out.println("No age inputed");
		}}
		
	/*
	 * public void age1(By locator,int age) { //input will be 6 digit age only if
	 * (age>0&& age<100) { ele=driver.findElement(locator);
	 * 
	 * ele.sendKeys(age); System.out.println(age +" is the age");
	 * 
	 * } else { System.out.println("No age inputed"); }
	 */
		
	

public void userId(By loactor,String UserId) {
	 ArrayList<String> uID = new ArrayList<String>();
	  uID.add(UserId);
	 // String regex = "^((?=.*[A-Z])[a-zA-Z0-9_@.#*]){8,18}$"; 
	  //String regex="^((?=.*[A-Z])[a-zA-Z\\d_$@#.]*).{8,18}$";
	  String regex ="^[A-Z]\\w{7,9}$";
	    //Compile regular expression to get the pattern  
	    Pattern pattern = Pattern.compile(regex);
	   // String pat=pattern.toString();//
	    //Iterate emails array list  
		
		for (String email : uID)
		{ // Create instance of matcher Matcher matcher
		Matcher matcher = pattern.matcher(email);
			
			System.out.println(email + " : " + matcher.matches());
			
			 if(matcher.matches()) {
				  
			ele=driver.findElement(loactor);
			ele.sendKeys(UserId);
	      System.out.println(uID +" is the valid UserId");
				  break;
				  
				  
				  } else 
				  { 
					  System.out.println(email+" not a valid userId");
					  }
		}
	
}
public void validate(By locator) {
	Boolean orderID= driver.findElement(locator).isDisplayed();
	Assert.assertTrue(orderID);
	System.out.println(orderID+" is the value");
			
}

/*
 * public void Phone_number(By locator, String text,int phonenumber) {
 * 
 * //WebElement ele=driver.findElement(locator).getText().toInteger();
 * 
 * final int lowerBound=1000; final int upperbound=1000000000;}
 */
/*
 * public void chooseElement(By locator,int x){
 * 
 * WebElement webElement; int y=Integer.x;
 * 
 * if (y>=1000000000&y<=10000000) { webElement=driver.findElement(locator);
 * webElement.sendKeys(x); } else if(y>=100000&y<=10000){
 * webElement=driver.findElement(locator); webElement.sendKeys(x);
 * 
 * } else if(y>=100&y<=0) { webElement=driver.findElement(locator);
 * webElement.sendKeys(x); }
 * 
 * else { System.out.print("no input"); } return; }
 */
/*
 * JTextField tf; Container container; JLabel label; public void
 * JTextFieldValidation() { container = getContentPane(); setBounds(0, 0, 500,
 * 300); tf = new JTextField(25); setLayout(new FlowLayout()); container.add(new
 * JLabel("Enter the number")); container.add(tf); container.add(label = new
 * JLabel()); label.setForeground(Color.red);
 * setDefaultCloseOperation(EXIT_ON_CLOSE); setLocationRelativeTo(null);
 * tf.addKeyListener(new KeyAdapter() { public void keyPressed(KeyEvent ke) {
 * String value = tf.getText(); int l = value.length(); if (ke.getKeyChar() >=
 * '0' && ke.getKeyChar() <= '9') { tf.setEditable(true); label.setText(""); }
 * else { tf.setEditable(false);
 * label.setText("* Enter only numeric digits(0-9)"); } } }); setVisible(true);
 */




public Action()
{
	driver = StartBrowser.driver;
}
/**
 * Used to navigate to any application
 * @param url -- URL of application
 */
public void navigateToApplication(String url)
{
	try {
		driver.get(url);
		StartBrowser.childTest.pass("Successfully Navigated to :"+url);
	} catch (Exception e) {
		StartBrowser.childTest.fail("Uanble to  Navigate to :"+url);
	}
}
/**
 * Used to perform click on links, buttons, radio buttons and checkboxes
 * @param locator -- Get it from Object Repository
 * @param eleName -- Name of the element
 * @throws Exception
 */
public void click(By locator, String eleName) throws Exception
{
	try {
		driver.findElement(locator).click();
		StartBrowser.childTest.pass("Performed click action on :"+eleName);
	} catch (Exception e) {
		StartBrowser.childTest.fail("Unable to performe click action on :"+eleName,
				MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
		StartBrowser.childTest.info(e);
		throw e;
	}
}


	public void scrollByVisibilityOfElement(WebDriver driver, By ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

	public static void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}

	public static boolean findElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			ele.isDisplayed();
			flag = true;
		} catch (Exception e) {
			// System.out.println("Location not found: "+locatorName);
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}

	public static boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isDisplayed();
			if (flag) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");
			}
		} else {
			System.out.println("Not displayed ");
		}
		return flag;
	}

	public boolean isSelected(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isSelected();
			if (flag) {
				System.out.println("The element is Selected");
			} else {
				System.out.println("The element is not Selected");
			}
		} else {
			System.out.println("Not selected ");
		}
		return flag;
	}

	public boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean flag = false;
		flag = findElement(driver, ele);
		if (flag) {
			flag = ele.isEnabled();
			if (flag) {
				System.out.println("The element is Enabled");
			} else {
				System.out.println("The element is not Enabled");
			}
		} else {
			System.out.println("Not Enabled ");
		}
		return flag;
	}

	/**
	 * Type text at location
	 * 
	 * @param locatorName
	 * @param text
	 * @return - true/false
	 */
	public static boolean type(WebElement ele, String text) {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			ele .sendKeys(text);
			// logger.info("Entered text :"+text);
			flag = true;
		} catch (Exception e) {
			System.out.println("Location Not found");
			flag = false;
		} finally {
			if (flag) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value");
			}

		}
		return flag;
	}

	public boolean selectBySendkeys(String value,WebElement ele) {
		boolean flag = false;
		try {
			ele.sendKeys(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Select value from the DropDown");		
			} else {
				System.out.println("Not Selected value from the DropDown");
				// throw new ElementNotFoundException("", "", "")
			}
		}
	}

	/**
	 * select value from DropDown by using selectByIndex
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param index       : Index of value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 * 
	 */
	public boolean selectByIndex(WebElement element, int index) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not selected by Index");
			}
		}
	}

	/**
	 * select value from DD by using value
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param value       : Value wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	public boolean selectByValue(WebElement element,String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}

	/**
	 * select value from DropDown by using selectByVisibleText
	 * 
	 * @param locator     : Action to be performed on element (Get it from Object
	 *                    repository)
	 * 
	 * @param visibletext : VisibleText wish to select from dropdown list.
	 * 
	 * @param locatorName : Meaningful name to the element (Ex:Year Dropdown, items
	 *                    Listbox etc..)
	 */

	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean flag = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}

	
	public boolean mouseHoverByJavaScript(WebElement ele) {
		boolean flag = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
	}

	
	public boolean JSClick(WebDriver driver, WebElement ele)  throws Exception {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			// driver.executeAsyncScript("arguments[0].click();", element);

			flag = true;

		}

		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}

	
	public boolean switchToFrameByIndex(WebDriver driver,int index) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
			driver.switchTo().frame(index);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with index \"" + index + "\" is selected");
			} else {
				System.out.println("Frame with index \"" + index + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame ID.
	 * 
	 * @param idValue : Frame ID wish to switch
	 * 
	 */
	
	public boolean switchToFrameById(WebDriver driver,String idValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(idValue);
			flag = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			} else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}

	/**
	 * This method switch the to frame using frame Name.
	 * 
	 * @param nameValue : Frame Name wish to switch
	 * 
	 */
	
	public boolean switchToFrameByName(WebDriver driver,String nameValue) {
		boolean flag = false;
		try {
			driver.switchTo().frame(nameValue);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!flag) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}

	
	public boolean switchToDefaultFrame(WebDriver driver) {
		boolean flag = false;
		try {
			driver.switchTo().defaultContent();
			flag = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (flag) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!flag) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}

	
	public void mouseOverElement(WebDriver driver,WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}
	}

	
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	
	public boolean mouseover(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
		}
	}
	
	public boolean draggable(WebDriver driver,WebElement source, int x, int y) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			flag = true;
			return true;

		} catch (Exception e) {
		
			return false;
			
		} finally {
			if (flag) {
				System.out.println("Draggable Action is performed on \""+source+"\"");			
			} else if(!flag) {
				System.out.println("Draggable action is not performed on \""+source+"\"");
			}
		}
	}
	
	public boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if(!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}
	
	
	public boolean slider(WebDriver driver,WebElement ele, int x, int y) {
		boolean flag = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Slider Action is performed");
			} else {
				System.out.println("Slider Action is not performed");
			}
		}
	}
	
	
	public boolean rightclick(WebDriver driver,WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}
	
	
	public boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
		boolean flag = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				flag = true;
			}else{
				flag = false;
			}
			return flag;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (flag) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}
	
	public boolean switchToNewWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Window is Navigated with title");				
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	public boolean switchToOldWindow(WebDriver driver) {
		boolean flag = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[0].toString());
			flag = true;
			return flag;
		} catch (Exception e) {
			flag = false;
			return flag;
		} finally {
			if (flag) {
				System.out.println("Focus navigated to the window with title");			
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	public int getColumncount(WebElement row) {
		List<WebElement> columns = row.findElements(By.tagName("td"));
		int a = columns.size();
		System.out.println(columns.size());
		for (WebElement column : columns) {
			System.out.print(column.getText());
			System.out.print("|");
		}
		return a;
	}
	

	public int getRowCount(WebElement table) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}
	
	
	/**
	 * Verify alert present or not
	 * 
	 * @return: Boolean (True: If alert preset, False: If no alert)
	 * 
	 */
	
	public boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");		
			} else{
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}
	
	public boolean launchUrl(WebDriver driver,String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \""+url+"\"");				
			} else {
				System.out.println("Failed to launch \""+url+"\"");
			}
		}
	}
	
	
	public boolean isAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}
	
	
	public String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	
	
	public String getCurrentURL(WebDriver driver)  {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}
	
	
	public boolean click1(WebElement locator, String locatorName) {
		boolean flag = false;
		try {
			locator.click();
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Able to click on \""+locatorName+"\"");
			} else {
				System.out.println("Click Unable to click on \""+locatorName+"\"");
			}
		}

	}
	
	
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	
	public static void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void explicitWait(WebDriver driver, WebElement element, int timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	public String screenShot()
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	public void type(By locator, String testData, String eleName) throws Exception
	{
	
		try {
			
	driver.findElement(locator).sendKeys(testData);
	StartBrowser.childTest.pass("Successfully performed type action on :"+eleName + " With test data :"+testData);
	} catch (Exception e) {
		
	StartBrowser.childTest.fail("Unable to performe type action action on :"+eleName + " With test data :"+testData,
	MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
	StartBrowser.childTest.info(e);
	throw e;
	}
	}
	
	/**
	 * Get text from element
	 * @param locator -- get it from OR
	 * @param eleName
	 * @return
	 * @throws Exception
	 */
	public String getText(By locator, String eleName) throws Exception
	{
		try {
			String text=driver.findElement(locator).getText();
			StartBrowser.childTest.pass("Successfully got text from element : "+eleName + "And Text is : "+text);
			 return text;
		} catch (Exception e) {
			StartBrowser.childTest.fail("Unable to performe type action action on :"+eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(screenShot()).build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}


	
	

}
