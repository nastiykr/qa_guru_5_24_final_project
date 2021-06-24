package tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import customAnnotations.AutoMember;
import customAnnotations.Component;
import customAnnotations.JiraIssue;
import customAnnotations.JiraIssues;
import customAnnotations.Layer;
import customAnnotations.ManualMember;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.BaseTest;
import tests.ui.pages.GitHubPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

@Layer("web")
public class GitHubUITests extends BaseTest {

    public final static String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "nastiykr/qa_guru_5_5_allure_reports";

    GitHubPage gitHubPage = new GitHubPage();

    @Test
    @JiraIssues({@JiraIssue("QC5-5")})
    @AllureId("3245")
    @ManualMember("c05-nasstasya")
    @AutoMember("nastiykr")
    @Component("UI")
    @Feature("Поиск")
    @Tags({@Tag("critical"), @Tag("web")})
    @DisplayName("Поиск репозитория через поисковую строку")
    void searchRepo() {
        gitHubPage.openPage(BASE_URL)
                .search(REPOSITORY);
    }

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3235")
    @ManualMember("c05-nasstasya")
    @AutoMember("nastiykr")
    @Component("UI")
    @Feature("Поиск")
    @Tags({@Tag("web")})
    @DisplayName("Поиск раздела Issue в репозитории")
    void searchIssueTabTest() {
        gitHubPage.openPage(BASE_URL)
                .search(REPOSITORY)
                .goToRepository(REPOSITORY)
                .checkOpenedIssue();
    }

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3236")
    @ManualMember("c05-nasstasya")
    @AutoMember("nastiykr")
    @Component("UI")
    @Feature("Авторизация")
    @Tags({@Tag("web")})
    @DisplayName("Авторизация пользователя с неверным паролем")
    void authorizationUserWithNotRightPassword() {
        gitHubPage.openPage(BASE_URL);
        $(byText("Sign in")).click();
        $(id("login_field")).setValue("user");
        $(id("password")).setValue("123");
        $("[value='Sign in']").click();
        Selenide.sleep(100);
        $(byText("There have been several failed attempts to sign in from this account or IP address. Please wait a while and try again later.")).shouldBe(Condition.visible);
    }

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3243")
    @ManualMember("c05-nasstasya")
    @AutoMember("nastiykr")
    @Component("UI")
    @Feature("Разделы на сайте")
    @Tags({@Tag("web")})
    @DisplayName("Открытие вкладки team")
    void openTabFeature() {
        gitHubPage.openPage(BASE_URL)
                .clickOpenTeamPage()
                .checkOpenedTeamPage();
    }

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3244")
    @ManualMember("c05-nasstasya")
    @AutoMember("nastiykr")
    @Component("UI")
    @Feature("Разделы на сайте")
    @Tags({@Tag("web")})
    @DisplayName("Открытие страницы shop")
    void openShopPage() {
        gitHubPage.openPage(BASE_URL)
                .clickOpenShopPage()
                .clickButtonShop()
                .checkOpenedShopPage();
    }
}
