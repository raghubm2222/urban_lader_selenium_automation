package com.goutham;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
    static String baseURL = "https://www.urbanladder.com/gift-cards?src=header";
    static WebDriver driver;

    @Test
    void startTests() {
        List<TestData> testDataList = DatabaseOperations.getTestList();
        for (TestData testData : testDataList)
            try {
                startTest(testData);
                System.out.println("Test " + testData.getTestId() + " completed Successfully");
            } catch (InterruptedException e) {
                System.out.println("Exception occured while executing test: " + testData.getTestId());
            }
        driver.quit();
    }

    static void startTest(TestData testData) throws InterruptedException {
        try {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(baseURL);
            Thread.sleep(1000);
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//*[@id='app-container']/div/header/section/div/ul[2]/li[3]/a")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[1]/div/main/section/section[1]/ul/li[3]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='ip_2251506436']")).sendKeys("1000");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='app-container']/div/main/section/section[2]/div/section[2]/button"))
                    .click();
            driver.findElement(By.name("recipient_name")).sendKeys(testData.getRecipientName());
            Thread.sleep(1000);
            driver.findElement(By.name("recipient_email")).sendKeys(testData.getRecipientEmail());
            Thread.sleep(1000);
            driver.findElement(By.name("customer_name")).sendKeys(testData.getSenderName());
            Thread.sleep(1000);
            driver.findElement(By.name("customer_email")).sendKeys(testData.getSenderEmail());
            Thread.sleep(1000);
            driver.findElement(By.name("customer_mobile_number")).sendKeys(testData.getSenderPhoneNumber());
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id='app-container']/div/main/section/section[3]/form/button"))
                    .click();
            Thread.sleep(10000);
        } finally {
            driver.quit();
        }

    }

}
