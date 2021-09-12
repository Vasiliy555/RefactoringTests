package Refactoring.Diary;


import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.PortUnreachableException;

public class DiaryTestPage {
    private WebDriver driver;

    public DiaryTestPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
@FindBy(linkText = "Регистрация")
private WebElement registration;
    @FindBy(id = "signupform-username")
    private WebElement username;


    public void openUrl() {
        driver.get("https://diary.ru/");
    }
    public void startRegistration(){
        registration.click();
    }
    public void userName(String name){
        username.sendKeys(name);
    }

}
