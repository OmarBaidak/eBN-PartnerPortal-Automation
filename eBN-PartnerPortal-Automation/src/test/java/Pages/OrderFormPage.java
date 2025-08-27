package Pages;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Actions;
import utilities.DataGenerator;
import utilities.JsonPath;
import utilities.JsonReader;

import java.io.IOException;
import java.util.Random;

import static utilities.JsonPath.jsonData;


public class OrderFormPage extends Actions {
    private final WebDriver driver;

    By partnerContactNameField = By.xpath("(//*[contains(text(), 'Contact Name')])[1]/following-sibling::input");
    By PartnerContactPhoneField = By.xpath("(//*[contains(text(), 'Contact Phone')])[1]/following-sibling::input");
    By PartnerContactEmailField = By.xpath("(//*[contains(text(), 'Contact Email')])[1]/following-sibling::input");
    By customerNameField = By.xpath("//*[contains(text(), 'Customer Name')]/following-sibling::input");
    By customerIDField = By.xpath("//*[contains(text(), 'Customer ID')]/following-sibling::input");
    By customerContactNameField = By.xpath("(//*[contains(text(), 'Contact Name')])[last()]/following-sibling::input");
    By customerContactEmailField = By.xpath("(//*[contains(text(), 'Contact Email')])[last()]/following-sibling::input");
    By customerStreetAddressField = By.xpath("//*[contains(text(), 'Street Address')]/following-sibling::input");
    By customerCityField = By.xpath("(//*[contains(text(), 'City')])[1]/following-sibling::input");
    By customerStateDropDown = By.xpath("(//*[contains(text(), 'State')])[1]/following-sibling::select");
    By customerZipCodeField = By.xpath("//*[contains(text(), 'Zip Code')]/following-sibling::input");
    By companyNameField = By.xpath("//*[contains(text(), 'Company Name')]/following-sibling::input");
    By companyCityField = By.xpath("(//*[contains(text(), 'City')])[2]/following-sibling::input");
    By companyStateDropDown = By.xpath("(//*[contains(text(), 'State')])[2]/following-sibling::select");
    By companyFederalTaxIDField = By.xpath("(//*[contains(text(), 'Federal Tax ID')])[2]/following-sibling::input");
    By companyAddressField = By.xpath("//*[contains(text(), 'Company Address')]/following-sibling::input");
    By customerBenefitsInformationCarrierConnectionsField = By.xpath("//*[contains(text(), ' Carrier Connections')]/following-sibling::input");
    By customerBenefitsInformationPlanYearStartDateField = By.xpath("//*[contains(text(), ' Start Date')]/following-sibling::input");
    By customerBenefitsInformationOfEmployeesField = By.xpath("//*[contains(text(), 'Employees')]/following-sibling::input[@type='text']");
    By carrierNameField = By.xpath("//*[contains(text(), 'Carrier Name')]/following-sibling::input");
    By primaryContractNameField = By.xpath("(//*[contains(text(), 'Contact name')])[1]/following-sibling::input");
    By primaryContractEmailField = By.xpath("(//*[contains(text(), 'Contact email')])[1]/following-sibling::input");
    By includeCOBRAMembersInTheConnectionDropDown = By.xpath("//*[contains(text(), 'Include COBRA')]/following-sibling::select");
    By planTypeCheckBox = By.xpath("//*[*[text()='Dental']]/preceding-sibling::td/input[@type='checkbox']");
    By submitButton = By.xpath("//*[@id='UASub']");
    By confirmSubmitButton = By.xpath("//*[@id='confirm_id']");
    By okSubmitButton = By.xpath("//*[@id='success_id']");
    By ordersButton =By.xpath("//*[text()='Orders']");

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typePartnerContactName() throws IOException, org.json.simple.parser.ParseException {
        type(partnerContactNameField, JsonReader.getJsonValueByKey(jsonData, "PartnerContactName"));
    }

    public void typePartnerContactPhone() throws IOException, org.json.simple.parser.ParseException {
        type(PartnerContactPhoneField, JsonReader.getJsonValueByKey(jsonData, "PartnerContactPhone"));
    }

    public void typePartnerContactEmail() throws IOException, org.json.simple.parser.ParseException {
        type(PartnerContactEmailField, JsonReader.getJsonValueByKey(jsonData, "PartnerContactEmail"));
    }

    public void typeCustomerName() throws IOException, org.json.simple.parser.ParseException {
        type(customerNameField, JsonReader.getJsonValueByKey(jsonData, "CustomerName"));
    }

    public void typeCustomerID() throws IOException, ParseException {

        type(customerIDField,JsonReader.getJsonValueByKey(jsonData,"CustomerID"));
    }

    public void typeCustomerContactName() throws IOException, org.json.simple.parser.ParseException {
        type(customerContactNameField, JsonReader.getJsonValueByKey(jsonData, "CustomerContactName"));
    }

    public void typeCustomerContactEmail() throws IOException, org.json.simple.parser.ParseException {
        type(customerContactEmailField, JsonReader.getJsonValueByKey(jsonData, "CustomerContactEmail"));
    }

    public void typeCustomerStreetAddress() throws IOException, org.json.simple.parser.ParseException {
        type(customerStreetAddressField, JsonReader.getJsonValueByKey(jsonData, "CustomerStreetAddress"));
    }

    public void typeCustomerCity() throws IOException, org.json.simple.parser.ParseException {
        type(customerCityField, JsonReader.getJsonValueByKey(jsonData, "CustomerCity"));
    }

    public void selectCustomerState() throws IOException, org.json.simple.parser.ParseException {
        selectByValue(customerStateDropDown, JsonReader.getJsonValueByKey(jsonData, "CustomerStateValue"));
    }

    public void typeCustomerZipCode() throws IOException, org.json.simple.parser.ParseException {
        type(customerZipCodeField, JsonReader.getJsonValueByKey(jsonData, "CustomerZipCode"));
    }

    public void typeCompanyName() throws IOException, org.json.simple.parser.ParseException {
        type(companyNameField, JsonReader.getJsonValueByKey(jsonData, "CompanyName"));
    }

    public void typeCompanyCity() throws IOException, org.json.simple.parser.ParseException {
        type(companyCityField, JsonReader.getJsonValueByKey(jsonData, "CompanyCity"));
    }

    public void selectCompanyState() throws IOException, org.json.simple.parser.ParseException {
        selectByValue(companyStateDropDown, JsonReader.getJsonValueByKey(jsonData, "CompanyStateValue"));
    }

    public void typeCompanyFederalTaxID() throws IOException, org.json.simple.parser.ParseException {
        type(companyFederalTaxIDField, JsonReader.getJsonValueByKey(jsonData, "CompanyFederalTaxID"));
    }

    public void typeCompanyAddress() throws IOException, org.json.simple.parser.ParseException {
        type(companyAddressField, JsonReader.getJsonValueByKey(jsonData, "CompanyAddress"));
    }

    public void typeCarrierConnections() throws IOException, org.json.simple.parser.ParseException {
        type(customerBenefitsInformationCarrierConnectionsField, JsonReader.getJsonValueByKey(jsonData, "CarrierConnections"));
    }

    public void typePlanYearStartDate() throws IOException, org.json.simple.parser.ParseException {
        type(customerBenefitsInformationPlanYearStartDateField, JsonReader.getJsonValueByKey(jsonData, "PlanYearStartDate"));
    }

    public void typeNumberOfEmployees() throws IOException, org.json.simple.parser.ParseException {
        type(customerBenefitsInformationOfEmployeesField, JsonReader.getJsonValueByKey(jsonData, "NumberOfEmployees"));
    }

    public void typeCarrierName() throws IOException, org.json.simple.parser.ParseException {
        type(carrierNameField, JsonReader.getJsonValueByKey(jsonData, "CarrierName"));
    }

    public void typePrimaryContactName() throws IOException, org.json.simple.parser.ParseException {
        type(primaryContractNameField, JsonReader.getJsonValueByKey(jsonData, "PrimaryContactName"));
    }

    public void typePrimaryContactEmail() throws IOException, org.json.simple.parser.ParseException {
        type(primaryContractEmailField, JsonReader.getJsonValueByKey(jsonData, "PrimaryContactEmail"));
    }

    public void selectIncludeCOBRAMembers() throws IOException, org.json.simple.parser.ParseException {
        selectByValue(includeCOBRAMembersInTheConnectionDropDown, JsonReader.getJsonValueByKey(jsonData, "IncludeCOBRAMembers"));
    }

    public void clickPlanTypeCheckbox() {
        clickWithJs(planTypeCheckBox);
    }

    public void clickOnSubmitButton() {
        clickWithJs(submitButton);

    }


    public void clickOnConfirmSubmitButton() {
        click(confirmSubmitButton);
    }
    public void clickOnOkSubmitButton(){
        click(okSubmitButton);
    }
    public void clickOnOrdersButton(){click(ordersButton);}

    public void fillOutTheFormWithValidData() throws IOException, org.json.simple.parser.ParseException {
        DataGenerator.generateAndSaveUniqueDataToJson();
        typePartnerContactName();
        typePartnerContactPhone();
        typePartnerContactEmail();
        typeCustomerName();
        typeCustomerID();
        typeCustomerContactName();
        typeCustomerContactEmail();
        typeCustomerStreetAddress();
        typeCustomerCity();
        selectCustomerState();
        typeCustomerZipCode();
        typeCompanyName();
        typeCompanyCity();
        selectCompanyState();
        typeCompanyFederalTaxID();
        typeCompanyAddress();
        typePlanYearStartDate();
        typeNumberOfEmployees();
        typeCarrierName();
        typePrimaryContactName();
        typePrimaryContactEmail();
        selectIncludeCOBRAMembers();
        clickPlanTypeCheckbox();
        typeCarrierConnections();
        clickOnSubmitButton();
        clickOnConfirmSubmitButton();
        clickOnOkSubmitButton();


    }
}
