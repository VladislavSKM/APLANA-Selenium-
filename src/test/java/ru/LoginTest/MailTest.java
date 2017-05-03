package ru.LoginTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MailTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://mail.ru/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  @Test
  public void testMail() throws Exception {
    driver.findElement(By.xpath("//*[@id='mailbox__login']")).clear();
    driver.findElement(By.xpath("//*[@id='mailbox__login']")).sendKeys("vladnaldin");
    driver.findElement(By.xpath("//*[@id='mailbox__password']]")).clear();
    driver.findElement(By.xpath("//*[@id='mailbox__password']]")).sendKeys("crimetime111");
    driver.findElement(By.xpath("//*[@id='mailbox__auth__button']")).click();
    driver.findElement(By.xpath("//*[.='Написать письмо']")).click();
    driver.findElement(By.xpath("//textarea[@class='js-input compose__labels__input']")).clear();
    driver.findElement(By.xpath("//textarea[@class='js-input compose__labels__input']")).sendKeys("skm_vlad@mail.ru");
    driver.findElement(By.xpath("//input[@class='b-input']")).clear();
    driver.findElement(By.xpath("//input[@class='b-input']")).sendKeys("Test");
    driver.findElement(By.xpath("//div[@data-name='send']")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
