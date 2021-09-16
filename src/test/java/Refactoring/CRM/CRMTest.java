package Refactoring.CRM;

import Refactoring.WebDriverSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class CRMTest extends WebDriverSettings {
    public static CRMPage crmPage;


    @BeforeEach
    void setUpp() {
        crmPage = PageFactory.initElements(driver, CRMPage.class);
        crmPage.openUrl()
                .fillUserName()
                .fillPassword();
    }
@Test
void positiveLoginTest(){
    Assertions.assertEquals(crmPage.getTitle(), ("Логин"));
    Assertions.assertEquals(crmPage.getUserName(), "Applanatest1");
    Assertions.assertEquals(crmPage.getPassword(), "Student2020!");
    Assertions.assertTrue(crmPage.submit().isDisplayed());
}
    @Test
    void createProjectTest() {
        crmPage.submitClick()
                .projectClick()
                .myProjectClick()
                .createProject()
                .projectName("MyHomeWork")
                .selectOrganization()
                .selectBusinessUnit()
                .selectCurator()
                .selectRp()
                .selectAdministrator()
                .selectManager()
                .selectContactMain()
                .saveCloseClick();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[text()='Проект сохранен']")).isDisplayed());

    }

    @Test
    void createContactTest() {
        crmPage.submitClick()
                .contactPersonClick()
                .createPerson("Alexeev", "Alex", "Director")
                .selectOrganization()
                .saveCloseClick();
        Assertions.assertEquals(driver.findElement(By.className("message")).getText(),
                "Контактное лицо сохранено");
    }
}
