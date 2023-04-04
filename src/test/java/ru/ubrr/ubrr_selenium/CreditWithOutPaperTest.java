package ru.ubrr.ubrr_selenium;


import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.ubrr.ubrr_selenium.pages.CreditWithoutPaperPage;
import ru.ubrr.ubrr_selenium.pages.MainPage;

import java.time.Duration;

public class CreditWithOutPaperTest {


//    Открыть сайт https://www.ubrr.ru/
//    Перейти на страницу "Кредиты" - “Кредит без справок”
//    Нажать кнопку "Оформить онлайн"
//    Передвинуть ползунок “Желаемая сумма кредита” на 1000000
//    Выбрать срок “7 лет”
//    Нажать на “принимаю условия и даю согласие”
//    Прокрутить ползунок вниз
//    Скачать анкету заявителя
//    Закрыть окно
//    Проставить галку в чек-боксе “Подтверждения обработки данных”
//    Нажать Далее


    WebDriver webDriver;
    MainPage objMainPage;
    CreditWithoutPaperPage objCreditWithoutPaperPage;

    @BeforeClass
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().window().fullscreen();
        webDriver.get("https://www.ubrr.ru/");
    }

    @AfterClass
    public void close() {
        webDriver.close();
    }

    @Test(priority = 0, description = "go to credit with out paper from main page")
    @Description("go to credit with out paper from main page")
    @Step
    public void fromMainPageToCreditWithOutPaperPage() {
        objMainPage = new MainPage(webDriver);
        objMainPage.goToCreditWithoutPaper();
    }

    @Test(priority = 1, description = "at CreditWithOutPaperPage set all credential to get CreditWithOutPaper ")
    @Description("at CreditWithOutPaperPage set all credential to get CreditWithOutPaper")
    @Step
    public void setCredentialAndGetPaperWithOutCredit() {
        objCreditWithoutPaperPage = new CreditWithoutPaperPage(webDriver);
        objCreditWithoutPaperPage.applyAndSetCreditCredential();
    }
}
