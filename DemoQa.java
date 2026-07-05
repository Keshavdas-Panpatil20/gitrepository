package demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoQA {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void test() {

        
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        
        driver.findElement(By.id("firstName")).sendKeys("Keshav");
        driver.findElement(By.id("lastName")).sendKeys("Patil");
        driver.findElement(By.id("userEmail")).sendKeys("keshav@gmail.com");

       
        System.out.println(driver.findElement(By.id("firstName")).getAttribute("value"));
        System.out.println(driver.findElement(By.id("lastName")).getAttribute("value"));
        System.out.println(driver.findElement(By.id("userEmail")).getAttribute("value"));

        
        List<WebElement> textbox = driver.findElements(By.tagName("input"));

        for (WebElement t : textbox) {

            System.out.println("Tag Name : " + t.getTagName());
            System.out.println("Visible  : " + t.isDisplayed());
            System.out.println("Editable : " + t.isEnabled());
            System.out.println("----------------------");
        }
        
        Dimension d = driver.manage().window().getSize();
        System.out.println("Width : " + d.getWidth());
        System.out.println("Height : " + d.getHeight());

        
        ((JavascriptExecutor) driver).executeScript("window.open();");

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        
        driver.switchTo().window(tabs.get(0));

        
        driver.switchTo().window(tabs.get(1));

        
        driver.close();

      
        driver.switchTo().window(tabs.get(0));

       
        driver.quit();
    }
}
