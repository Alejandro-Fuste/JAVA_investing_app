package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import runner.TestRunner;

public class SharkSteps {

    // HOME PAGE
    // create profile
//    @Given("The user is on the signup page")
//    public void the_user_is_on_the_signup_page() {
//        TestRunner.driver.get("http://127.0.0.1:5500/signup.html");
//    }

//    @When("The user enters their first name")
//    public void the_user_enters_their_first_name() {
//        TestRunner.homePage.firstNameInput.sendKeys("Kevin");
//    }

//    @When("The user enters their last name")
//    public void the_user_enters_their_last_name() {
//        TestRunner.homePage.lastNameInput.sendKeys("O'Leary");
//    }

//    @When("The user enters their business name")
//    public void the_user_enters_their_business_name() {
//        TestRunner.homePage.businessNameInput.sendKeys("O'Leary");
//    }

//    @When("The user enters their username signup")
//    public void the_user_enters_their_username() {
//        TestRunner.homePage.usernameInput.sendKeys("MrWonderful");
//    }
//
//    @When("The user enters their password signup")
//    public void the_user_enters_their_password_signup() {
//        TestRunner.homePage.passwordInput.sendKeys("Wonders1");
//    }
//
//    @When("The user clicks on drop down list")
//    public void the_user_clicks_on_drop_down_list() {
//        TestRunner.homePage.dropDownList.click();
//    }

    @When("The user clicks on Shark")
    public void the_user_clicks_on_shark() {
        TestRunner.homePage.sharkOption.click();
    }

//    @When("The user clicks on the submit profile button")
//    public void the_user_clicks_on_the_submit_profile_button() {
//        TestRunner.homePage.submitProfileButton.click();
//    }

//    @Then("The user is redirected to the home page")
//    public void a_message_saying_account_created_successfully_appears() {
//        String title = TestRunner.driver.getTitle();
//        Assert.assertEquals(title, "Home");
//    }


    // Login
//    @Given("The user is on the home page")
//    public void the_user_is_on_the_home_page() {
//        TestRunner.driver.get("http://127.0.0.1:5500/home.html");
//    }
//
    @When("The user enters their username login")
    public void the_user_enters_their_username_login() {
        TestRunner.homePage.loginUsernameInput.sendKeys("texasDan");
    }

    @When("The user enters their password login")
    public void the_user_enters_their_password_login() {
        TestRunner.homePage.loginPasswordInput.sendKeys("veritas1234");
    }



    @Then("The shark is redirected to the shark page")
    public void the_shark_is_redirected_to_the_shark_page() throws InterruptedException {
        Thread.sleep(1000);
        String title = TestRunner.driver.getTitle();
        Assert.assertEquals(title, "Shark");
    }


    // SHARK HOME PAGE
    @Given("The shark is on the shark page")
    public void the_shark_is_on_the_shark_page() {
        TestRunner.driver.get("http://127.0.0.1:5500/shark");
//        http://localhost:63342/JAVA_investing_app/project2/shark.html
    }

    // Make comment
    @When("The shark clicks on the comment button")
    public void the_shark_clicks_on_the_comment_button() throws InterruptedException {
        Thread.sleep(1000);
        TestRunner.sharkHomePage.commentButtonShark.click();
    }

    @When("The shark comment modal is displayed")
    public void the_shark_comment_modal_is_displayed() {
        TestRunner.sharkHomePage.commentModalShark.isDisplayed();
    }

    @When("The shark clicks on drop down list")
    public void the_shark_clicks_on_drop_down_list() {
        TestRunner.sharkHomePage.commentDropdown.click();
    }

    @When("The shark clicks on the recipient")
    public void the_shark_clicks_on_the_recipient() {
        TestRunner.sharkHomePage.commentRecipient.click();
    }

    @When("The shark enters a date")
    public void the_shark_enters_a_date() {
        TestRunner.sharkHomePage.commentDateShark.sendKeys("2022/01/13");
    }

    @When("The shark enters a comment")
    public void the_shark_enters_a_comment() {
        TestRunner.sharkHomePage.commentInput.sendKeys("I am interested in your idea!");
    }

    @When("The shark clicks on the send comment button")
    public void the_shark_clicks_on_the_send_comment_button() {
        TestRunner.sharkHomePage.sendCommentButton.click();
    }

//    @Then("A message saying comment post was successful appears")
//    public void a_message_saying_post_was_successful_appears() {
//        Assert.assertEquals(TestRunner.sharkHomePage.commentPostSuccessMessage.getText(),
//                "Comment was sent!");
//    }


    // Make offer
    @When("The shark clicks on the pitch button")
    public void the_shark_clicks_on_the_pitch_button() {
        TestRunner.sharkHomePage.pitchButtonShark.click();
    }

    @When("The shark enters a percentage")
    public void the_shark_enters_a_percentage() {
        TestRunner.sharkHomePage.percentageInput.sendKeys("5.4");
    }

    @When("The shark enters an amount")
    public void the_shark_enters_an_amount() {
        TestRunner.sharkHomePage.amountInput.sendKeys("100_000");
    }

    @When("The shark clicks on the submit offer button")
    public void the_shark_clicks_on_the_submit_offer_button() {
        TestRunner.sharkHomePage.submitOfferButton.click();
    }

    @Then("A message saying offer was sent")
    public void a_message_saying_offer_post_was_successful_appears() {
        Assert.assertEquals(TestRunner.sharkHomePage.offerPostSuccessMessage.getText(),
                "Pitch offer was sent!");
    }


    // Accept offer
    @When("The shark clicks on the accept button")
    public void the_shark_clicks_on_the_accept_button() {
        TestRunner.sharkHomePage.sharkAcceptButton.click();
    }

//    @Then("Message appears saying Accepted")
//    public void a_message_saying_accepted_appears() {
//        Assert.assertEquals(TestRunner.sharkHomePage.acceptedMessage.getText(),
//                "Accepted");
//    }


    // Logout
    @When("The shark clicks on the logout button")
    public void the_shark_clicks_on_the_logout_button() {
        TestRunner.sharkHomePage.sharkLogoutButton.click();
    }

    // EXCEPTIONS
//    @Then("An alert pops up saying form cannot accept null values")
//    public void an_alert_pops_up_saying_form_cannot_accept_null_values() {
//        Assert.assertEquals(TestRunner.driver.switchTo().alert().getText(),
//                "Please enter all values!");
//    }
//
//    @When("The user enters too long of a username")
//    public void the_user_enters_too_long_of_a_username() {
//        TestRunner.homePage.usernameInput.sendKeys("MrWonderfulissowonderful");
//    }

//    @Then("An alert pops up saying the entry has exceeded the allowed length")
//    public void an_alert_pops_up_saying_the_entry_has_exceeded_the_allowed_length() {
//        Assert.assertEquals(TestRunner.driver.switchTo().alert().getText(),
//                "Your entry is too long!");
//    }

//    @When("The user enters too short of a username")
//    public void the_user_enters_too_short_of_a_username() {
//        TestRunner.homePage.usernameInput.sendKeys("Mr");
//    }

//    @Then("An alert pops up saying the entry has not met the allowed minimum length")
//    public void an_alert_pops_up_saying_the_entry_has_not_met_the_allowed_minimum_length() {
//        Assert.assertEquals(TestRunner.driver.switchTo().alert().getText(),
//                "Your username is too short!");
//    }

//    @When("The user enters non-alphabet characters as their first name")
//    public void the_user_enters_non_alphabet_characters_as_their_first_name() {
//        TestRunner.homePage.firstNameInput.sendKeys("92834hgd");
//    }

//    @Then("An alert pops up saying the entry has incorrect data type")
//    public void an_alert_pops_up_saying_the_entry_has_incorrect_data_type() {
//        Assert.assertEquals(TestRunner.driver.switchTo().alert().getText(),
//                "Please enter only letters!");
//    }

    @When("The shark enters non-numeric characters for an amount")
    public void the_shark_enters_non_numeric_characters_for_an_amount() {
        TestRunner.sharkHomePage.amountInput.sendKeys("kalsjo");
    }

//    @Then("An alert pops up saying the username entered is already taken")
//    public void an_alert_pops_up_saying_the_username_entered_is_already_taken() {
//        Assert.assertEquals(TestRunner.sharkHomePage.usernameTakenMessage.getText(),
//                "This username is already taken! Please try again.");
//    }

//    @When("The user enters incorrect password")
//    public void the_user_enters_incorrect_password() {
//        TestRunner.homePage.passwordInput.sendKeys("nonexistantpwd");
//    }
//
//    @Then("An alert pops up saying either username or password or both are incorrect")
//    public void an_alert_pops_up_saying_either_username_or_password_or_both_are_incorrect() {
//        Assert.assertEquals(TestRunner.sharkHomePage.usernamePasswordIncorrectMessage.getText(),
//                "Either you username or password or both are incorrect!");
//    }
}
