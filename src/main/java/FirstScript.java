import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FirstScript {

    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {


            BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(3000);
            Browser browser = playwright.chromium().launch(launchOptions);

            Browser.NewPageOptions newPageOptions = new Browser.NewPageOptions();
            Page page = browser.newPage(newPageOptions);


            page.navigate("https://google.com");

            Path path = Paths.get("google.png");
            Page.ScreenshotOptions screenshotOptions = new Page.ScreenshotOptions().setPath(path).setFullPage(true);
            page.screenshot(screenshotOptions);

            System.out.println(page.title());


            browser.close();


        }

    }

}
