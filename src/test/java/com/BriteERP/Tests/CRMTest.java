package com.BriteERP.Tests;

import com.BriteERP.pages.CRMPage;
import com.BriteERP.utilities.Driver;
import com.BriteERP.utilities.SeleniumUtils;
import com.BriteERP.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;

public class CRMTest extends TestBase {
    @Test(priority = 1)
    public void PivotListTest() {
        /*
        1.Verify that second opportunity’ Expected Revenue value on the Pivot board should be the
        same as the Expected revenue column value on the list board
         */
        extentLogger = report.createTest("Login as a store manager");
        CRMPage crmPage = new CRMPage();
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(crmPage.crmModule));
        extentLogger.info("reach pivot table");

        crmPage.reachPivotTable();
        SeleniumUtils.waitPlease(1);
        Collection<Double> actual= crmPage.PivotData().values();
        Collection<Double> expected=crmPage.PivotData().values();
        //  System.out.println(crmPage.PivotData().values());
        // System.out.println(crmPage.ListData().values());
        Assert.assertEquals(actual,expected);
        extentLogger.pass("Verified that Pivot data is same as list data");
    }
    @Test(priority = 2)
    public void VerfiySumTotal(){
        extentLogger = report.createTest("verify sum with total");
        CRMPage crmPage = new CRMPage();
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(crmPage.crmModule));
        crmPage.reachPivotTable();
        SeleniumUtils.waitPlease(1);
        //System.out.println(crmPage.TotalLocator.getText());
        String  total=crmPage.TotalLocator.getText().replace(",","");
        double actualtotal=Double.valueOf(total);
        //System.out.println(actualtotal);
        Collection<Double> values=crmPage.PivotData().values();
        //System.out.println(values);
        double sum=0;
        for(Double value:values){
            sum+=value;
        }
        //System.out.println(sum);
        Assert.assertEquals(sum,actualtotal);
        extentLogger.pass("Verified sum equal total");
    }
}
