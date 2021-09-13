package Refactoring.Diary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class DiaryTestPage {
    private WebDriver driver;

    public DiaryTestPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(linkText = "Регистрация")
    private WebElement registration;

    @FindBy(id = "signupform-username")
    private WebElement userName;

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

    public DiaryTestPage startRegistration() {
        registration.click();
        return this;
    }

    public DiaryTestPage fillUserName(String name) {
        userName.sendKeys(name + random());
        return this;
    }

    public DiaryTestPage fillEmail(String mailAddress) {

        email.sendKeys(random() + mailAddress);
        return this;
    }

    public int random() {
        Random random = new Random();
        int n = random.nextInt(100) + 1;
        return n;
    }

    public DiaryTestPage clickCheckBox() {
        checkBox.click();
        return this;
    }

    public DiaryTestPage confirmRegistration() {
        confirmRegistration.click();
        return this;
    }

    public DiaryTestPage addNewBlogTitle(String blogTitle) {
        newBlog.sendKeys(blogTitle);
        return this;
    }

    public DiaryTestPage confirmNewBlogTitle() {
        confirmBlog.click();
        return this;
    }

    public DiaryTestPage selectDropRightMenu() {
        dropRightMenu.click();
        return this;
    }

    public DiaryTestPage clickLogout() {
        logout.click();
        return this;
    }

//    Errors

    public String getUserNameError(){
        WebElement userNameParent = userName.findElement(By.xpath(".."));
        return userNameParent.findElement(By.cssSelector("p")).getText();
    }

    public String getEmailNameError(){
        WebElement emailNameParent = email.findElement(By.xpath(".."));
        return emailNameParent.findElement(By.cssSelector("p")).getText();
    }

}
