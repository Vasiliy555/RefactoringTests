package Refactoring.Diary;

import Refactoring.WebDriverSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        diaryTestPage.fillUserName("Qwelollipop");
        diaryTestPage.fillEmail("Qwelollipop","@mail.com");
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
//        driver.findElement(By.id("signup_btn")).click();


        WebElement userName = driver.findElement(By.id("signupform-username"));
        WebElement userNameParent = userName.findElement(By.xpath(".."));
        Assertions.assertEquals(userNameParent.findElement(By.cssSelector("p")).getText(),
                "Необходимо заполнить «Логин».");

        WebElement emailName = driver.findElement(By.id("signupform-email"));
        WebElement emailNameParent = emailName.findElement(By.xpath(".."));
        Assertions.assertEquals(emailNameParent.findElement(By.cssSelector("p")).getText(),
                "Необходимо заполнить «E-mail».");
    }

    @Test
    void incorrectUserName() {
        driver.findElement(By.id("signupform-username")).sendKeys("QweЛоЛ");
        driver.findElement(By.id("signupform-email")).sendKeys(("asd@gmail.com"));
        driver.findElement(By.id("signup_btn")).click();
        WebElement userName = driver.findElement(By.id("signupform-username"));
        WebElement userNameParent = userName.findElement(By.xpath(".."));
        Assertions.assertEquals(userNameParent.findElement(By.cssSelector("p")).getText(),
                "Использование одновременно русских и латинских символов недопустимо");
    }

    @Test
    void incorrectEmail() {
        driver.findElement(By.id("signupform-username")).sendKeys("Qwetyunonl");
        driver.findElement(By.id("signupform-email")).sendKeys(("asd@gmail"));
        driver.findElement(By.id("signup_btn")).click();
        WebElement emailName = driver.findElement(By.id("signupform-email"));
        WebElement emailNameParent = emailName.findElement(By.xpath(".."));
        Assertions.assertEquals(emailNameParent.findElement(By.cssSelector("p")).getText(),
                "Значение «E-mail» не является правильным email адресом.");
    }
}
