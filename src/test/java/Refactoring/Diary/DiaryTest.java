package Refactoring.Diary;

import Refactoring.WebDriverSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class DiaryTest extends WebDriverSettings{
    @BeforeEach
    void setUpp() {
        DiaryTestPage diaryTestPage = PageFactory.initElements(driver, DiaryTestPage.class);

        diaryTestPage.openUrl();
        diaryTestPage.startRegistration();
    }

    @Test
    void diaryNewRegistrationTest() {
        DiaryTestPage diaryTestPage = PageFactory.initElements(driver, DiaryTestPage.class);
        Assertions.assertTrue(driver.getCurrentUrl().contains("registration"));

        diaryTestPage.fillUserName("Qwelollipopiop");
        diaryTestPage.fillEmail("Qwelollipopiop@mail.com");
        diaryTestPage.clickCheckBox();
        Assertions.assertTrue(driver.findElement(By.id("signup_btn")).isDisplayed());
        diaryTestPage.confirmRegistration();
        diaryTestPage.addNewBlogTitle("MyNewBlog");
        diaryTestPage.confirmNewBlogTitle();
        diaryTestPage.selectDropRightMenu();
        diaryTestPage.clickLogout();

    }

    @Test
    void diaryEmptyRegistration() {
        DiaryTestPage diaryTestPage = PageFactory.initElements(driver, DiaryTestPage.class);
        diaryTestPage.confirmRegistration();

        Assertions.assertEquals(diaryTestPage.getUserNameError(),
                "Необходимо заполнить «Логин».");
        Assertions.assertEquals(diaryTestPage.getEmailNameError(),
                "Необходимо заполнить «E-mail».");
    }

    @Test
    void incorrectUserName() {
        DiaryTestPage diaryTestPage = PageFactory.initElements(driver, DiaryTestPage.class);
        diaryTestPage.fillUserName("QweЛОЛ");
        diaryTestPage.fillEmail("aszxcd@gmail.com");
        diaryTestPage.confirmRegistration();

        Assertions.assertEquals(diaryTestPage.getUserNameError(),
                "Использование одновременно русских и латинских символов недопустимо");
    }

    @Test
    void incorrectEmail() {
        DiaryTestPage diaryTestPage = PageFactory.initElements(driver, DiaryTestPage.class);
        diaryTestPage.fillUserName("Qwepopkit");
        diaryTestPage.fillEmail("asdxzc@mail");
        diaryTestPage.confirmRegistration();

        Assertions.assertEquals(diaryTestPage.getEmailNameError(),
                "Значение «E-mail» не является правильным email адресом.");
    }
}
