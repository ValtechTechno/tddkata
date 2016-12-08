package tddj.selenium;

import com.google.common.base.Function;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloSeleniumTest {

    private WebDriver driver;

    @Before
    public void before() throws Exception {
        driver = new HtmlUnitDriver();
        driver.get("http://google.fr");
    }

    @After
    public void after() throws Exception {
        driver.quit();
    }

    @Test
    public void google_search() {
        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("selenium");
        webElement.submit();
        assertThat(driver.getTitle()).isEqualTo("selenium - Recherche Google");
    }

    @Test
    public void google_results() {
        WebElement webElement = driver.findElement(By.name("q"));
        webElement.sendKeys("selenium");
        webElement.submit();
//        System.out.println(driver.getPageSource());
//        System.out.println(driver.getCurrentUrl());
        new WebDriverWait(driver, 10).until((Function<WebDriver, Boolean>) webDriver -> {
            List<WebElement> elements = driver.findElements(By.className("g"));
            return new Boolean(elements.size() != 0);
        });
        assertThat(driver.findElements(By.xpath("//*[@class='g']//a[starts-with(@href, '/url')]"))).hasSize(32);
    }
}
