package day3;

import com.microsoft.playwright.*;

public class HttpStatusCodes {

    public static void main(String[] args) {

        // 1xx -> information
        // 2xx -> success *
        // 3xx -> redirectional
        // 4xx -> client error *
        // 5xx -> server error *

        try (
                Playwright playwright = Playwright.create();
                Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true))
        ) {
            Page page = browser.newPage();
//            Response response = page.navigate("https://tradingcentral.com/thisurldoesnotexist");
            Response response = page.navigate("https://tradingcentral.com");
            System.out.println(response.status());
            System.out.println(response.allHeaders());
            System.out.println(response.serverAddr().ipAddress);




        }
    }
}
