package Refactoring.Diary;

import Refactoring.WebDriverSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;


public class DiaryTest extends WebDriverSettings {
    public static DiaryPage diaryPage;

    @BeforeEach
    void setUpp() {
        diaryPage = PageFactory.initElements(driver, DiaryPage.class);
        diaryPage.openUrl()
        .startRegistration();
    }

    @Test
    void diaryNewRegistrationTest() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("registration"));

        diaryPage.fillUserName("Qwelollipopiop")
                .fillEmail("Qwelollipopiop@mail.com")
                .clickCheckBox();

        Assertions.assertTrue(diaryPage.signUpBtn().isDisplayed());
        diaryPage.confirmRegistration()
                .addNewBlogTitle("MyNewBlog")
                .confirmNewBlogTitle()
                .selectDropRightMenu()
                .clickLogout();
    }

    @Test
    void diaryEmptyRegistration() {
        diaryPage.confirmRegistration();

        Assertions.assertEquals(diaryPage.getUserNameError(),
                "Необходимо заполнить «Логин».");
        Assertions.assertEquals(diaryPage.getEmailNameError(),
                "Необходимо заполнить «E-mail».");
    }

    @Test
    void incorrectUserName() {
        diaryPage.fillUserName("QweЛОЛ")
                .fillEmail("aszxcd@gmail.com")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getUserNameError(),
                "Использование одновременно русских и латинских символов недопустимо");
    }

    @Test
    void incorrectEmail() {
        diaryPage.fillUserName("Qwepopkit")
                .fillEmail("asdxzc@mail")
                .confirmRegistration();

        Assertions.assertEquals(diaryPage.getEmailNameError(),
                "Значение «E-mail» не является правильным email адресом.");
    }

}
