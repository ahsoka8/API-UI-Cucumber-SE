package com.example.pages;

import com.example.utilities.BrowserUtils;
import com.example.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserProfilePage extends BasePage {

    @FindBy(xpath = "//li[@class='breadcrumb-item'][2]")
    public WebElement userProfilePageTitle;

    @FindBy(css = ".breadcrumb>li:nth-of-type(2)")
    public WebElement userProfilePageTitle_1;

    @FindBy(xpath = "//div[@id='profile-overview']/div[1]")
    public WebElement profileUpdateMessage;

    @FindBy(css = "[role='tablist']>li")
    public List<WebElement> tablist;


    public void navigateUserProfileTabs(String tabName) {
        WebElement tab = Driver.get().findElement(By.xpath("//button[text()='" + tabName + "']/parent::li"));
        tab.click();
    }


    public String addedEducationName(String schoolName) {
        return Driver.get().findElement(By.xpath("//span[text()='" + schoolName + "']")).getText();
    }

    public void deleteEducationLastRecord(String schoolName) {


        WebElement deleteBtn = Driver.get().findElement(By.xpath("(//span[text()='" + schoolName + "'])[last()]/ancestor::tr//a"));
        BrowserUtils.clickWithJS(deleteBtn);

        Alert alert = Driver.get().switchTo().alert();
        alert.accept();

    }


    public String getByCompanyName(String companyName) {
        return Driver.get().findElement(By.xpath("//td[text()='" + companyName + "']")).getText();
    }


    public void deleteExperienceRecord(String companyName) {
        WebElement deleteBtn = Driver.get().findElement(By.xpath("//td[text()='" + companyName + "']/following-sibling::*[2]/a"));
        BrowserUtils.clickWithJS(deleteBtn);

        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }


    public String addedExperienceName(String jobTitleName) {
        return Driver.get().findElement(By.xpath("(//span[text()='" + jobTitleName + "'])[last()]")).getText();
    }

}
