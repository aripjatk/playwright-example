package com.epam.ari_kaczmarek.pages;

import org.apache.logging.log4j.LogManager;

import com.microsoft.playwright.Page;

public abstract class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
        var subclass = this.getClass();
        var logger = LogManager.getLogger(subclass);
        logger.debug("Opening " + subclass.getSimpleName());
    }
}
