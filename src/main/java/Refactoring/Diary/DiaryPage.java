package Refactoring.Diary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

    public class DiaryPage {
        private WebDriver driver;

    public DiaryPage(WebDriver driver) {
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


    public DiaryPage openUrl() {
        driver.get("https://diary.ru/");
        return this;
    }

    public DiaryPage startRegistration() {
        registration.click();
        return this;
    }

    public DiaryPage fillUserName(String name) {
        userName.sendKeys(name + random());
        return this;
    }

    public DiaryPage fillEmail(String mailAddress) {
        email.sendKeys(random() + mailAddress);
        return this;
    }

    public int random() {
        Random random = new Random();
        int n = random.nextInt(100) + 1;
        return n;
    }

    public DiaryPage clickCheckBox() {
        checkBox.click();
        return this;
    }

    public DiaryPage confirmRegistration() {
        confirmRegistration.click();
        return this;
    }

    public DiaryPage addNewBlogTitle(String blogTitle) {
        newBlog.sendKeys(blogTitle);
        return this;
    }

    public DiaryPage confirmNewBlogTitle() {
        confirmBlog.click();
        return this;
    }

    public DiaryPage selectDropRightMenu() {
        dropRightMenu.click();
        return this;
    }

    public DiaryPage clickLogout() {
        logout.click();
        return this;
    }

    public WebElement signUpBtn() {
        return confirmRegistration;
    }

//    Errors

    public String getUserNameError() {
        WebElement userNameParent = userName.findElement(By.xpath(".."));
        return userNameParent.findElement(By.cssSelector("p")).getText();
    }

    public String getEmailNameError() {
        WebElement emailNameParent = email.findElement(By.xpath(".."));
        return emailNameParent.findElement(By.cssSelector("p")).getText();
    }

}
