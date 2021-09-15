package Refactoring.CRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CRMPage {
    private WebDriver driver;

    public CRMPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    //Project Locators
    @FindBy(name = "_username")
    private WebElement userName;

    @FindBy(name = "_password")
    private WebElement password;

    @FindBy(css =".title" )
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
    @FindBy (linkText = "Контрагенты")
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
    public CRMPage openUrl() {
        driver.get("https://crm.geekbrains.space/user/login");
        return this;
    }
    public CRMPage fillUserName(){
        userName.sendKeys("Applanatest1");
        return this;
    }

    public CRMPage fillPassword(){
        password.sendKeys("Student2020!");
        return this;
    }
    public CRMPage submitClick(){
        submit.click();
        return this;
    }
    public CRMPage projectClick(){
        project.click();
        return this;
    }
    public CRMPage myProjectClick(){
        myProject.click();
        return this;
    }
    public CRMPage createProject(){
        createProject.click();
        return this;
    }
    public CRMPage projectName(String name){
        Random random = new Random();
        int n = random.nextInt(100) + 1;
        projectName.sendKeys(name + n);
        return this;
    }

    public CRMPage selectOrganization(){
        organization.click();
        selectOrganization.click();
        return this;
    }
    public CRMPage selectBusinessUnit(){
        businessUnit.findElement(By.xpath("//option[. = 'Research & Development']")).click();
        return this;
    }
    public CRMPage selectCurator(){
        curator.findElement(By.xpath("//option[. = 'Юзеров Юзер']")).click();
        return this;
    }
    public CRMPage selectRp(){
        rp.findElement(By.xpath("//option[. = 'Корыстин Василий']")).click();
        return this;
    }
    public CRMPage selectAdministrator(){
        administrator.findElement(By.xpath("//option[. = 'Ямутина Вера']")).click();
        return this;
    }
    public CRMPage selectManager(){
        Select selectObject = new Select(manager);
        selectObject.selectByVisibleText("Чернецкий Евгений");
        return this;
    }
    public CRMPage selectContactMain(){
        Select selectContact = new Select(contactMain);
        selectContact.selectByVisibleText("Иванов Петр");
        return this;
    }
    public CRMPage saveCloseClick(){
        saveClose.click();
        return this;
    }
    //Contact
    public CRMPage contactPersonClick() {
        contrAgent.click();
        contact.click();
        return this;
    }

    public CRMPage createPerson(String lastName, String  firstName, String jobTitle){
        createPerson.click();
        setLastName.sendKeys(lastName);
        setFirstName.sendKeys(firstName);
        setJobTitle.sendKeys(jobTitle);
        return this;
    }


    //getAssertions
    public String  getTitle(){
        return title.getText();
    }
    public String getUserName(){
        return userName.getAttribute("value");
    }
    public String getPassword(){
        return password.getAttribute("value");
    }

    public WebElement submit(){
        return submit;

    }
}
