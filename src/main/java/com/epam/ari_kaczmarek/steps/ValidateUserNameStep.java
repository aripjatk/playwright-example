package com.epam.ari_kaczmarek.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ari_kaczmarek.pages.HomePage;
import com.microsoft.playwright.Page;

public class ValidateUserNameStep extends TestStep {
    private final String expectedUserName;
    private static Logger logger = LogManager.getLogger(ValidateUserNameStep.class);

    public ValidateUserNameStep(Page page, String expectedUserName) {
        super(page);
        this.expectedUserName = expectedUserName;
    }

    @Override
    public void execute() {
        var homePage = new HomePage(page);
        logger.debug("Attempting to obtain logged-in user name");
        String actualUserName;
        try {
            actualUserName = homePage.getLoggedInUserName();
        } catch(Throwable t) {
            logger.error("Failed to obtain logged-in user name (user may not be logged in)", t);
            throw t;
        }
        logger.info("Expected user name: " + expectedUserName);
        logger.info("Actual user name: " + actualUserName);
        try {
            assertTrue(
                actualUserName.contains(expectedUserName),
                "Expected user name to contain: " + expectedUserName + " but was: " + actualUserName
            );
            logger.info("User name validation successful");
        } catch (AssertionError e) {
            logger.error("User name validation failed", e);
            throw e;
        }
    }
}
