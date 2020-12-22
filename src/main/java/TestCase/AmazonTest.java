package TestCase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import POMPages.LoginPage;
import POMPages.Leadcreation;
import commonMethod.CommonAction;

public class AmazonTest extends CommonAction{

	WebDriver driver;
	LoginPage lp ;
	CommonAction ca;
	Leadcreation ss;

	@BeforeSuite
	public void browser() throws FileNotFoundException, IOException, InterruptedException
	{
		ca=new CommonAction();
		ca.startchrome();
		lp=new LoginPage();
		ss= new Leadcreation();
		
		ca.click(lp.getSignin());
		insertText(lp.getUserid(), ca.getproperty("username"));
		insertText(lp.getPwd(),ca.getproperty("password"));
		lp.signinfunction();
		
	}

	@BeforeClass()
	public void setData() 
	{
		excelname="TC001";  
	}	


	@Test(dataProvider="Testcase")  
	public  void createLead(String fname, String lname,String phno, String mailid,String date,String docpath, String imgpath) throws Exception   {

		/*ca.click(lp.getSignin());
		insertText(lp.getUserid(), ca.getproperty("username"));
		insertText(lp.getPwd(),ca.getproperty("password"));
		lp.signinfunction();*/
		lp.selectLeadfunction();
		ss.fillLeadDetails(fname, lname, phno, mailid,docpath,imgpath);
		ss.verifylead();
	}

	/*@AfterSuite
	public void closedriver()
	{
		ca.closeBrowser();
	}*/

}
