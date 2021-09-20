package Refactoring.Diary;

import Refactoring.WebDriverSettings;
import io.qameta.allure.Epic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("Переход на страницу регистрации")
    @Test
    void newRegistrationTest() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("registration"));
    }
    @DisplayName("Успешная регистрация нового пользователя")
    @Test
    void positiveRegistrationTest() {
        diaryPage.fillUserName("LollipopSetStitch")
                .fillEmail("QwelollipopiopStitch@mail.com")
                .clickCheckBox();

        Assertions.assertTrue(diaryPage.signUpBtn().isDisplayed());
        diaryPage.confirmRegistration()
                .selectDropRightMenu()
                .clickLogout();
    }
    @DisplayName("Регистрация и создания дневника")
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
    @DisplayName("Регистрация с пустым полем логина")
    @Test
    void emptyLoginTest() {
        diaryPage.fillEmail("Qwelollipopiop@mail.com")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getUserNameError(),
                "Необходимо заполнить «Логин».");
    }
    @DisplayName("Регистрация с пустым полем email")
    @Test
    void emptyEmailTest() {
        diaryPage.fillUserName("JIkinio")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getEmailNameError(),
                "Необходимо заполнить «E-mail».");
    }
    @DisplayName("Регистрация с некорректным полем логина")
    @Test
    void incorrectUserNameTest() {
        diaryPage.fillUserName("QweЛОЛ")
                .fillEmail("aszxcd@gmail.com")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getUserNameError(),
                "Использование одновременно русских и латинских символов недопустимо");
    }
    @DisplayName("Регистрация с некорректным полем email")
    @Test
    void incorrectEmailTest() {
        diaryPage.fillUserName("SimpleKit")
                .fillEmail("asdxzc")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getEmailNameError(),
                "Значение «E-mail» не является правильным email адресом.");
    }


}
