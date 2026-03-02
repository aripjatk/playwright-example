package com.epam.ari_kaczmarek;

import com.epam.ari_kaczmarek.steps.*;
import com.epam.reportportal.service.ReportPortal;
import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AppTest {

    private Browser browser;
    private Page page;
    private static Logger logger = LogManager.getLogger();

    private static final String LOGIN_USERNAME = "arkaczmaepam";
    private static final String LOGIN_PASSWORD = "bLx0$gc1";
    private static final String DISPLAYED_USERNAME = "ari_kaczmarek";

    public String description = "Playwright Test";

    private Path screenshot(Page page) {
        var screenshotPath = Paths.get(
            "logs/screenshot-" + System.currentTimeMillis() + ".png"
        );
        page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));
        return screenshotPath.toAbsolutePath();
    }

    @BeforeEach
    public void setUp() {
        browser = Playwright.create()
            .chromium()
            .launch(new LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/credentials.csv", numLinesToSkip = 1)
    public void loginTest(String username, String password, String displayName) {
        logger.info("Commencing login test");
        try {
            new OpenHomePageStep(page).execute();
            new LogInStep(page, username == null ? LOGIN_USERNAME : username,
                password == null ? LOGIN_PASSWORD : password).execute();
            new ValidateUserNameStep(page, 
                displayName == null ? DISPLAYED_USERNAME : displayName
            ).execute();
            logger.info("Login test passed");
            ReportPortal.emitLaunchLog("Login test passed.", "INFO", new Date());
        } catch (Throwable t) {
            var screenshotPath = screenshot(page);
            logger.error("Login test failed. Screenshot saved to: " + screenshotPath);
            ReportPortal.emitLaunchLog("Login test failed.", "ERROR",
                new Date(), screenshotPath.toFile());
            throw t;
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"My Test Summary", "Test"})
    public void editProfileTest(String summary) {
        if(summary == null)
            summary = "Test Summary";
        logger.info("Commencing edit profile test with summary: " + summary);
        try {
            new OpenHomePageStep(page).execute();
            new LogInStep(page, LOGIN_USERNAME, LOGIN_PASSWORD).execute();
            new ValidateUserNameStep(page, DISPLAYED_USERNAME).execute();
            new GoToProfileStep(page).execute();
            int updateAttempts = 5;
            new EditProfileSummaryStep(page, summary, updateAttempts).execute();
            new ValidateProfileSummaryEditStep(page, summary).execute();
            logger.info("Edit profile test passed");
            ReportPortal.emitLaunchLog("Edit profile test passed.", "INFO", new Date());
        } catch (Throwable t) {
            var path = screenshot(page);
            logger.error("Edit profile test failed. Screenshot saved to: " + path);
            ReportPortal.emitLaunchLog("Edit profile test failed.", "ERROR", 
                new Date(), path.toFile());
            throw t;
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"Red Dead Redemption 2", "Portal"})
    public void addToCartTest(String productName) {
        if(productName == null)
            productName = "Red Dead Redemption 2";
        logger.info("Commencing add to cart test for product: " + productName);
        try {
            new OpenHomePageStep(page).execute();
            new LogInStep(page, LOGIN_USERNAME, LOGIN_PASSWORD).execute();
            new ValidateUserNameStep(page, DISPLAYED_USERNAME).execute();
            new ProductSearchStep(page, productName).execute();
            new SelectSearchResultStep(page, productName).execute();
            new AddToCartStep(page, productName).execute();
            new ValidateCartStep(page, productName).execute();
            logger.info("Add to cart test passed");
            ReportPortal.emitLaunchLog("Add to cart test passed.", "INFO", new Date());
        } catch (Throwable t) {
            var path = screenshot(page);
            logger.error("Add to cart test failed. Screenshot saved to: " + path);
            ReportPortal.emitLaunchLog("Add to cart test failed.", "ERROR", 
                new Date(), path.toFile());
            throw t;
        }
    }
}
