package com.epam.ari_kaczmarek.steps;

import static org.junit.Assert.assertTrue;

import com.epam.ari_kaczmarek.pages.EditProfilePage;
import com.epam.ari_kaczmarek.pages.ProfilePage;
import com.microsoft.playwright.Page;

public class EditProfileSummaryStep extends TestStep {
    private final String newSummary;
    private final int maxAttempts;
    public EditProfileSummaryStep(Page page, String newSummary, int attempts) {
        super(page);
        this.newSummary = newSummary;
        maxAttempts = attempts;
    }

    @Override
    public void execute() {
        var profilePage = new ProfilePage(page);
        profilePage.clickEditProfileButton();
        var editProfilePage = new EditProfilePage(page);
        editProfilePage.fillSummaryTextArea(newSummary);
        boolean updatedSuccessfully = false;
        for(int i=0; (!updatedSuccessfully && i<maxAttempts); i++) {
            // The page is more likely to throw an error if this wait is not performed
            try { Thread.sleep(2000L); } catch(InterruptedException e) {}
            editProfilePage.clickSaveButton();
            // the save button refresh indicates that the save operation is complete
            editProfilePage.waitForSaveButtonRefresh();
            updatedSuccessfully = !editProfilePage.checkForError();
        }
        assertTrue("Failed to update profile after " + maxAttempts + " attempts", updatedSuccessfully);
    }
}
