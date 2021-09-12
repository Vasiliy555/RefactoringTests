package Refactoring.Diary;


import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.PortUnreachableException;
import java.util.Random;

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

    @FindBy(id = "signupform-email")
    private WebElement email;

    @FindBy(id = "chk_box_user_confirm")
    private WebElement checkBox;

    @FindBy(id = "signup_btn")
    private WebElement confirmRegistration;

    @FindBy(id = "newblogform-title")
    private WebElement newBlog;

    @FindBy(name = "new-blogs-button")
    private WebElement confirmBlog;

    @FindBy(id = "drop_right_menu")
    private WebElement dropRightMenu;

    @FindBy(linkText = "Выход")
    private WebElement logout;


    public void openUrl() {
        driver.get("https://diary.ru/");
    }

    public void startRegistration() {
        registration.click();
    }

    public void fillUserName(String name) {
        username.sendKeys(name + random());
    }

    public void fillEmail(String mailName, String mailAddress) {
        email.sendKeys(mailName + random() + mailAddress);
    }

    public int random() {
        Random random = new Random();
        int n = random.nextInt(100) + 1;
        return n;
    }
    public void clickCheckBox(){
        checkBox.click();
    }
    public void confirmRegistration(){
        confirmRegistration.click();
    }
    public void addNewBlogTitle(String blogTitle){
        newBlog.sendKeys(blogTitle);
    }
    public void confirmNewBlogTitle(){
        confirmBlog.click();
    }
    public void selectDropRightMenu(){
        dropRightMenu.click();
    }
    public void clickLogout(){
        logout.click();
    }

}
