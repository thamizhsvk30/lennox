package POMPages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethod.CommonAction;

public class LoginPage extends CommonAction {
	
	CommonAction ca= new CommonAction();
	public LoginPage()
	{
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Cancel']")
	private WebElement Cancel;
	
	@FindBy(xpath = "//a[text()='Sign In']")
	private WebElement signin;

	@FindBy(id = "j_username")
	private WebElement userid;

	@FindBy(id = "j_password")
	private WebElement pwd;

	@FindBy(xpath ="//button[text()='Sign In']")
	private WebElement signInSubmit;

	@FindBy(xpath = "//div[contains(@class,'container ')]/div/div/a/i")
	private WebElement Tab;

	@FindBy(xpath = "//a[text()='Sales Tools']")
	private WebElement Salestools;

	@FindBy(xpath = "//a[text()='Build a Proposal']")
	private WebElement Buildproposal;

	@FindBy(xpath = "//a[text()='SELECT LEAD']")
	private WebElement SelectLead;
	
	@FindBy(xpath = "(//a//span[text()='ADD LEAD'])[2]")
	private WebElement AddLead;
	
	

	public WebElement getCancel() {
		return Cancel;
	}

	public WebElement getSignin() {
		return signin;
	}

	public WebElement getUserid() {
		return userid;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getSignInSubmit() {
		return signInSubmit;
	}

	public WebElement getTab() {
		return Tab;
	}

	public WebElement getSalestools() {
		return Salestools;
	}

	public WebElement getBuildproposal() {
		return Buildproposal;
	}

	public WebElement getSelectLead() {
		return SelectLead;
	}

	public WebElement getAddLead() {
		return AddLead;
	}
	
	public void signinfunction() throws InterruptedException
	{
	ca.click(getSignInSubmit());
	ca.eletobewait(); ca.eletobewait();
	try{ca.click(getCancel());}
	catch(Exception e){ }
	System.out.println("Sign in completed");
	}
	public void selectLeadfunction() throws InterruptedException
	{
		ca.click(getTab());
		ca.click(getSalestools());
		ca.click(getBuildproposal());
		ca.click(getSelectLead());
		ca.click(getAddLead());
		System.out.println("Add lead creation");
	}
	
}