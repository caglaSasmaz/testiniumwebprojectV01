package com.web.base.pageElement;

public class TestiniumLabel extends PageElementModel {

    public TestiniumLabel(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public String getLabelText(){
        return getWebElement().getText();
    }
}
