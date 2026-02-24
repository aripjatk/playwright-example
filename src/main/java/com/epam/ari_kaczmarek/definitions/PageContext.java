package com.epam.ari_kaczmarek.definitions;

import com.microsoft.playwright.Page;

public class PageContext {
    private static Page page;

    public static void setPage(Page p) {
        page = p;
    }

    public static Page getPage() {
        return page;
    }

    public static void closePage() {
        if (page != null) {
            page.close();
        }
    }
}