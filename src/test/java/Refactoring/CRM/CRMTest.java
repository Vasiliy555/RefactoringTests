package Refactoring.CRM;

import Refactoring.WebDriverSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class CRMTest extends WebDriverSettings {
    public static CRMTestPage crmTestPage;

    @BeforeEach
    void setUpp() {
        crmTestPage = PageFactory.initElements(driver, CRMTestPage.class);
        crmTestPage.openUrl()
                .fillUserName()
                .fillPassword();
    }

    @Test
    void testProject() {
        Assertions.assertEquals(crmTestPage.getTitle(), ("Логин"));
        Assertions.assertEquals(crmTestPage.getUserName(), "Applanatest1");
        Assertions.assertEquals(crmTestPage.getPassword(), "Student2020!");
        Assertions.assertTrue(crmTestPage.submit().isDisplayed());

        crmTestPage.submitClick()
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
    }

    @Test
    void testContact() {
        crmTestPage.submitClick()
                .contactPersonClick()
                .createPerson("Alexeev", "Alex", "Director")
                .selectOrganization()
                .saveCloseClick();

    }
}
