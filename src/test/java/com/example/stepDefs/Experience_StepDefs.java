package com.example.stepDefs;

import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.example.pages.UserProfilePage;
import com.example.requests.KraftRequest;
import com.example.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Experience_StepDefs {

    @When("The user creates a POST request for experience with {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_creates_a_post_request_for_experience_with_and_and_and_and_and_and(String job, String company, String location, String fromdate, String todate, String current, String description) {

        KraftRequest.postExperience(job, company, location, fromdate, todate, current, description);
        KraftRequest.getResponse().prettyPrint();

    }

    @When("The user creates a GET request to get added experience")
    public void the_user_creates_a_get_request_to_get_added_experience() {
        KraftRequest.getExperienceById();
        KraftRequest.getResponse().prettyPrint();
    }

    @Then("The user verifies that job as {string} and company as {string}")
    public void the_user_verifies_that_job_as_and_company_as(String expectedJob, String expectedCompany) {
        Assert.assertEquals(expectedJob, KraftRequest.getExperienceJob());
        Assert.assertEquals(expectedCompany, KraftRequest.getExperienceCompany());
    }

    @When("The user is on the Profile Page")
    public void the_user_is_on_the_profile_page() {
        new LoginPage().setUp();

        String username = new DashboardPage().getUsernameText();
        new DashboardPage().navigateToTabsAndModules(username, "My Profile");
    }

    @Then("The user verifies that UI experience and API experience matches by using {string}")
    public void the_user_verifies_that_ui_experience_and_api_experience_matches_by_using(String job) {
        String experienceJob_API = KraftRequest.getExperienceJob();
        String experienceJob_UI = new UserProfilePage().addedExperienceName(job);
        Assert.assertEquals(experienceJob_API, experienceJob_UI);


    }


}
