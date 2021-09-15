package Refactoring.CRM;

import Refactoring.WebDriverSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    void testProject() {
        Assertions.assertEquals(crmPage.getTitle(), ("Логин"));
        Assertions.assertEquals(crmPage.getUserName(), "Applanatest1");
        Assertions.assertEquals(crmPage.getPassword(), "Student2020!");
        Assertions.assertTrue(crmPage.submit().isDisplayed());

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
    }

    @Test
    void testContact() {
        crmPage.submitClick()
                .contactPersonClick()
                .createPerson("Alexeev", "Alex", "Director")
                .selectOrganization()
                .saveCloseClick();

    }
}
