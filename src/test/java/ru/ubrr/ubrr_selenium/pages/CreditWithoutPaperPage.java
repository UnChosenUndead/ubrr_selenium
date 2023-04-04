package ru.ubrr.ubrr_selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class CreditWithoutPaperPage {

    WebDriver webDriver;
    //@FindBy(xpath = "\"//a[href()='#rcwd-form']\"")
    @FindBy(css = "#db > div.container.content > div.upBanner_wrapper__vR_DK > div.container > div > div.upBanner_right__IhEkN > div:nth-child(2) > a")
    WebElement applyOnlineButton;

    @FindBy(css = ".sc-ZzDLD > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)")
    WebElement years;

    @FindBy(css = ".sc-gKcDQK > div:nth-child(2)")
    WebElement amount;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[4]/div/div/div[2]/form/div[1]/div/div[1]/div[2]/div[1]/div[2]/div/div[2]/input")
    WebElement creditSumInput;
    @FindBy(xpath = "//button[normalize-space()=\"7 лет\"]")
    WebElement sevenYearsButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[4]/div/div/div[2]/form/div[1]/div/div[1]/div[5]/div/div/div[2]/a")
    WebElement hrefToTermsAndConditions;


    @FindBy(xpath = "/html/body/div[3]/div/div[2]/div/a[4]")
    WebElement hrefToSurvey;

    @FindBy(xpath = "/html/body/div[3]/div/div[1]")
    WebElement closeButton;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[4]/div/div/div[2]/form/div[1]/div/div[1]/div[9]/button")
    WebElement nextButton;


    public CreditWithoutPaperPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }


    public void applyAndSetCreditCredential() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();", applyOnlineButton);
        wait.until(ExpectedConditions.elementToBeClickable(sevenYearsButton));
        js.executeScript("arguments[0].scrollIntoView(true);", sevenYearsButton);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        js.executeScript("arguments[0].click();", sevenYearsButton);
        wait.until(ExpectedConditions.elementToBeClickable(creditSumInput));
        js.executeScript("arguments[0].click()", creditSumInput);
        for (int i = 0; i < 80; i++) {
            creditSumInput.sendKeys(Keys.LEFT);
        }
        assertEquals("7 лет", years.getText());
        assertEquals("100 000 ₽", amount.getText());

        js.executeScript("arguments[0].click()", hrefToTermsAndConditions);
        js.executeScript("arguments[0].click()", hrefToSurvey);
        js.executeScript("arguments[0].click()", closeButton);
        assertEquals("Далее", nextButton.getText());
        js.executeScript("arguments[0].click()", nextButton);
    }

}