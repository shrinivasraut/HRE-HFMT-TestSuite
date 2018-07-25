package com.qa.hfmt.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthStyle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hfmt.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	
	public TestBase() {
		// TODO Auto-generated constructor stub
		prop=new Properties();
		System.out.println("Test Base Constructor");
		try {
			String filePath=System.getProperty("user.dir")+"//src//main//java//com//qa//hfmt//config//config.properties";
			System.out.println("Config File Path= "+filePath);
			FileInputStream ifs = new FileInputStream(filePath);
			prop.load(ifs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			System.out.println("Test Base Constructor1");
		
	}
	
	public void initialization() {
		String browser=prop.getProperty("browser");
		System.out.println("browser selected is"+browser);
		if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
		} else if (browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (browser.equals("mozila")) {
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//drivers//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));	
		wait = new WebDriverWait(driver, 30);
	}
	
}
