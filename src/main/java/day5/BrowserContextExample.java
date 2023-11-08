package day5;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class BrowserContextExample {

    public static void main(String[] args) {


        try (
                Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
                BrowserContext context = browser.newContext(new Browser.NewContextOptions())
        ) {




            Page page1 = context.newPage();
            page1.navigate("https://example.test.recognia.com");
            page1.getByPlaceholder("Enter your user ID").fill("TESTAUTOMATION");
            page1.getByPlaceholder("Password").fill("Test1Test23456789!");

            page1.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login").setExact(true)).click();

            Page page2 = context.newPage(); // this will not share the same cookies and information
            page2.navigate("https://example.test.recognia.com");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }



        }
    }
}
