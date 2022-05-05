package com.goutham;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
    static String baseURL = "https://www.urbanladder.com";
    static WebDriver driver;

    @BeforeTest
    void initilize() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURL);
    }

    @Test
    void test() throws Exception {
        driver.manage().window().maximize();
        WebElement study = driver.findElement(By.xpath("//*[@id='topnav_wrapper']/ul/li[6]/span"));
        Actions action = new Actions(driver);
        action.moveToElement(study).perform();
        Thread.sleep(3000);
        WebElement bookshelves = driver
                .findElement(By.xpath("//*[@id='topnav_wrapper']/ul/li[6]/div/div/ul/li[3]/ul/li[1]/a/span"));
        action.moveToElement(bookshelves).perform();
        bookshelves.click();
        Thread.sleep(5000);
        action.sendKeys(Keys.ESCAPE).perform();
        Thread.sleep(5000);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[1]")))
                .perform();
        Thread.sleep(1000);
        WebElement dragElement = driver.findElement(By.xpath(
                "//*[@id='filters-form']/div[1]/div/div/ul/li[1]/div[2]/div/div/ul/li[1]/div/div[2]/div[2]/div/div[2]/div"));
        action.dragAndDropBy(dragElement, -202, 0).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='filters_availability_In_Stock_Only']")).click();
        Thread.sleep(1000);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='filters-form']/div[1]/div/div/ul/li[2]"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='filters_storage_type_Open']")).click();
        Thread.sleep(3000);
        List<WebElement> producList = driver.findElements(By.className("product"));
        System.out.println(producList.size());
    }
}
