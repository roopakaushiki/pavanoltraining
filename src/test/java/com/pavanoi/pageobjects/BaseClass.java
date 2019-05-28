package com.pavanoi.pageobjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.pavanoi.utilities.ReadConfig;



public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	
public String baseURL= readconfig.getApplicationURL();
public String username = readconfig.getUsername();
public String password = readconfig.getPassword();
public static WebDriver driver;
public static Logger logger;


@Parameters("browser")
@BeforeClass
public void setUp(String br) throws InterruptedException {
	
	logger = Logger.getLogger("ebanking");
	PropertyConfigurator.configure("Log4j.properties");
	
	if(br.equals("chrome")) {
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
	driver = new ChromeDriver();
	}else if (br.equals("ff")) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(baseURL);
	Thread.sleep(4000);
	
}
@AfterClass
public void tearDown() {
	driver.quit();
	
}
public String randomestring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}

public static String randomeNum() {
	String generatedString2 = RandomStringUtils.randomNumeric(4);
	return (generatedString2);
}

public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}



}
