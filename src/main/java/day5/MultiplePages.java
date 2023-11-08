package day5;

import com.microsoft.playwright.*;

import java.util.ArrayList;
import java.util.List;

public class MultiplePages {

    public static void main(String[] args) {


        try (
                Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(2000));
                BrowserContext context = browser.newContext(new Browser.NewContextOptions())
        ) {

            List<Page> pages = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                pages.add(browser.newPage());
            }

            pages.forEach(page -> page.navigate("https://wikipedia.org"));


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

