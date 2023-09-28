package com.example.stepDefs;

import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import static io.restassured.RestAssured.*;

public class Hooks {

    @Before
    public void setUp() {
      baseURI= ConfigurationReader.get("baseURI");
    }

    @After
    public void tearDown(){
        reset();
        Driver.closeDriver();
    }



}



