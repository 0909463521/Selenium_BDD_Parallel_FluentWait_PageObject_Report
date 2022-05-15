package services;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import lombok.var;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.io.*;
import org.apache.commons.io.FileUtils;

import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FluentWaitCode {

    String driverPath = "/Users/bachvu/Documents/GitHub/BDD_Parallel_FluentWait_PageObject_Report/chromedriver";



    public WebDriver driver;
    public Properties prop;



    public ExtentReports extent;

    public static ExtentTest scenarioDef;

    public static ExtentTest features;

    // TODO biến lưu trữ các scenario trong report
    // TODO mỗi Thread ID sẽ match với mỗi Node trong report
    // TODO biến extentNodeMap nay global list object chua cac object ( chua thread ID tuong ung cac Node )
    public static Map<Integer, ExtentTest> extentNodeMap = new HashMap();


    public static String reportLocation = "src/test/java/reports";


    public WebDriver setup(String browser) throws InterruptedException, IOException {
//        System.setProperty("webdriver.chrome.driver", driverPath);

        prop= new Properties();
//        InputStream fis = getClass().getClassLoader().getResourceAsStream("data.properties");
//        prop.load(fis);
//        String browserName=prop.getProperty("browser");
        String browserName=browser;



        if(browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver= new ChromeDriver();
            //execute in chrome driver
            System.out.println("sadasdsad");

        }
        else if (browserName.equals("firefox"))
        {
            driver= new FirefoxDriver();
            //firefox code
        }
        else if (browserName.equals("IE"))
        {
            //	IE code
            System.out.println("");
        }
        else
            System.out.println("");


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver = driver;
        return driver;


    }
    public WebElement waitedElement(By locator)
    {
        System.out.println(locator);

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                System.out.println("A");
                return driver.findElement(locator);
            }
        });
        return element;
    }

    public void waitForElementAndClick(By locator)
    {

        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofMillis(15))
                .pollingEvery(Duration.ofMillis(1))
                .ignoring(NoSuchElementException.class);

        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                System.out.println("B");
                return driver.findElement(locator);
            }
        });
        element.click();
    }

    public boolean waitforElementAndDisplayed(By locator)
    {
       WebElement element = waitedElement(locator);
        FluentWait<WebElement> wait = new FluentWait<WebElement>(element)
                .withTimeout(Duration.ofMillis(15))
                .pollingEvery(Duration.ofMillis(1))
                .ignoring(NoSuchElementException.class);

        boolean isDisplayed = wait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                boolean flag = element.isDisplayed();
                return flag;
            }
        });
        return isDisplayed;
    }
    public void getScreenshot(String result) throws IOException
    {


    }
    public void navigateTo(String url)
    {
        driver.get(url);
    }


    // TODO function tao node dua theo moi scenario ( node ) trong report -> moi senario tuong ung la 1 thread
    public static synchronized ExtentTest startNode(String nodeName) {
        ExtentTest 	threadnode = features.createNode(nodeName);
        extentNodeMap.put((int) (long) (Thread.currentThread().getId()), threadnode);
        return threadnode;
    }
    // TODO function get Node ( thread ) hien tai de them value pass fail cua cac step
    //TODO moi thread tuong ung voi node trong bien extendNodeMap ( Object ) -> se lay Object node ra theo Thread ID
    public static synchronized ExtentTest getNode() {
        System.out.println(Thread.currentThread().getId());
        return (ExtentTest) extentNodeMap.get((int) (long) (Thread.currentThread().getId()));
    }
    public static File  captureScreenShot(WebDriver driver) throws IOException {

        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String dest = "src/test/java/reports/"+getcurrentdateandtime() + ".png";
        File target = new File(dest);
        FileUtils.copyFile(src, target);
        return target;
    }
    public static String getcurrentdateandtime() {
        String str = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            str = dateFormat.format(date);
            str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
        } catch (Exception e) {
        }
        return str;
    }

}
