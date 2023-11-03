package day3;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Assertions {


    public static void main(String[] args) {

        try (
                Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setSlowMo(5000).setHeadless(false));
                Page page = browser.newPage();
        ) {

            page.navigate("http://127.0.0.1:5500/ListExample.html");



            // Locator Assertion
            // Page Assertion
            // API Response Assertion
            assertThat(page.getByRole(AriaRole.LISTITEM)).hasCount(2);



        }
    }

}
