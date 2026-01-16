package com.epam.ari_kaczmarek.pages;

import com.microsoft.playwright.Page;

public class CartPage extends BasePage {
    private static final String CART_ITEM_NAME_XPATH = "//div[@id='«r1»']";

    public CartPage(Page page) {
        super(page);
    }
    
    public String getCartItemName() {
        return page.locator(CART_ITEM_NAME_XPATH).innerText();
    }

    public void removeAllItems() {
        page.getByText("Remove all items").click();
    }
}
