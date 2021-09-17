package Refactoring.Diary;

import Refactoring.WebDriverSettings;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

@Epic("TESTING FOR https://diary.ru/")
public class DiaryTest extends WebDriverSettings {
    public static DiaryPage diaryPage;

    @BeforeEach
    void setUpp() {
        diaryPage = PageFactory.initElements(driver, DiaryPage.class);
        diaryPage.openUrl()
                .startRegistration();
    }

    @Test
    void newRegistrationTest() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("registration"));
    }

    @Test
    void positiveRegistrationTest() {
        diaryPage.fillUserName("LollipopSet")
                .fillEmail("Qwelollipopiop@mail.com")
                .clickCheckBox();

        Assertions.assertTrue(diaryPage.signUpBtn().isDisplayed());
        diaryPage.confirmRegistration()
                .selectDropRightMenu()
                .clickLogout();
    }

    @Test
    void addNewBlogTest() {
        diaryPage.fillUserName("LollipopSet")
                .fillEmail("Qwelollipopiop@mail.com")
                .clickCheckBox()
                .confirmRegistration()
                .addNewBlogTitle("MyNewBlog")
                .confirmNewBlogTitle();
        Assertions.assertTrue(driver.findElement(By.linkText("MyNewBlog")).isDisplayed());
        diaryPage.selectDropRightMenu()
                .clickLogout();
    }

    @Test
    void emptyLoginTest() {
        diaryPage.fillEmail("Qwelollipopiop@mail.com")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getUserNameError(),
                "Необходимо заполнить «Логин».");
    }

    @Test
    void emptyEmailTest() {
        diaryPage.fillUserName("JIkinio")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getEmailNameError(),
                "Необходимо заполнить «E-mail».");
    }

    @Test
    void incorrectUserNameTest() {
        diaryPage.fillUserName("QweЛОЛ")
                .fillEmail("aszxcd@gmail.com")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getUserNameError(),
                "Использование одновременно русских и латинских символов недопустимо");
    }

    @Test
    void incorrectEmailTest() {
        diaryPage.fillUserName("SimpleKit")
                .fillEmail("asdxzc@mail")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getEmailNameError(),
                "Значение «E-mail» не является правильным email адресом.");
    }


}
