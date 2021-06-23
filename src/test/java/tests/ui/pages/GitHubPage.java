package tests.ui.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubPage {

    public GitHubPage openPage(String url) {
        open(url);
        return this;
    }

    public GitHubPage clickOpenFeaturePage() {
        Selenide.sleep(5000);
        $(".HeaderMenu-summary", 0).click();
        $(".py-2").shouldHave(text("Features")).click();
       return this;
    }

    public GitHubPage clickOpenShopPage() {
        Selenide.sleep(5000);
        $(byText("Shop")).click();
        return this;
    }

    public GitHubPage search(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").val(repository).pressEnter();
        return this;
    }

    public GitHubPage goToRepository(String repository) {
        $(By.linkText(repository)).click();
        return this;
    }

    public GitHubPage checkOpenedIssue(String tab) {
        $(withText(tab)).click();
        $(".blankslate h3").shouldHave(text("Welcome to issues!"));
        return this;
    }

    public GitHubPage checkOpenedFeaturePage() {
        $(".h1-mktg").shouldHave(text("The tools you need to build what you want."));
        return this;
    }

    public GitHubPage clickButtonShop() {
        $(".butt .green").click();
        return this;
    }
    public GitHubPage checkOpenedShopPage() {
        $(".brand").shouldBe(visible);
        return this;
    }
}
