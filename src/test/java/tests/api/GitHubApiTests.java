package tests.api;

import com.codeborne.selenide.Selenide;
import customAnnotations.AllureFeatures;
import customAnnotations.AutoMember;
import customAnnotations.Component;
import customAnnotations.JiraIssue;
import customAnnotations.Layer;
import customAnnotations.ManualMember;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.api.model.Repo;
import tests.api.steps.GitHubApiSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("api")
public class GitHubApiTests {
    public final static String BASE_URL = "https://api.github.com";
    public final static String USER = "";
    public final static String PASSWORD = "";
    public final static String TOKEN = "";

    Repo repo = new Repo("my_repo", "some_description");
    Repo newRepo = new Repo("my_repo_edited", "some_some_description");
    GitHubApiSteps gitHubApiSteps = new GitHubApiSteps();

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3237")
    @ManualMember("c05-nasstasya")
    @AutoMember("nastiykr")
    @Component("API")
    @Feature("Репозиторий")
    @Tags({@Tag("critical"), @Tag("api")})
    @DisplayName("Создание репозитория")
    void createdRepo() {
        gitHubApiSteps.createRepo(repo);
        gitHubApiSteps.checkExistsRepo(repo);
        gitHubApiSteps.deleteRepo(repo);
    }

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3238")
    @ManualMember("c05-nasstasya")
    @AutoMember("nastiykr")
    @Component("API")
    @Feature("Репозиторий")
    @Tags({@Tag("api")})
    @DisplayName("Изменение названия репозитория")
    void editNameRepo() {
        gitHubApiSteps.createRepo(repo);
        gitHubApiSteps.editNameRepo(repo, newRepo);
        Selenide.sleep(2000);
        gitHubApiSteps.deleteRepo(newRepo);
    }

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3239")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @Component("API")
    @Feature("Поиск")
    @Tags({@Tag("critical"), @Tag("api")})
    @DisplayName("Поиск репозитория")
    void searchRepo() {
        int countRepoBeforeCreate = gitHubApiSteps.searchRepo(repo);
        assertEquals(0, countRepoBeforeCreate);

        gitHubApiSteps.createRepo(repo);
        Selenide.sleep(2000);

        int countRepoAfterCreate = gitHubApiSteps.searchRepo(repo);
        assertEquals(1, countRepoAfterCreate);

        gitHubApiSteps.deleteRepo(repo);

    }

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3240")
    @AllureFeatures.Issue
    @Tags({@Tag("api")})
    @DisplayName("Создание Issue")
    void createdIssue() {

    }

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3241")
    @AllureFeatures.Issue
    @Tags({@Tag("api")})
    @DisplayName("Редактирование Issue")
    void edittedIssue() {

    }

    @Test
    @JiraIssue("QC5-5")
    @AllureId("3242")
    @AllureFeatures.Issue
    @Tags({@Tag("api")})
    @DisplayName("Блокировка Issue")
    void blockedIssue() {

    }
}
