package com.epam.ari_kaczmarek.definitions;

import com.epam.ari_kaczmarek.steps.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.epam.ari_kaczmarek.definitions.PageContext.getPage;

public class ProfileStepDefinitions {

    @And("the user goes to the profile page")
    public void goToProfilePage() {
        new GoToProfileStep(getPage()).execute();
    }

    @And("the user edits the profile summary to {string} with {integer} attempts")
    public void editProfileSummary(String summary, int attempts) {
        new EditProfileSummaryStep(getPage(), summary, attempts).execute();
    }

    @Then("the profile summary should be {string}")
    public void validateProfileSummary(String expectedSummary) {
        new ValidateProfileSummaryEditStep(getPage(), expectedSummary).execute();
    }
}
