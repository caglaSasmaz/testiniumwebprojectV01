package com.web.base.pages;

import com.web.base.backend.BaseAutomationContext;
import com.web.base.backend.ContextKeys;
import com.web.base.backend.WebAutomationException;
import com.web.base.pageElement.TestiniumButton;
import com.web.base.pageElement.PageElementModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class BaseMasterPage {
    private static final Log log = LogFactory.getLog(BaseMasterPage.class);
    private static TestiniumButton BTN_AccountProfile = new TestiniumButton(PageElementModel.selectorNames.CLASS_NAME,"member-name");
    private static TestiniumButton BTN_WatchLive = new TestiniumButton(PageElementModel.selectorNames.CLASS_NAME, "idx-livetv");
    private static TestiniumButton BTN_Logout = new TestiniumButton(PageElementModel.selectorNames.XPATH, "//a[contains(@href,'logout')]");
    private static TestiniumButton BTN_Subscription = new TestiniumButton(PageElementModel.selectorNames.XPATH, "//a[contains(@href,'purchases')]");
    private static TestiniumButton BTN_Profile = new TestiniumButton(PageElementModel.selectorNames.XPATH, "//a[contains(@href,'profile')]");
    private static TestiniumButton BTN_Voucher = new TestiniumButton(PageElementModel.selectorNames.XPATH, "//a[contains(@href,'couponcode')]");
    private static TestiniumButton BTN_Mailbox = new TestiniumButton(PageElementModel.selectorNames.XPATH, "//a[contains(@href,'case')]");


    public void logout(){
        log.info("ENTERING logout");
        BTN_AccountProfile.waitUntilVisibleAndClick();
        BTN_Logout.waitUntilVisibleAndClick();
        log.info("USED E-MAIL IS: " + BaseAutomationContext.getContextValue(ContextKeys.EMAIL));
    }

    public boolean checkLoggedIn(){
        log.info("ENTERING checkLoggedIn");
        return BTN_AccountProfile.isDisplayed();
    }

    public void subscription(){
        log.info("ENTERING subscription");
        BTN_AccountProfile.waitUntilVisibleAndClick();
        BTN_Subscription.waitUntilVisibleAndClick();
    }

    public void clickMailbox() {
        log.info("ENTERING clickMailbox");
        BTN_AccountProfile.waitUntilVisibleAndClick();
        BTN_Mailbox.waitUntilVisibleAndClick();

    }

    public void profile(){
        log.info("ENTERING subscription");
        BTN_AccountProfile.waitUntilVisibleAndClick();
        BTN_Profile.waitUntilVisibleAndClick();
    }

    public void checkNonExistenceOfSubscription(){
        log.info("ENTERING checkNonExistenceOfSubscription");
        BTN_AccountProfile.waitUntilVisibleAndClick();
        if(BTN_Subscription.isDisplayed()){
            String error = "SUBSCRIBE BUTTON SHOULD NOT BE DISPLAYED FOR PARTNER LOGIN";
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("CHECK NON EXISTENCE OF SUBSCRIPTION IS SUCCESSFUL");
        }
    }

    public void checkNonExistenceOfVoucher(){
        log.info("ENTERING checkNonExistenceOfSubscription");
        BTN_AccountProfile.waitUntilVisibleAndClick();
        if(BTN_Voucher.isDisplayed()){
            String error = "VOUCHER BUTTON SHOULD NOT BE DISPLAYED FOR PARTNER LOGIN";
            log.error(error);
            throw new WebAutomationException(error);
        } else {
            log.info("CHECK NON EXISTENCE OF VOUCHER IS SUCCESSFUL");
        }
    }

    public void clickWatchLive() {
        log.info("ENTERING clickWatchLive");
        BTN_WatchLive.waitFor(5);
        BTN_WatchLive.waitUntilVisible();
        BTN_WatchLive.clickAndWait();
    }

}
