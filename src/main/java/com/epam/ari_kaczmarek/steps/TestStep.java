package com.epam.ari_kaczmarek.steps;

import com.microsoft.playwright.Page;

public abstract class TestStep {
    protected Page page;
    public TestStep(Page page) {
        this.page = page;
    }
    public abstract void execute();
}
