package day5;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.RecordVideoSize;

import java.nio.file.Path;
import java.nio.file.Paths;

public class VideoExample {

    public static void main(String[] args) {


        Path videoPath = Paths.get("./videos");
        RecordVideoSize recordVideoSize = new RecordVideoSize(1920, 1080);
        Browser.NewContextOptions newContextOptions = new Browser.NewContextOptions().setRecordVideoDir(videoPath).setRecordVideoSize(1920, 1080);
        try (
                Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
                BrowserContext context = browser.newContext(newContextOptions);
                Page page = context.newPage()
        ) {

            page.navigate("https://example.test.recognia.com");

            page.getByPlaceholder("Enter your user ID").fill("TESTAUTOMATION");
            page.getByPlaceholder("Password").fill("Test1Test23456789!");

            //Screenshots
            Locator loginButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login").setExact(true));
            Path path = Paths.get("./screenshots/loginButton.png");
            loginButton.screenshot(new Locator.ScreenshotOptions().setPath(path));

            loginButton.click();

            Path path1 = Paths.get("./video/test.mp4");


            Page page2 = context.newPage();
            page2.navigate("https://wikipedia.org");

            page.close();

            page.video().saveAs(path1);

            page.video().delete();
            page2.video().delete();




        }



    }
}
