package Refactoring.Diary;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class DiaryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public DiaryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(linkText = "Регистрация")
    WebElement registration;

    @FindBy(id = "signupform-username")
    WebElement userName;

    @FindBy(id = "signupform-email")
    WebElement email;

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
    @Step("Open https://diary.ru/")
    public DiaryPage openUrl() {
        driver.get("https://diary.ru/");
        return this;
    }
    @Step("click registration")
    public DiaryPage startRegistration() {
        registration.click();
        return this;
    }
    @Step("fill login {0}")
    public DiaryPage fillUserName(String name) {
        userName.sendKeys(name + random());
        return this;
    }
    @Step("fill email {0}")
    public DiaryPage fillEmail(String mailAddress) {
        email.sendKeys(random() + mailAddress);
        return this;
    }

    public int random() {
        Random random = new Random();
        int n = random.nextInt(100) + 1;
        return n;
    }
    @Step("click checkbox")
    public DiaryPage clickCheckBox() {
        checkBox.click();
        return this;
    }
    @Step("click confirm registration")
    public DiaryPage confirmRegistration() {
        confirmRegistration.click();
        return this;
    }
    @Step("add new blog title")
    public DiaryPage addNewBlogTitle(String blogTitle) {
        newBlog.sendKeys(blogTitle);
        return this;
    }
    @Step("click confirm create new blog")
    public DiaryPage confirmNewBlogTitle() {
        confirmBlog.click();
        return this;
    }
    @Step("click drop right menu")
    public DiaryPage selectDropRightMenu() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("drop_right_menu")));
        dropRightMenu.click();
        return this;
    }
    @Step("click logout")
    public DiaryPage clickLogout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Выход")));
        logout.click();
        return this;
    }

    public WebElement logout() {
        return logout;
    }

    public WebElement signUpBtn() {
        return confirmRegistration;
    }

    //    Errors
    public String getUserNameError() {
        WebElement userNameParent = userName.findElement(By.xpath(".."));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("registration_form")));
        return userNameParent.findElement(By.cssSelector("p")).getText();
    }

    public String getEmailNameError() {
        WebElement emailNameParent = email.findElement(By.xpath(".."));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("registration_form")));
        return emailNameParent.findElement(By.cssSelector("p")).getText();
    }

}
