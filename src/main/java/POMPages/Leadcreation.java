package POMPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethod.CommonAction;

public class Leadcreation extends CommonAction{
	CommonAction ca= new CommonAction();

	public Leadcreation()
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "firstName")
	private WebElement firstName;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(id = "phNo")
	private WebElement phone;

	@FindBy(id = "email")
	private WebElement emailid;

	@FindBy(id = "calender1")
	private WebElement calender;

	@FindBy(id = "//td/a[text()='22']")
	private WebElement date;

	@FindBy(xpath = "//a[text()='Other']")
	private WebElement Other;

	@FindBy(xpath = "//p[text()='Add Document']")
	private WebElement Doc;

	@FindBy(xpath = "//input[@name='imageFiles']")
	private WebElement Img;

	@FindBy(xpath ="(//select[contains(@class,'styled-select document')])[2]")
	private WebElement selectother;

	@FindBy(xpath ="//span[text()='Cancel']")
	private WebElement popupcancel;

	@FindBy(xpath ="//span[text()='SAVE LEAD']")
	private WebElement savelead;

	@FindBy(xpath ="//li[contains(text(),'Lead Saved')]")
	private WebElement saved;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmailid() {
		return emailid;
	}

	public WebElement getCalender() {
		return calender;
	}

	public WebElement getDate() {
		return date;
	}

	public WebElement getOther() {
		return Other;
	}

	public WebElement getDoc() {
		return Doc;
	}

	public WebElement getImg() {
		return Img;
	}

	public WebElement getSelectother() {
		return selectother;
	}

	public WebElement getPopupcancel() {
		return popupcancel;
	}

	public WebElement getSavelead() {
		return savelead;
	}

	public WebElement getSaved() {
		return saved;
	}

	public void fillLeadDetails(String value1,String value2,String value3,String value4,String value5,String value6) throws InterruptedException
	{
		ca.insertText(getFirstName(), value1);
		ca.insertText(getLastName(), value2);
		ca.insertText(getPhone(), value3);
		ca.insertText(getEmailid(), value4);
		System.out.println("mandatory values has entered");
		ca.movetoele(getCalender());
		ca.click(getCalender());
		try{ca.click(getDate());}
		catch(Exception e){		}

		ca.movetoele(getDoc());
		ca.click(getDoc());
		ca.selectFromDrpValue(getSelectother(), "OTHER");
		if(!value5.equals("null"))
		{
			System.out.println("path not given in excel");		
		}
				ca.click(getPopupcancel());   
		ca.movetoele(getImg());
		if(!value6.equals("null"))
		{
			ca.click(getImg());
		}

	}

	public void verifylead() throws InterruptedException
	{
		
		ca.movetoele(getSavelead());
		ca.click(getSavelead());
		ca.eletobewait(); ca.eletobewait();
		String text = getSaved().getText();
		if(text.contains("Successfully"))
		{
			System.out.println(text +" is validated");
		}
	}

}
