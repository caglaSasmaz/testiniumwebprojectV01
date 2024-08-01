package com.web.base.pagesteps;

import com.thoughtworks.gauge.ContinueOnFailure;
import com.thoughtworks.gauge.Step;
import com.web.base.pages.ExamplePage;
import com.web.base.utils.driver.Driver;

public class ExampleSteps extends BaseSteps {

    @ContinueOnFailure({AssertionError.class})
    @Step("Example test scenario")
    public void exampleStep() {
        ExamplePage.exampleMethod();
    }

    @ContinueOnFailure({AssertionError.class})
    @Step("The word <Word> has <VowelCount> vowels")
    public void exampleStep2(String Word, Boolean VowelCount) {

    }

    @ContinueOnFailure({AssertionError.class})
    @Step("hepsiburada search")
    public void exampleStep3() {
        ExamplePage.exampleMethod();
    }




}
