import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.awt.*;
import java.nio.file.Path;
import java.nio.file.Paths;
public class ExampleSite {
    private static final String username = "TESTAUTOMATION";
    private static final String password = "Test1Test23456789!";
    public static void main(String[] args) throws InterruptedException{

        try (Playwright playwright = Playwright.create();
             Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
             //Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        ) {
            Browser.NewPageOptions newPageOptionss = new Browser.NewPageOptions();
            Page page = browser.newPage(newPageOptionss);
            //page.setViewportSize(new ViewportSize(1920, 1080));
            // navigate to example site and input username and password
            page.navigate("https://example.test.recognia.com/serve.shtml?page=login");
            page.getByPlaceholder("Enter your user ID").fill(username);
            page.getByPlaceholder("Password").fill(password);
            page.evaluate("document.querySelector(\"input[type='submit'][value='Login']\").click()");
            page.waitForSelector("input[type='submit'][value='Login']");
            page.click("input[type='submit'][value='Login']");

            browser.close();

        }
    }
}
