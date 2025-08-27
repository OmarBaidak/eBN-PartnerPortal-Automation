package utilities;

import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class DataGenerator {

    // A static nested class to hold and pass the captured data.
    public static class CapturedData {
        public static String partnerContactName;
        public static String partnerContactPhone;
        public static String partnerContactEmail;
        public static String customerID;
        public static String customerName;
        public static String customerContactName;
        public static String customerContactEmail;
        public static String customerStreetAddress;
        public static String customerCity;
        public static String customerStateValue;
        public static String customerZipCode;
        public static String companyName;
        public static String companyCity;
        public static String companyStateValue;
        public static String companyFederalTaxID;
        public static String companyAddress;
        public static String carrierConnections;
        public static String planYearStartDate;
        public static String numberOfEmployees;
        public static String carrierName;
        public static String primaryContactName;
        public static String primaryContactEmail;
        public static String includeCOBRAMembers;
    }

    private static String generateRandomAlphabeticString() {
        return UUID.randomUUID().toString().replaceAll("[^a-zA-Z]", "");
    }

    public static void generateAndSaveUniqueDataToJson() {
        JSONObject dataObject = new JSONObject();

        // Generate unique data for each field
        String uniqueId = generateRandomAlphabeticString();
        CapturedData.partnerContactName = "John" + uniqueId;
        CapturedData.partnerContactPhone = "555-" + new Random().nextInt(1000) + "-" + new Random().nextInt(10000);
        CapturedData.partnerContactEmail = "john_" + uniqueId + "@test.com";
        CapturedData.customerID = "CUST-" + new Random().nextInt(1000000);
        CapturedData.customerName = "Acme" + uniqueId;
        CapturedData.customerContactName = "Jane" + uniqueId;
        CapturedData.customerContactEmail = "jane" + uniqueId + "@test.com";
        CapturedData.customerStreetAddress = "123 Test St";
        CapturedData.customerCity = "New Test City";
        CapturedData.customerStateValue = "5"; // This value is now fixed
        CapturedData.customerZipCode = "12345";
        CapturedData.companyName = "Test" + uniqueId;
        CapturedData.companyCity = "Test Company City";
        CapturedData.companyStateValue = "32"; // This value is now fixed
        CapturedData.companyFederalTaxID = "98-" + new Random().nextInt(10000000);
        CapturedData.companyAddress = "456 Test Ave";
        CapturedData.carrierConnections = "2"; // This value is now fixed
        CapturedData.planYearStartDate = "01/01/2025";
        CapturedData.numberOfEmployees = String.valueOf(new Random().nextInt(1000) + 1);
        CapturedData.carrierName = "HealthPlus" + uniqueId;
        CapturedData.primaryContactName = "Peter" + uniqueId;
        CapturedData.primaryContactEmail = "peter_" + uniqueId + "@test.com";
        CapturedData.includeCOBRAMembers = "True"; // This value is now fixed

        dataObject.put("PartnerContactName", CapturedData.partnerContactName);
        dataObject.put("PartnerContactPhone", CapturedData.partnerContactPhone);
        dataObject.put("PartnerContactEmail", CapturedData.partnerContactEmail);
        dataObject.put("CustomerID", CapturedData.customerID);
        dataObject.put("CustomerName", CapturedData.customerName);
        dataObject.put("CustomerContactName", CapturedData.customerContactName);
        dataObject.put("CustomerContactEmail", CapturedData.customerContactEmail);
        dataObject.put("CustomerStreetAddress", CapturedData.customerStreetAddress);
        dataObject.put("CustomerCity", CapturedData.customerCity);
        dataObject.put("CustomerStateValue", CapturedData.customerStateValue);
        dataObject.put("CustomerZipCode", CapturedData.customerZipCode);
        dataObject.put("CompanyName", CapturedData.companyName);
        dataObject.put("CompanyCity", CapturedData.companyCity);
        dataObject.put("CompanyStateValue", CapturedData.companyStateValue);
        dataObject.put("CompanyFederalTaxID", CapturedData.companyFederalTaxID);
        dataObject.put("CompanyAddress", CapturedData.companyAddress);
        dataObject.put("CarrierConnections", CapturedData.carrierConnections);
        dataObject.put("PlanYearStartDate", CapturedData.planYearStartDate);
        dataObject.put("NumberOfEmployees", CapturedData.numberOfEmployees);
        dataObject.put("CarrierName", CapturedData.carrierName);
        dataObject.put("PrimaryContactName", CapturedData.primaryContactName);
        dataObject.put("PrimaryContactEmail", CapturedData.primaryContactEmail);
        dataObject.put("IncludeCOBRAMembers", CapturedData.includeCOBRAMembers);

        try (FileWriter file = new FileWriter(JsonPath.jsonData)) {
            file.write(dataObject.toJSONString());
            System.out.println("Successfully generated data and saved to " + JsonPath.jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
