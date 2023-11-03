package day4;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class DialogExample {

    public static void main(String[] args) {

        try (
                Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false))
        ) {
            Page page = browser.newPage();
            page.navigate("https://letcode.in/alert");

            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Consent").setExact(true)).click();


            // onceDialog -> one dialog
            // oneDialog -> all dialogs
            page.onDialog(dialog -> {
                sleep(2);
                System.out.println("I am in the dialog");
                dialog.accept();
            });


            Locator simpleAlert = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Simple Alert").setExact(true));
            simpleAlert.click();
            simpleAlert.click();

        }
    }

    public static void sleep(int s) {
        try {
            Thread.sleep(s * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}