About this template
This is a template to get started with a Gauge project that uses Selenium as the driver to interact with a web browser.

Installing this template

gauge --install java_selenium

Building on top of this template
Define a Specification
Create a new file under specs directory, for example, "agoda.spec".
Define your specification in this file, as shown below:

User Sign Up Scenario
=====================

Tags: Sign Up, e-mail, functionality

* Navigate to "https://www.agoda.com/tr-tr/"
* Click on the 'Hesap Oluşturun' button
* Enter the valid password to verify
* Click on the 'Hesap Oluşturun' button
* Verify that the user is successfully signed up

User Login Scenario
-------------------

Tags: login, authentication

* Navigate to "https://www.agoda.com/tr-tr/"
* Click on the 'Giriş Yapın' button
* Enter the valid user credentials
* Click on the 'Giriş Yapın' button
* Verify that the user is successfully logged in

Forgot Password
---------------

Tags: forgotpassword, sendlink

* Navigate to "https://www.agoda.com/tr-tr/"
* Click on the 'Giriş Yapın' button
* Click on the "Şifremi Unuttum" button
* Enter email
* Click 'I am not a robot' confirmation
* Click on the 'Şifreyi değiştir' button
* Verify the 'Parola sıfırlama linki şuraya gönderildi:' message

Searching for Hotels
--------------------

Tags: CHOICESOFOTEL, searching

* Navigate to "https://www.agoda.com/tr-tr/"
* Click on 'Oteller' button
* Click on 'Gecelik konaklama' button
* Enter the name of the place to stay in the textbox
* Select a starting date
* Select an ending date
* Select the number of rooms
* Select the number of adults
* Select the number of children
* Enter the children's age
* Click on the 'Ara' button

Filtering
---------

Tags: Filtering otel, options

* Select the appropriate option under 'yıldız sayısı'
* Select the appropriate option under 'semt'
* Select 'şimdi ayırtın sonra ödeyin' under 'ödeme seçenekleri'
* Select the appropriate option under 'merkeze uzaklık'
* Select the appropriate option under 'özel bir şey mi arıyorsunuz?'

Choice of Hotel
---------------

Tags: choosing otel, purchase, functionality, payment

* Navigate to "https://www.agoda.com/tr-tr/"
* Click on the appropriate hotel's title
* Click on the 'book now' button
* Click on the 'next: last step' button
* Select the appropriate payment option under the 'credit/debit card' heading
* Enter the 'credit card / debit card number' in the textbox
* Enter the 'skt' information
* Enter the 'cvc/cvv' code
* Click on the 'book now, pay on site.' button


Writing the implementations
This is where the Java implementation of the steps would be implemented. Since this is a Selenium-based project, the Java implementation would invoke Selenium APIs as required.

We recommend considering modeling your tests using the Page Object pattern, and the Webdriver support for creating them.

Create a new class called AgodaTest.java
Add the Step implementation in the class, as shown below:

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;
import static com.web.base.utils.driver.Driver.driver;

public class AgodaTest {

    @Step("Navigate to <url>")
    public void navigateTo(String url) {
        driver.get(url);
        assertTrue(driver.getTitle().contains("Agoda"));
    }

    @Step("Click on the <button> button")
    public void clickButton(String button) {
        WebElement buttonElement = driver.findElement(By.xpath("//button[text()='" + button + "']"));
        buttonElement.click();
    }

    @Step("Enter the valid password to verify")
    public void enterValidPassword() {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("ValidPassword123");
    }

    @Step("Verify that the user is successfully signed up")
    public void verifyUserSignUp() {
        WebElement confirmationMessage = driver.findElement(By.id("confirmation-message"));
        assertTrue(confirmationMessage.isDisplayed());
    }

    @Step("Enter the valid user credentials")
    public void enterUserCredentials() {
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        emailField.sendKeys("user@example.com");
        passwordField.sendKeys("ValidPassword123");
    }

    @Step("Verify that the user is successfully logged in")
    public void verifyUserLogin() {
        WebElement userProfile = driver.findElement(By.id("user-profile"));
        assertTrue(userProfile.isDisplayed());
    }

    @Step("Click on the \"<linkText>\" button")
    public void clickLinkButton(String linkText) {
        WebElement linkButton = driver.findElement(By.linkText(linkText));
        linkButton.click();
    }

    @Step("Enter email")
    public void enterEmail() {
        WebElement emailField = driver.findElement(By.id("email"));
        emailField.sendKeys("user@example.com");
    }

    @Step("Click 'I am not a robot' confirmation")
    public void clickNotARobot() {
        WebElement notARobotCheckbox = driver.findElement(By.id("not-a-robot-checkbox"));
        notARobotCheckbox.click();
    }

    @Step("Verify the '<message>' message")
    public void verifyMessage(String message) {
        WebElement messageElement = driver.findElement(By.xpath("//*[contains(text(), '" + message + "')]"));
        assertTrue(messageElement.isDisplayed());
    }

    @Step("Enter the name of the place to stay in the textbox")
    public void enterPlaceName() {
        WebElement placeNameField = driver.findElement(By.id("place-name"));
        placeNameField.sendKeys("Istanbul");
    }

    @Step("Select a starting date")
    public void selectStartingDate() {
        WebElement startDateField = driver.findElement(By.id("start-date"));
        startDateField.sendKeys("2024-08-01");
    }

    @Step("Select an ending date")
    public void selectEndingDate() {
        WebElement endDateField = driver.findElement(By.id("end-date"));
        endDateField.sendKeys("2024-08-07");
    }

    @Step("Select the number of rooms")
    public void selectNumberOfRooms() {
        WebElement roomsField = driver.findElement(By.id("rooms"));
        roomsField.sendKeys("2");
    }

    @Step("Select the number of adults")
    public void selectNumberOfAdults() {
        WebElement adultsField = driver.findElement(By.id("adults"));
        adultsField.sendKeys("4");
    }

    @Step("Select the number of children")
    public void selectNumberOfChildren() {
        WebElement childrenField = driver.findElement(By.id("children"));
        childrenField.sendKeys("2");
    }

    @Step("Enter the children's age")
    public void enterChildrenAge() {
        WebElement childrenAgeField = driver.findElement(By.id("children-age"));
        childrenAgeField.sendKeys("5, 7");
    }

    @Step("Click on the 'Ara' button")
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.id("search-button"));
        searchButton.click();
    }

    @Step("Select the appropriate option under '<filter>'")
    public void selectFilterOption(String filter) {
        WebElement filterOption = driver.findElement(By.xpath("//label[contains(text(), '" + filter + "')]"));
        filterOption.click();
    }

    @Step("Click on the appropriate hotel's title")
    public void clickHotelTitle() {
        WebElement hotelTitle = driver.findElement(By.xpath("//h2[@class='hotel-title']"));
        hotelTitle.click();
    }

    @Step("Click on the 'book now' button")
    public void clickBookNowButton() {
        WebElement bookNowButton = driver.findElement(By.id("book-now-button"));
        bookNowButton.click();
    }

    @Step("Click on the 'next: last step' button")
    public void clickNextLastStepButton() {
        WebElement nextLastStepButton = driver.findElement(By.id("next-last-step-button"));
        nextLastStepButton.click();
    }

    @Step("Select the appropriate payment option under the 'credit/debit card' heading")
    public void selectPaymentOption() {
        WebElement paymentOption = driver.findElement(By.id("payment-option"));
        paymentOption.click();
    }

    @Step("Enter the 'credit card / debit card number' in the textbox")
    public void enterCardNumber() {
        WebElement cardNumberField = driver.findElement(By.id("card-number"));
        cardNumberField.sendKeys("1234 5678 9012 3456");
    }

    @Step("Enter the 'skt' information")
    public void enterSKT() {
        WebElement sktField = driver.findElement(By.id("skt"));
        sktField.sendKeys("12/25");
    }

    @Step("Enter the 'cvc/cvv' code")
    public void enterCVC() {
        WebElement cvcField = driver.findElement(By.id("cvc"));
        cvcField.sendKeys("123");
    }

    @Step("Click on the 'book now, pay on site.' button")
    public void clickBookNowPayOnSiteButton() {
        WebElement bookNowPayOnSiteButton = driver.findElement(By.id("book-now-pay-on-site-button"));
        bookNowPayOnSiteButton.click();
    }
}

Note that every Gauge step implementation is annotated with a Step attribute that takes the Step text pattern as a parameter.