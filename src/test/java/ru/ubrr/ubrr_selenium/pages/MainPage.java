package ru.ubrr.ubrr_selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    WebDriver webDriver;
    @FindBy(xpath = "/html/body/div[1]/div/header/div/div[2]/div[1]/div[1]/ul/li[3]/a")
    WebElement menuCredit;

    @FindBy(css = "html > body > div:nth-of-type(1) > div > header > div > div:nth-of-type(2) > div:nth-of-type(2) > div > div > div:nth-of-type(1) > ul > li:nth-of-type(3) > a")
    WebElement menuElementCreditWithoutPapers;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void goToCreditWithoutPaper() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        Actions action = new Actions(webDriver);
        action.moveToElement(menuCredit).build().perform();
        var waitUntilWithoutPapersEnable = webDriverWait.until(ExpectedConditions.elementToBeClickable(menuElementCreditWithoutPapers));
        waitUntilWithoutPapersEnable.click();
    }
}
