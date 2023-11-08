package Homework1;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.nio.file.Paths;

public class Andrei {
    private static final String password = "^i6QleLHQp@l#$QWkvAv6Z50";
    private static final String email = "andrei.mititelu@tradingcentral.com";
    public static void main(String[] args){
        try (Playwright playwright = Playwright.create(); Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)) ) {
            //Create Page
            Page page = browser.newPage();

            //Navigate to Flickr
            page.navigate("https://identity.flickr.com/");

            //Fill in the email address
            page.getByLabel("Email address").fill(email);
            page.getByText("Next").click();

            //Fill in the password & Sign in
            page.getByLabel("Password").fill(password);
            page.getByText("Sign in").click();

            //Close Cookies pop up

            Locator rejectAllButton = page.frameLocator(".truste_popframe").getByText("Reject All");
            rejectAllButton.click();
            Locator closeButton = page.frameLocator(".truste_popframe").getByText("CLOSE");
            closeButton.click();

            //Fill in the search box & search
            page.getByPlaceholder("Photos, people, or groups").fill("parrot");
            Locator searchButton = page.getByLabel("Search").getByRole(AriaRole.BUTTON);
            searchButton.click();

            //Select picture
            Locator selectPicture = page.locator("div.view.photo-list-photo-view.awake:first-of-type");
            selectPicture.click();

            // Click on 'favorite' button
            Locator favoriteButton = page.locator("div.button");
            favoriteButton.click();

            //Screenshot the page
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("bird.png")).setFullPage(true));
        }
    }
}
