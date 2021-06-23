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

    public GitHubPage clickOpenTeamPage() {
        $(".HeaderMenu-link", 1).click();
       return this;
    }

    public GitHubPage clickOpenShopPage() {
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

    public GitHubPage checkOpenedTeamPage() {
        $(".h1-mktg").shouldHave(text("Build like the best teams on the planet"));
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
