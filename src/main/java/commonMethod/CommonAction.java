package commonMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
public class CommonAction{

	public static WebDriver driver;
	public String excelname;
	
	

	public void startchrome() throws FileNotFoundException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "./data/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(getproperty("url"));
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public void eletobewait() throws InterruptedException
	{
		Thread.sleep(2000);
	}
	
	public void movetoele(WebElement ele)
	{
		Actions aa = new Actions(driver);
		aa.moveToElement(ele).build().perform();
	}
	public void insertText(WebElement element, String value) {
		try{
			try{
				element.clear();
			}catch(Exception e1){
				element.sendKeys(Keys.DELETE);
			}
		}catch (Exception e) {

		}
		element.sendKeys(value);
	}

	public static void closeBrowser() {
		try {
			driver.quit();
		} catch (Exception e) {
		}
	}


	public void click(WebElement element) throws InterruptedException {
		element.click();
		Thread.sleep(500);
	}

	public String getproperty(String value) throws FileNotFoundException, IOException
	{
		Properties prp= new Properties();
		prp.load(new FileInputStream(new File(".//TestData//lennox.properties")));
		String property = prp.getProperty(value);
		return property;
	}



	public void selectFromDrpValue(WebElement element , String value){
		try{

			Select selectObject = new Select(element);
			selectObject.selectByVisibleText(value);

		}catch(Exception e){
			System.out.println("Cant able to getText of " + value + "\n\n" + "ERROR MESSAGE :: " + e.toString());
		}
	}



	@DataProvider(name="Testcase")
	public String[][] getData() 
	{
		return DataInputProvider.getSheet(excelname);

	}

		

}
