package Refactoring.Diary;

import Refactoring.WebDriverSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
    void newRegistrationTest() {
        Assertions.assertTrue(driver.getCurrentUrl().contains("registration"));
    }
    @Test
    void positiveRegistrationTest(){
        diaryPage.fillUserName("LollipopS")
                .fillEmail("Qwelollipopiop@mail.com")
                .clickCheckBox();

        Assertions.assertTrue(diaryPage.signUpBtn().isDisplayed());
        diaryPage.confirmRegistration();
    }

    @Test
    void addNewBlogTest(){
        positiveRegistrationTest();
         diaryPage.addNewBlogTitle("MyNewBlog")
                .confirmNewBlogTitle()
                .selectDropRightMenu();
        Assertions.assertTrue(driver.findElement(By.linkText("MyNewBlog")).isDisplayed());
                diaryPage.clickLogout();
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
