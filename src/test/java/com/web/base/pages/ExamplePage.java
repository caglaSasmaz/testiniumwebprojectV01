package com.web.base.pages;

import com.web.base.pageElement.PageElementModel;
import com.web.base.pageElement.TestiniumButton;
import com.web.base.utils.driver.Driver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class ExamplePage extends BaseMasterPage {
    private static final Log log = LogFactory.getLog(ExamplePage.class);
    private static ExamplePage instance;

    private static TestiniumButton BTN_HomeSearch = new TestiniumButton(PageElementModel.selectorNames.CLASS_NAME, "searchBoxOld-uKvVtLzPNdHp38hj3B13");

    public static synchronized ExamplePage getInstance() {
        if (instance == null)
            instance = new ExamplePage();
        return instance;
    }

    public static void exampleMethod() {
        BTN_HomeSearch.click();
        log.info("ENTERING clickCreateAccount");

    }


}
