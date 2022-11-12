package com.test;

import com.pages.Homepage;
import core.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    private Homepage homepage;

    @Test(description = "Verify the google homepage logo is displayed", priority = 1)
    public void homepageLogo() {
        homepage = new Homepage(webDriver);

        Assert.assertTrue(homepage.getGoogleLogo().isDisplayed());
    }
}
