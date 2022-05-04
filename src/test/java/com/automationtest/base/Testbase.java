package com.automationtest.base;

import E2ETest.util.TestUtil;
import cucumber.api.Scenario;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Testbase {

    public static WebDriver driver;
    public static Properties prop;
    public static Object ldriver;
    // public WebDriver driver;
    public Scenario scenario;

    public Testbase() {
        {
            PageFactory.initElements( driver, this );
        }

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    "C:/Users/dmarella/IdeaProjects/E2E_PRD40/src/main/java/E2ETest/config/configuration.properties");
            prop.load( ip );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String  intialization() {
        String browserName = prop.getProperty( "browser" );

        // To Open the Browser
        if (browserName == "IE") {
            System.setProperty( "webdriver.ie.driver", prop.getProperty( "IEPath" ) );
            driver = new InternetExplorerDriver();

        } else if (browserName.equals( "chrome" )) {
            System.setProperty( "webdriver.chrome.driver", prop.getProperty( "ChromePath" ) );
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability( CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE );
            dc.setCapability("acceptSslCerts", true);
            dc.setCapability("acceptInsecureCerts", false);
            driver = new ChromeDriver();

        } else if (browserName.equals( "firefox" )) {
            System.setProperty( "webdriver.gecko.driver", prop.getProperty( "FFPath" ) );
            driver = new FirefoxDriver();

        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout( TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS );
        driver.manage().timeouts().implicitlyWait( TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS );
        // To navigate to the URL
        driver.get( prop.getProperty( "url" ) );
        return browserName;
    }
    public static String FSOintialization() {
        String browserName = prop.getProperty( "browser" );

        // To Open the Browser
        if (browserName == "IE") {
            System.setProperty( "webdriver.ie.driver", prop.getProperty( "IEPath" ) );
            driver = new InternetExplorerDriver();

        } else if (browserName.equals( "chrome" )) {
            System.setProperty( "webdriver.chrome.driver", prop.getProperty( "ChromePath" ) );
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability( CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE );
            dc.setCapability("acceptSslCerts", true);
            dc.setCapability("acceptInsecureCerts", false);
            driver = new ChromeDriver();

        } else if (browserName.equals( "firefox" )) {
            System.setProperty( "webdriver.gecko.driver", prop.getProperty( "FFPath" ) );
            driver = new FirefoxDriver();

        }


        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout( TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS );
        driver.manage().timeouts().implicitlyWait( TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS );
        // To navigate to the URL
        driver.get( prop.getProperty( "FSOurl" ) );
        return browserName;
    }
    public static String PrePRODintialization() {
        String browserName = prop.getProperty("browser");
        // To Open the Browser
        if (browserName == "IE") {
            System.setProperty("webdriver.ie.driver", prop.getProperty("IEPath"));
            driver = new InternetExplorerDriver();

        } else if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromePath"));
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
            dc.setCapability("acceptSslCerts", true);
            dc.setCapability("acceptInsecureCerts", false);
            driver = new ChromeDriver();

        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", prop.getProperty("FFPath"));
            driver = new FirefoxDriver();

        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        // To navigate to the URL
        driver.get(prop.getProperty("PreProdURL"));
        return browserName;

    }


    public static void cleanUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
        //driver.quit();
    }

}