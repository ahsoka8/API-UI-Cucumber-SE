package com.example.requests;

import static io.restassured.RestAssured.*;

import com.example.common.DataForAPI;
import com.example.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class KraftRequest {

    private static Response response; //singleton
    private static int userId;
    private static String token;

    private static String userEmail;

    private static String userName;

    private static int experienceId;

    private static String experienceJob;
    private static String experienceCompany;

    public static Response registerNewUser(String name, String email, String password, String about, String terms) {
        response = given().accept(ContentType.JSON)
                .body(DataForAPI.registerUserBody(name, email, password, about, terms))
                .when()
                .post(ConfigurationReader.get("registerUserEndPoint"));

        userId = response.path("id");
        System.out.println("userId = " + userId);
        token = response.path("token");
        System.out.println("token = " + token);
        userEmail = response.path("email");
        System.out.println("email = " + email);
        ConfigurationReader.set("password", password);
        ConfigurationReader.set("email", userEmail);
        return response;
    }


    public static Response patchUserProfile(String name, String password, String admin, String about, String terms, String job, String company, String website, String location, String skills) {

        response = given().accept(ContentType.JSON)
                .header("token", ConfigurationReader.get("token"))
                .body(DataForAPI.patchUserProfileBody(name, password, admin, about, terms, job, company, website, location, skills))
                .when()
                .patch(ConfigurationReader.get("patchUserProfileEndPoint"));

        ConfigurationReader.set("password", password);

        return response;
    }


    public static Response getUserOwnProfile() {
        response = given().accept(ContentType.JSON)
                .header("token", ConfigurationReader.get("token"))
                .when()
                .get(ConfigurationReader.get("getUserAllProfileEndPoint"));

        userName = response.path("name[0]");
        userEmail = response.path("email[0]");
        return response;
    }

    public static Response postExperience(String job, String company, String location, String fromdate, String todate, String current, String description) {
        response = given().accept(ContentType.JSON)
                .header("token", ConfigurationReader.get("token"))
                .and()
                .body(DataForAPI.postExperienceBody(job, company, location, fromdate, todate, current, description))
                .when()
                .post(ConfigurationReader.get("postExperienceEndPoint"));

        experienceId = response.path("id");
        System.out.println("experienceId = " + experienceId);
        return response;
    }


    public static Response getExperienceById() {
        response = given().accept(ContentType.JSON)
                .header("token", ConfigurationReader.get("token"))
                .and()
                .pathParam("id", experienceId)
                .when()
                .get(ConfigurationReader.get("getExperienceByIdEndPoint"));

        experienceJob = response.path("job");
        experienceCompany = response.path("company");


        return response;
    }
    
    public static String getUserName() {
        return userName;
    }

    public static Response getResponse() {
        return response;
    }

    public static String getToken() {
        return token;
    }

    public static String getUserEmail() {
        return userEmail;
    }

    public static String getExperienceJob() {
        return experienceJob;
    }

    public static String getExperienceCompany() {
        return experienceCompany;
    }
}
