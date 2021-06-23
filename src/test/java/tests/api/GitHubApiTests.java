package tests.api;

import com.codeborne.selenide.Selenide;
import config.application.App;
import customAnnotations.AllureFeatures;
import customAnnotations.AutoMember;
import customAnnotations.Component;
import customAnnotations.JiraIssue;
import customAnnotations.Layer;
import customAnnotations.ManualMember;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.api.model.Issue;
import tests.api.model.Repo;
import tests.api.steps.GitHubApiIssueSteps;
import tests.api.steps.GitHubApiRepoSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Layer("api")
public class GitHubApiTests {
    public final static String BASE_URL = "https://api.github.com";
    public final static String USER = App.config.getRemoteWebUser();
    public final static String TOKEN = App.config.getRemoteWebToken();

    GitHubApiRepoSteps repoSteps = new GitHubApiRepoSteps();
    GitHubApiIssueSteps issueSteps = new GitHubApiIssueSteps();

    Repo repo = new Repo("my_repo", "some_description");
    Repo newRepo = new Repo("my_repo_edited", "some_some_description");
    Issue issue = new Issue("my_title_1","my_body_1",null, new String[]{"a","b","c"}, new String[]{USER});




    @Test
    void qqw() {
        repoSteps.deleteRepo(repo);
    }

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
        repoSteps.createRepo(repo);
        repoSteps.checkExistsRepo(repo);
        repoSteps.deleteRepo(repo);
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
        repoSteps.createRepo(repo);
        repoSteps.editNameRepo(repo, newRepo);
        Selenide.sleep(2000);
        repoSteps.deleteRepo(newRepo);
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
        int countRepoBeforeCreate = repoSteps.searchRepo(repo);
        assertEquals(0, countRepoBeforeCreate);

        repoSteps.createRepo(repo);
        Selenide.sleep(2000);

        int countRepoAfterCreate = repoSteps.searchRepo(repo);
        assertEquals(1, countRepoAfterCreate);

        repoSteps.deleteRepo(repo);

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
