package com.inetbanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage 
{
	WebDriver ldrDriver;
	 
	public AddCustomerPage(WebDriver rdrDriver)
	{
		ldrDriver = rdrDriver;
		PageFactory.initElements(rdrDriver, this);
	}
	
	// How is one of the method to find the elements on the webpage just like @FindBy
	
	
	@FindBy(how = How.XPATH, using= "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement lnkAddnewCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;
	
	@CacheLookup
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	WebElement txtdob;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "addr")
	WebElement txtaddress;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "city")
	WebElement txtcity;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "state")
	WebElement txtState;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "pinno")
	WebElement txtpinno;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "telephoneno")
	WebElement txttelephoneno;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "emailid")
	WebElement txtemailid;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "password")
	WebElement txtpassword;
	
	@CacheLookup
	@FindBy(how = How.NAME, using = "sub")
	WebElement btnsubmit;
	
	
	// Actions Method
	public void  clickAddnewcustomer()
	{
		lnkAddnewCustomer.click();
	}
	
	public void  customerName(String cname)
	{
		txtCustomerName.sendKeys(cname);
	}
	
	public void  customerGender(String cgender)
	{
		rdGender.click();
	}
	
	public void  customerDOB(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void  customerAddress(String caddress)
	{
		txtaddress.sendKeys(caddress);
	}
	
	public void  customerCity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void  customerstate(String cstate)
	{
		txtState.sendKeys(cstate);
	}
	
	public void  customerpinno(String cpinno)
	{
		txtpinno.sendKeys(String.valueOf(cpinno)); // String.valuOf is optional here.
	}
	
	public void  customertelephoneno(String ctelephoneno)
	{
		txttelephoneno.sendKeys(ctelephoneno);
	}
	
	public void  customeremailid(String cemailid)
	{
		txtemailid.sendKeys(cemailid);
	}
	
	public void  customerPassword(String cpassword)
	{
		txtpassword.sendKeys(cpassword);
	}
	
	public void  customerSubmit()
	{
		btnsubmit.click();
	}
}

