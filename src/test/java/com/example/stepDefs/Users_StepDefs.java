package com.example.stepDefs;

import com.example.requests.KraftRequest;
import com.example.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Users_StepDefs {

    @When("The user creates a POST request with {string} and {string} and {string} and {string} and {string}")
    public void the_user_creates_a_post_request_with_and_and_and_and(String name, String email, String password, String about, String terms) {
        KraftRequest.registerNewUser(name, email, password, about, terms);
        KraftRequest.getResponse().prettyPrint();
    }

    @Then("The user verifies that the status code is {int}")
    public void the_user_verifies_that_the_status_code_is(int expectedStatusCode) {
        int actualStatusCode = KraftRequest.getResponse().statusCode();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    @Then("The user verifies that response body contains {string}")
    public void the_user_verifies_that_response_body_contains(String content) {
        Assert.assertTrue(KraftRequest.getResponse().body().asString().contains(content));
    }

    @Then("The compiler gets the token")
    public void the_compiler_gets_the_token() {
        ConfigurationReader.set("token", KraftRequest.getToken());
    }


    @When("The user creates a PATCH request and send token with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_creates_a_patch_request_and_send_token_with_and_and_and_and_and_and_and_and_and(String name, String password, String admin, String about, String terms, String job, String company, String website, String location, String skills) {

        KraftRequest.patchUserProfile(name, password, admin, about, terms, job, company, website, location, skills);
    }

    @When("The user creates a GET request to get own profile")
    public void the_user_creates_a_get_request_to_get_own_profile() {
KraftRequest.getUserOwnProfile();
    }

    @Then("The user verifies that name as {string} and email as {string}")
    public void the_user_verifies_that_name_as_and_email_as(String expectedName, String expectedEmail) {

        String actualName= KraftRequest.getUserName();
        String actualEmail=KraftRequest.getUserEmail();

        Assert.assertEquals(expectedEmail, actualEmail);
        Assert.assertEquals(expectedName, actualName);
    }


}
