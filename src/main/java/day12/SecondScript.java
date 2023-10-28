package day12;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class SecondScript {

    public static void main(String[] args) {


        try (
                Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))
        ) {
            Browser.NewPageOptions newPageOptions = new Browser.NewPageOptions();
            Page page = browser.newPage(newPageOptions);

            page.navigate("http://127.0.0.1:5500/FirstPage.html");


            Locator button = page.locator("#demo");

            button.click();
            button.click();
            button.click();
            button.click();
            button.click();

            
//          Accessible Rich Internet Application

            // Button, Link, Img,


        }

    }
}
