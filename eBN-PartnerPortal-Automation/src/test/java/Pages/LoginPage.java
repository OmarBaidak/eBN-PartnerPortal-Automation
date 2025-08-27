package Pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Actions;
import utilities.Assertions;
import utilities.JsonPath;
import utilities.JsonReader;

import java.io.IOException;

public class LoginPage extends Actions{
    private final WebDriver driver;

    By usernameField = By.xpath("//*[contains(text(), 'Username')]/following-sibling::input");
    By passwordField = By.xpath("//*[contains(text(), 'Password')]/following-sibling::input");
    By loginButton = By.xpath("//*[@value=\"Log In\"]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterValidUsername() throws IOException, ParseException {
        type(usernameField,JsonReader.getJsonValueByKey(JsonPath.Credentials,"UserName"));
    }
    public void enterValidPassword() throws IOException, ParseException {
        type(passwordField,JsonReader.getJsonValueByKey(JsonPath.Credentials,"Password"));
    }
    public void clickOnLoginButton(){
        click(loginButton);
    }
    public void loginWithValidCredentials() throws IOException, ParseException {
        enterValidUsername();
        enterValidPassword();
        clickOnLoginButton();
    }
}