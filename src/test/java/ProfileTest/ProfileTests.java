package ProfileTest;

import base.BaseTest;
import constants.dataproviders.LoginData;
import constants.locators.IMDbDashboardConstants;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.common.IMDbDashboardPage;
import pages.common.IMDbLoginPage;
import pages.common.IMDbProfilePage;

import static base.BaseTest.driver;
import static base.BaseTest.homePage;
import static constants.locators.IMDbDashboardConstants.Dashboard_URL;
import static constants.locators.IMDbProfilePageConstants.QRImageSrc;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfileTests extends BaseTest {

    //Changed duration of seconds in explicit wait fixed the problem
    @Test
    public void testProfile() {
        IMDbLoginPage loginPage = homePage.clickLogInButton();
        loginPage.login(LoginData.username,LoginData.password);

        IMDbDashboardPage dshBoard = new IMDbDashboardPage(driver);
        dshBoard.getProfileMenu().click();

        IMDbProfilePage profilePage = dshBoard.clickProfileButton();


        WebElement qrButton = profilePage.getQRViewButton();
        qrButton.click();

        WebElement qrImage = driver.findElement(By.xpath("//img[@src='" + profilePage.getQRImageSrc() + "']"));
        assertTrue(qrImage.isDisplayed());

    }

}
