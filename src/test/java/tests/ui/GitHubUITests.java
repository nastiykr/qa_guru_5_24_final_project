package tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import customAnnotations.AutoMember;
import customAnnotations.ManualMember;
import io.qameta.allure.AllureId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.ui.pages.GitHubPage;
import tests.BaseTest;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class GitHubUITests extends BaseTest {

    public final static String BASE_URL = "https://github.com";
    private final static String REPOSITORY = "nastiykr/qa_guru_5_5_allure_reports";
    private final static String TAB = "Issue";

    GitHubPage gitHubPage = new GitHubPage();

    @Test
    @AllureId("3245")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @DisplayName("Поиск репозитория через поисковую строку")
    void searchRepo() {
        gitHubPage.openPage(BASE_URL)
                .search(REPOSITORY);
    }

    @Test
    @AllureId("3235")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @DisplayName("Поиск раздела Issue в репозитории")
    void searchIssueTabTest() {
        gitHubPage.openPage(BASE_URL)
                .search(REPOSITORY)
                .goToRepository(REPOSITORY)
                .checkData(TAB);
    }

    @Test
    @AllureId("3236")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
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
    @AllureId("3243")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @DisplayName("Открытие вкладки features")
    void openTabFeature() {
        gitHubPage.openPage(BASE_URL)
                .search(REPOSITORY)
                .goToRepository(REPOSITORY)
                .checkData(TAB);
    }

    @Test
    @AllureId("3244")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @DisplayName("Открытие страницы shop")
    void openShopPage() {
        gitHubPage.openPage(BASE_URL)
                .search(REPOSITORY)
                .goToRepository(REPOSITORY)
                .checkData(TAB);
    }
}
