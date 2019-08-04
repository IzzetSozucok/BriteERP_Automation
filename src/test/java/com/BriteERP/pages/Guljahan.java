package com.BriteERP.pages;

import com.BriteERP.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Guljahan {

    WebDriver driver;

    String usernameLocator = "login";
    String passwordLocator = "password";
    String submit = "//button[contains(text(), 'Log in')]";
    String crmLocator = "//span[contains(text(), 'CRM')]";
    String pipelineLocator = "274&action=365";
    String listLocator = "//button[@aria-label='list']";
    String checkboxLocator = "//td[1]//input[@type='checkbox']";
    String actionBtnLocator = "//button[contains(text(), 'Action')]";
    String deleteBtnLocator = "//a[contains(text(), 'Delete')]";
    String okBtnLocator = "//span[contains(text(), 'Ok')]";

    @BeforeMethod
    public void login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://34.220.250.213/web/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id(usernameLocator)).sendKeys("salesmanager40@info.com");
        driver.findElement(By.id(passwordLocator)).sendKeys("salesmanager");
        driver.findElement(By.xpath(submit)).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void test1(){

        driver.findElement(By.xpath(crmLocator)).click();
        SeleniumUtils.waitPlease(5);

        // driver.findElement(By.id(pipelineLocator)).click();
        //    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath(listLocator)).click();
        SeleniumUtils.waitPlease(5);

        driver.findElement(By.xpath(checkboxLocator)).click();
        SeleniumUtils.waitPlease(5);

        driver.findElement(By.xpath(actionBtnLocator)).click();
        SeleniumUtils.waitPlease(5);

        driver.findElement(By.xpath(deleteBtnLocator)).click();
        SeleniumUtils.waitPlease(5);

        driver.findElement(By.xpath(okBtnLocator)).click();


    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}

//Describe your project --->
//Which programming languages you used --> Java, HTML
//Which core java concept is being used ---> polymorhism
//Which testing tools used ---> Selenium WebDriver
//Which IDE ---> Intellij IDEA
//which browser did you use ---> chrome



