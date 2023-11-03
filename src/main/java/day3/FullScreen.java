package day3;

import com.microsoft.playwright.*;

import java.util.ArrayList;

public class FullScreen {


    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions()
                .setChannel("chrome")
                .setHeadless(false)
                .setArgs(arguments);

        Browser browser = playwright
                .chromium()
                .launch(launchOptions);

        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions().setViewportSize(null);
        BrowserContext context = browser.newContext(contextOptions);

        context.newPage();

    }

}
