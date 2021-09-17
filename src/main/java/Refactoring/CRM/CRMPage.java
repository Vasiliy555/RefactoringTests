package Refactoring.CRM;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class CRMPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CRMPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        this.driver = driver;
    }

    //Project Locators
    @FindBy(name = "_username")
    private WebElement userName;

    @FindBy(name = "_password")
    private WebElement password;

    @FindBy(css = ".title")
    private WebElement title;

    @FindBy(id = "_submit")
    private WebElement submit;

    @FindBy(linkText = "Проекты")
    private WebElement project;

    @FindBy(xpath = "//span[contains(.,'Мои проекты')]")
    private WebElement myProject;

    @FindBy(linkText = "Создать проект")
    private WebElement createProject;

    @FindBy(name = "crm_project[name]")
    private WebElement projectName;

    @FindBy(xpath = "//span[contains(text(),'Укажите организацию')]")
    private WebElement organization;

    @FindBy(xpath = "//div[contains(text(),'Alya')]")
    private WebElement selectOrganization;

    @FindBy(name = "crm_project[businessUnit]")
    private WebElement businessUnit;

    @FindBy(name = "crm_project[curator]")
    private WebElement curator;

    @FindBy(name = "crm_project[rp]")
    private WebElement rp;

    @FindBy(name = "crm_project[administrator]")
    private WebElement administrator;

    @FindBy(name = "crm_project[manager]")
    private WebElement manager;

    @FindBy(xpath = "//select[@name=\"crm_project[contactMain]\"]")
    private WebElement contactMain;

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    private WebElement saveClose;

    //Contact Locators
    @FindBy(linkText = "Контрагенты")
    private WebElement contrAgent;

    @FindBy(linkText = "Контактные лица")
    private WebElement contact;

    @FindBy(linkText = "Создать контактное лицо")
    private WebElement createPerson;

    @FindBy(name = "crm_contact[lastName]")
    private WebElement setLastName;
    @FindBy(name = "crm_contact[firstName]")
    private WebElement setFirstName;
    @FindBy(name = "crm_contact[jobTitle]")
    private WebElement setJobTitle;

    //Project
    @Step("Open https://crm.geekbrains.space/user/login")
    public CRMPage openUrl() {
        driver.get("https://crm.geekbrains.space/user/login");
        return this;
    }

    @Step("UserName = Applanatest1")
    public CRMPage fillUserName() {
        userName.sendKeys("Applanatest1");
        return this;
    }

    @Step("Password = Student2020!")
    public CRMPage fillPassword() {
        password.sendKeys("Student2020!");
        return this;
    }

    @Step("click submit")
    public CRMPage submitClick() {
        submit.click();
        return this;
    }

    @Step("click project")
    public CRMPage projectClick() {
        project.click();
        return this;
    }

    @Step("click myProject")
    public CRMPage myProjectClick() {
        myProject.click();
        return this;
    }

    @Step("click create project")
    public CRMPage createProject() {
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.linkText("Создать проект"))));
        createProject.click();

        return this;
    }

    @Step("set project name {0}")
    public CRMPage projectName(String name) {
        Random random = new Random();
        int n = random.nextInt(100) + 1;
        projectName.sendKeys(name + n);
        return this;
    }

    @Step("select organization")
    public CRMPage selectOrganization() {
        organization.click();
        selectOrganization.click();
        return this;
    }

    @Step("select BusinessUnit")
    public CRMPage selectBusinessUnit() {
        businessUnit.findElement(By.xpath("//option[. = 'Research & Development']")).click();
        return this;
    }

    @Step("select curator")
    public CRMPage selectCurator() {
        curator.findElement(By.xpath("//option[. = 'Юзеров Юзер']")).click();
        return this;
    }

    @Step("select rp")
    public CRMPage selectRp() {
        rp.findElement(By.xpath("//option[. = 'Корыстин Василий']")).click();
        return this;
    }

    @Step("select administrator")
    public CRMPage selectAdministrator() {
        administrator.findElement(By.xpath("//option[. = 'Ямутина Вера']")).click();
        return this;
    }

    @Step("select manager")
    public CRMPage selectManager() {
        Select selectObject = new Select(manager);
        selectObject.selectByVisibleText("Чернецкий Евгений");
        return this;
    }

    @Step("select contact main")
    public CRMPage selectContactMain() {
        Select selectContact = new Select(contactMain);
        selectContact.selectByVisibleText("Иванов Петр");
        return this;
    }

    @Step("click save and close")
    public CRMPage saveCloseClick() {
        saveClose.click();
        return this;
    }

    //Contact
    @Step("click contact")
    public CRMPage contactPersonClick() {
        contrAgent.click();
        contact.click();
        return this;
    }

    @Step("create person {0} {1} {2}")
    public CRMPage createPerson(String lastName, String firstName, String jobTitle) {
        createPerson.click();
        setLastName.sendKeys(lastName);
        setFirstName.sendKeys(firstName);
        setJobTitle.sendKeys(jobTitle);
        return this;
    }


    //getAssertions
    public String getTitle() {
        return title.getText();
    }

    @Step("get user name")
    public String getUserName() {
        return userName.getAttribute("value");
    }

    @Step("get password")
    public String getPassword() {
        return password.getAttribute("value");
    }

    public WebElement submit() {
        return submit;

    }
}
