package Pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Actions;
import utilities.Assertions;


public class DashboardPage extends Actions {
    private final WebDriver driver;

    By oneKonnectLogo = By.xpath("//*[@alt='oneKonncet logo']");
    By addDropDownList = By.xpath("//*[@class='dropdown greenboxlink']");
    By electronicDataInterchangeButton = By.xpath("//*[@id='AddEDI']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
public void assertOneKonnectLogoExist(){
        Assertions.isElementPresent(oneKonnectLogo);
}
public void clickOnAddDropDownList(){
        click(addDropDownList);
}
public void clickOnElectronicDataInterchangeButton(){
        click(electronicDataInterchangeButton);
}
public void chooseElectronicDataInterchangeButton(){
    clickOnAddDropDownList();
    clickOnElectronicDataInterchangeButton();
}


}