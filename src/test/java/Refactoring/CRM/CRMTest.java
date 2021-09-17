package Refactoring.CRM;

import Refactoring.WebDriverSettings;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Epic("TESTING FOR https://crm.geekbrains.space")
public class CRMTest extends WebDriverSettings {
    public static CRMPage crmPage;

    @BeforeEach
    void setUpp() {
        crmPage = PageFactory.initElements(driver, CRMPage.class);
        crmPage.openUrl()
                .fillUserName()
                .fillPassword();
    }

    @DisplayName("Проверка входа под логином")
    @Severity(SeverityLevel.CRITICAL)
    @Description("В этом тесте мы заходим на сайт под зарегистрированным пользователем")
    @Test
    void positiveLoginTest() {
        Assertions.assertEquals(crmPage.getTitle(), ("Логин"));
        Assertions.assertEquals(crmPage.getUserName(), "Applanatest1");
        Assertions.assertEquals(crmPage.getPassword(), "Student2020!");
        Assertions.assertTrue(crmPage.submit().isDisplayed());
        crmPage.submitClick();
    }

    @DisplayName("Создание проекта")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проходим все этапы создания и сохранения нового проекта")
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
        Assertions.assertEquals(driver.findElement(By.className("message")).getText(),
                "Проект сохранен");
    }

    @DisplayName("Создание контакта")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проходим все этапы создания и сохранения нового контактного лица")
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
