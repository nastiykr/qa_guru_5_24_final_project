package tests.api;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
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
    @Description("Создание репозитория")
    void createdRepo() {
        gitHubApiSteps.createRepo(repo);
        gitHubApiSteps.checkExistsRepo(repo);
        gitHubApiSteps.deleteRepo(repo);
    }

    @Test
    @Description("Изменение названия репозитория")
    void editNameRepo() {
        gitHubApiSteps.createRepo(repo);
        gitHubApiSteps.editNameRepo(repo, newRepo);
        Selenide.sleep(2000);
        gitHubApiSteps.deleteRepo(newRepo);
    }

    @Test
    @Description("Поиск репозитория")
    void searchRepo() {
        int countRepoBeforeCreate = gitHubApiSteps.searchRepo(repo);
        assertEquals(0, countRepoBeforeCreate);

        gitHubApiSteps.createRepo(repo);
        Selenide.sleep(2000);

        int countRepoAfterCreate = gitHubApiSteps.searchRepo(repo);
        assertEquals(1, countRepoAfterCreate);

        gitHubApiSteps.deleteRepo(repo);

    }
}
