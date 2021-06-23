package tests.api;

import com.codeborne.selenide.Selenide;
import customAnnotations.AutoMember;
import customAnnotations.ManualMember;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.api.model.Repo;
import tests.api.steps.GitHubApiSteps;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GitHubApiTests {
    public final static String BASE_URL = "https://api.github.com";
    public final static String USER = "";
    public final static String PASSWORD = "";
    public final static String TOKEN = "";

    Repo repo = new Repo("my_repo", "some_description");
    Repo newRepo = new Repo("my_repo_edited", "some_some_description");
    GitHubApiSteps gitHubApiSteps = new GitHubApiSteps();

    @Test

    void cc() {
        //gitHubApiSteps.deleteRepo(repo);
        //gitHubApiSteps.deleteRepo(newRepo);
    }

    @Test
    @AllureId("3237")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @DisplayName("Создание репозитория")
    void createdRepo() {
        gitHubApiSteps.createRepo(repo);
        gitHubApiSteps.checkExistsRepo(repo);
        gitHubApiSteps.deleteRepo(repo);
    }

    @Test
    @AllureId("3238")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @DisplayName("Изменение названия репозитория")
    void editNameRepo() {
        gitHubApiSteps.createRepo(repo);
        gitHubApiSteps.editNameRepo(repo, newRepo);
        Selenide.sleep(2000);
        gitHubApiSteps.deleteRepo(newRepo);
    }

    @Test
    @AllureId("3239")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
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
    @AllureId("3240")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @DisplayName("Создание Issue")
    void createdIssue() {

    }

    @Test
    @AllureId("3241")
    @DisplayName("Редактирование Issue")
    void edittedIssue() {

    }

    @Test
    @AllureId("3242")
    @ManualMember("nastiykr")
    @AutoMember("nastiykr")
    @DisplayName("Блокировка Issue")
    void blockedIssue() {

    }
}
