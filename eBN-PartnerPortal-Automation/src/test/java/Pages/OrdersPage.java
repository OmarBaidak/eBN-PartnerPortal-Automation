package Pages;

import junit.framework.Assert;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.Actions;
import utilities.JsonPath;
import utilities.JsonReader;

import java.io.IOException;
import java.util.List;

public class OrdersPage extends Actions {

   private final WebDriver driver;

   public OrdersPage(WebDriver driver) {
      this.driver = driver;
   }

   public boolean findOrderInTable(String customerId, String customerName) {
      for (int i = 0; i < 100; i++) {
         List<WebElement> rows = driver.findElements(By.xpath("//table[@class='grid']/tbody/tr"));

         for (WebElement row : rows) {
            try {
               List<WebElement> cells = row.findElements(By.tagName("td"));
               if (cells.size() >= 2) {
                  String rowCustomerName = cells.get(0).getText().trim();
                  String rowCustomerId = cells.get(1).getText().trim();

                  System.out.println("Checking row: ID = " + rowCustomerId + ", Name = " + rowCustomerName);

                  if (rowCustomerId.equals(customerId) && rowCustomerName.equals(customerName)) {
                     System.out.println("✅ Match found on page " + (i + 1));
                     return true;
                  }
               }
            } catch (Exception e) {
               System.out.println("⚠️ Error reading row: " + e.getMessage());
            }
         }

         try {
            WebElement next = driver.findElement(By.xpath("//*[text()='Next']"));
            if (next.isEnabled()) {
               next.click();
            } else {
               break;
            }
         } catch (Exception e) {
            break;
         }
      }
      return false;
   }

   public void assertThatTheFormCreateAndAppearInTable() throws IOException, ParseException {
      String generatedCustomerId = JsonReader.getJsonValueByKey(JsonPath.jsonData,"CustomerID");
      String generatedCustomerName = JsonReader.getJsonValueByKey(JsonPath.jsonData,"CustomerName");
      boolean isOrderFound = findOrderInTable(generatedCustomerId, generatedCustomerName);
      Assert.assertTrue("The newly created order with Customer ID " + generatedCustomerId + " was not found in the orders table after searching all pages.", isOrderFound);
   }

}