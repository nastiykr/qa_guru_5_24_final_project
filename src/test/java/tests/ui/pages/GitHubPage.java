package tests.ui.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GitHubPage {

    public GitHubPage openPage(String url) {
        open(url);
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

    public GitHubPage checkData(String tab) {
        $(withText(tab)).click();
        $(".blankslate h3").shouldHave(text("Welcome to issues!"));
        return this;

    }
}
