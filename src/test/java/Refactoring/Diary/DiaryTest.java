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

        diaryTestPage.fillUserName("Qwelollipopiop")
        .fillEmail("Qwelollipopiop@mail.com")
        .clickCheckBox();
        Assertions.assertTrue(driver.findElement(By.id("signup_btn")).isDisplayed());
        diaryTestPage.confirmRegistration()
        .addNewBlogTitle("MyNewBlog")
        .confirmNewBlogTitle()
        .selectDropRightMenu()
        .clickLogout();
    }

    @Test
    void diaryEmptyRegistration() {
        var myDiaryTest = new DiaryTestPage(driver)
        .confirmRegistration();

        Assertions.assertEquals(myDiaryTest.getUserNameError(),
                "Необходимо заполнить «Логин».");
        Assertions.assertEquals(myDiaryTest.getEmailNameError(),
                "Необходимо заполнить «E-mail».");
    }

    @Test
    void incorrectUserName() {
        var myDiaryTest = new DiaryTestPage(driver)
        .fillUserName("QweЛОЛ")
        .fillEmail("aszxcd@gmail.com")
        .confirmRegistration();

        Assertions.assertEquals(myDiaryTest.getUserNameError(),
                "Использование одновременно русских и латинских символов недопустимо");
    }

    @Test
    void incorrectEmail() {
        var myDiaryTest = new DiaryTestPage(driver)
        .fillUserName("Qwepopkit")
        .fillEmail("asdxzc@mail")
        .confirmRegistration();

        Assertions.assertEquals(myDiaryTest.getEmailNameError(),
                "Значение «E-mail» не является правильным email адресом.");
    }

}
