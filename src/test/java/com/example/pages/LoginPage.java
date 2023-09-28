package com.example.pages;

import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "yourPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginBtn;

    public void login (String userEmail, String userPassword){
        emailBox.sendKeys(userEmail);
        passwordBox.sendKeys(userPassword);
        loginBtn.click();
    }

    public void login (){
        emailBox.sendKeys(ConfigurationReader.get("email"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }


    public void setUp(){
        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("url"));
        login();
    }

}
