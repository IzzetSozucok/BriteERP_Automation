package com.BriteERP.pages;

import com.BriteERP.utilities.Driver;
import com.BriteERP.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRMPage {
    @FindBy(xpath = "//span[contains(text(),' CRM')]")

    public WebElement crmModule;

    @FindBy(css = "[data-view-type='pivot']")
    public WebElement pivotbuttom;

    @FindBy(css = "tbody [class^=\"o_pivot_header_cell_\"]")

    public WebElement totalData;
    @FindBy(xpath = "//a[text()='Opportunity']")
    public WebElement oppottunity;
    @FindBy(css = "tbody tr")
    public WebElement rawOfTable;
    @FindBy(css = "[accesskey=\"l\"]")
    public WebElement listButtomLocator;
    @FindBy(css = "tbody [class^=\"o_pivot_header_cell_\"]+td")
    public WebElement TotalLocator;


    //    @FindBy(css = "tbody tr :nth-of-type(3)")
//    public WebElement colunmListOpp;
//    @FindBy(css = "tbody tr :nth-of-type(9)")
//    public WebElement colunmListExRevenue;
    public CRMPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void reachPivotTable(){

        crmModule.click();
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(pivotbuttom));
        pivotbuttom.click();
        totalData.click();
        //SeleniumUtils.waitPlease(2);
        totalData.click();
        SeleniumUtils.waitPlease(2);
        oppottunity.click();

    }
    public Map<String,Double> ListData(){
        listButtomLocator.click();
        SeleniumUtils.waitPlease(1);
        List<WebElement> colunmListOpp= Driver.getDriver().findElements(By.cssSelector("tbody tr :nth-of-type(3)"));
        List<WebElement> colunmListExRevenue= Driver.getDriver().findElements(By.cssSelector("tbody tr :nth-of-type(9)"));
        Map<String, Double> listMap = new HashMap<>();
        for(int i=0;i<3;i++) {
            listMap.put(colunmListOpp.get(i).getText(),Double.valueOf(colunmListExRevenue.get(i).getText()));
        }
        return listMap;
    }
    public Map<String,Double> PivotData(){
        //SeleniumUtils.waitPlease(1);
        List<WebElement> colunmPivotOpp= Driver.getDriver().findElements(By.cssSelector("tbody tr :nth-of-type(1)"));
        //SeleniumUtils.waitPlease(1);
        List<WebElement> colunmPivotExRevenue= Driver.getDriver().findElements(By.cssSelector("tbody tr :nth-of-type(2)"));
        Map<String, Double> pivotMap = new HashMap<>();
        for(int i=1;i<=3;i++) {
            //System.out.println(colunmPivotExRevenue.get(i).getText());
            pivotMap.put(colunmPivotOpp.get(i).getText(),Double.valueOf(colunmPivotExRevenue.get(i).getText().trim()));
        }
        return pivotMap;
    }
}
