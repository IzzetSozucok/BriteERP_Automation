package com.BriteERP.pages;

import com.BriteERP.utilities.ConfigurationReader;
import com.BriteERP.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guljahan_LoginPage {

    static private WebDriver driver = Driver.getDriver();

    private WebDriverWait wait = new WebDriverWait(driver, Long.valueOf(ConfigurationReader.getProperty("explicitwait")));

    @FindBy(id = "login")
    public WebElement userNameElement;

    @FindBy(name = "password")
    public WebElement passwordElement;

    @FindBy(xpath="//button[contains(text(), 'Log in')]")
    public WebElement loginButtonElement;

    // @FindBy(className = "custom-checkbox__icon")
    //  public WebElement rememberMeElement;

    @FindBy(xpath = "//span[contains(text(), 'CRM')]")
    public WebElement crmElement;

    @FindBy(className = "btn btn-icon fa fa-lg fa-table o_cp_switch_pivot")
    public WebElement pivotElement;

    @FindBy(xpath = "//button[@aria-label='list']")
    public WebElement listElement;

    @FindBy(xpath = "//table[1]//tbody//tr[2]//td[1]")
    public WebElement newPlusElement;

    @FindBy(xpath = "//li//a[contains(text(), \"Opportunity\")]")
    public WebElement opportunityElement;

    @FindBy(xpath = "//table[1]//tbody//tr[4]//td[2]")
    public WebElement secondOpportunityFromPivotBoardElement;

    @FindBy(xpath = "//table[1]//tbody//tr[2]//td[9]")
    public WebElement expectedRevenueFromListBoardElement;

    public Guljahan_LoginPage(){
        PageFactory.initElements(driver, this);
    }
    public void login(String username, String password){
        userNameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
        // VYTrackUtils.waitUntilLoaderScreenDisappear(driver);
    }

    //   public void clickRememberMe(){
    //     wait.until(ExpectedConditions.elementToBeClickable(rememberMeElement));
    //     if(!rememberMeElement.isSelected()){
    //        rememberMeElement.click();
    //    }
//    }
}



