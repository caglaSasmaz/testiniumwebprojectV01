package com.web.base.pagesteps;

import com.thoughtworks.gauge.ContinueOnFailure;
import com.web.base.pages.ExamplePage;
import com.thoughtworks.gauge.Step;
import com.web.base.utils.driver.Driver;

public class BaseSteps {

    public static String APP_URL = System.getenv("APP_URL");
    private static ExamplePage denemetestPage = ExamplePage.getInstance();

//    @ContinueOnFailure({AssertionError.class})
//    @Step("Go to url project")
//    public void goURL() {
//        Driver.webDriver.get(APP_URL);
//        Driver.webDriver.manage().window().maximize();
//    }


    @ContinueOnFailure({AssertionError.class})
    @Step("Go to url <url>")
    public void goURL(String url) {
        Driver.webDriver.get(url);
        Driver.webDriver.manage().window().maximize();
    }



}

