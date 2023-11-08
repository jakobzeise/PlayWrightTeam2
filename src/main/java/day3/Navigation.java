package day3;

import com.microsoft.playwright.*;

public class Navigation {


    public static void main(String[] args) {


        try (
                Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))
        ) {
            Page page = browser.newPage();
            page.navigate("https://tradingcentral.com");
            page.navigate("https://google.com");
            Response response = page.goBack();
            System.out.println(response.status());

            // goBack()
            // goForward()
            // reload()


        }
    }

}
