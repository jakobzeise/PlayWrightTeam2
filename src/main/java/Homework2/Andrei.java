package Homework2;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

import java.nio.file.Paths;

public class Andrei {
    private static final String password = "Test1Test23456789!";
    private static final String username = "TESTAUTOMATION";
    public static void main(String[] args){
        try (Playwright playwright = Playwright.create(); Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(300)) ) {
            //Create Page
            Page page = browser.newPage();

            //Navigate to TradingCentral
            page.navigate("https://example.test.recognia.com/serve.shtml?page=login");

            //Fill in the username
            page.getByPlaceholder("Enter your user ID").fill(username);

            //Fill in the password & Sign in
            page.getByPlaceholder("Password").fill(password);
            page.getByText("Login").click();

            //Click on 'Products' dropdown
            page.getByRole(AriaRole.BUTTON).getByText("Products").click();

            //Click on 'Market Buzz'
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Market Buzz").setExact(true)).click();

            //Search for 'AAPL' and click it
            page.getByPlaceholder("Enter Symbol or Name").fill("AAPL");
            page.getByText("Apple Inc").click();

            //Click on 'Sentiment' tab

            page.getByText("Sentiment", new Page.GetByTextOptions().setExact(true)).click();

            //Double click on Sentiment signal arrow
            page.locator("svg[width='60']").dblclick();

            //Screenshot
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("sentiment.png")).setFullPage(true));
        }
    }
}
