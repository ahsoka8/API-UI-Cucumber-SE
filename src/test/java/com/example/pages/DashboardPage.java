package com.example.pages;

import com.example.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage{
    public DashboardPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(tagName ="h2")
    public WebElement userName ;

    @FindBy(css=".breadcrumb>li:nth-of-type(2)")
    public WebElement dashboardPageTitle;





}
