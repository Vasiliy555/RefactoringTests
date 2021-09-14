package Refactoring.Diary;

import Refactoring.WebDriverSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;


public class DiaryTest extends WebDriverSettings {
    public static DiaryTestPage diaryTestPage;

    @BeforeEach
    void setUpp() {
        diaryTestPage = PageFactory.initElements(driver, DiaryTestPage.class);
        diaryTestPage.openUrl()
        .startRegistration();
    }

    @Test
    void diaryNewRegistrationTest() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("registration"));

        diaryTestPage.fillUserName("Qwelollipopiop")
                .fillEmail("Qwelollipopiop@mail.com")
                .clickCheckBox();

        Assertions.assertTrue(diaryTestPage.signUpBtn().isDisplayed());
        diaryTestPage.confirmRegistration()
                .addNewBlogTitle("MyNewBlog")
                .confirmNewBlogTitle()
                .selectDropRightMenu()
                .clickLogout();
    }

    @Test
    void diaryEmptyRegistration() {
        diaryTestPage.confirmRegistration();

        Assertions.assertEquals(diaryTestPage.getUserNameError(),
                "Необходимо заполнить «Логин».");
        Assertions.assertEquals(diaryTestPage.getEmailNameError(),
                "Необходимо заполнить «E-mail».");
    }

    @Test
    void incorrectUserName() {
        diaryTestPage.fillUserName("QweЛОЛ")
                .fillEmail("aszxcd@gmail.com")
                .confirmRegistration();

        Assertions.assertEquals(diaryTestPage.getUserNameError(),
                "Использование одновременно русских и латинских символов недопустимо");
    }

    @Test
    void incorrectEmail() {
        diaryTestPage.fillUserName("Qwepopkit")
                .fillEmail("asdxzc@mail")
                .confirmRegistration();

        Assertions.assertEquals(diaryTestPage.getEmailNameError(),
                "Значение «E-mail» не является правильным email адресом.");
    }

}
