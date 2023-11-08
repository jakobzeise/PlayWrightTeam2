package day5;

import com.microsoft.playwright.*;

public class AuthenticationExample {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));

        Browser.NewContextOptions newContextOptions = new Browser.NewContextOptions().setHttpCredentials("admin", "admin");
        BrowserContext context = browser.newContext(newContextOptions);



        Page page = context.newPage();
        page.navigate("https://the-internet.herokuapp.com/basic_auth");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
