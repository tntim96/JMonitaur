package com.github.tntim96.jmonitaur.web.integration;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AcceptanceTest {
    private WebDriver driver = new FirefoxDriver();

    @After
    public void tearDown() {
        try {
            driver.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
        try {
            driver.quit();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    @Test
    public void shouldRenderStatusPageAngularJS() {
        driver.get("http://localhost:8080/index");
        verifyPage();
    }

    @Test
    public void shouldRenderStatusPageServer() {
        driver.get("http://localhost:8080/status");
        verifyPage();
    }

    private void verifyPage() {
        assertThat(driver.getTitle(), equalTo("JMonitaur - Status"));
        String xPathRow2 = "//table[contains(@class,'healthTable')]//tr[2]";
        new WebDriverWait(driver, 1).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathRow2)));
        assertThat(driver.findElement(By.xpath(xPathRow2 + "/td[1]")).getText(), equalTo("CRITICAL"));
        assertThat(driver.findElement(By.xpath(xPathRow2 + "/td[2]")).getText(), equalTo("Shields"));
        assertThat(driver.findElement(By.xpath(xPathRow2 + "/td[3]")).getText(), equalTo("30% power"));
    }
}
