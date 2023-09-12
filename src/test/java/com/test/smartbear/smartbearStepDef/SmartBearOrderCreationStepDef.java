package com.test.smartbear.smartbearStepDef;

import com.test.smartbear.pages.SmartBearLoginPage;
import com.test.smartbear.pages.SmartBearOrderPage;
import com.test.smartbear.pages.SmartBeartMainPage;
import com.test.smartbear.pages.VievAllOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SmartBearOrderCreationStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage=new SmartBearLoginPage(driver);
    SmartBeartMainPage smartBeartMainPage=new SmartBeartMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);
    VievAllOrderPage vievAllOrderPage=new VievAllOrderPage(driver);
    @Given("User provides username and password for SmartBear login")
    public void user_provides_username_and_password_for_smart_bear_login() {
    smartBearLoginPage.login(ConfigReader.readProperty("QA_smartBear_username"),
                             ConfigReader.readProperty("QA_smartBear_password"));
    }
    @When("User clicks Order Button and User provides {string} and {string} for product information")
    public void user_clicks_order_button_and_user_provides_and_for_product_information(String product, String quantity) {
       smartBeartMainPage.orderClickFunc();
       smartBearOrderPage.sendProductInformation(product,quantity);

    }
    @When("User provides {string},{string},{string},{string},{string} for address information")
    public void user_provides_for_address_information(String customerName, String street, String city, String state, String zipcode) throws InterruptedException {
        smartBearOrderPage.sendAddressInformation(customerName,street,city,state,zipcode);
    }
    @When("User provides {string},{string},{string} for payment information")
    public void user_provides_for_payment_information(String cardType, String cardNumber, String expireDate) throws InterruptedException {
       smartBearOrderPage.sendPaymentInformation(cardType,cardNumber,expireDate);
    }
    @Then("User clicks process button and validate {string} and click view order button")
    public void user_clicks_process_button_and_validate_and_click_view_order_button(String expectedMessage) {
      smartBearOrderPage.clickProcessButton();
        Assert.assertEquals(expectedMessage,smartBearOrderPage.getMessage());
        smartBeartMainPage.clickViewAllOrdersButton();
    }
    @Then("User validates all information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} from table")
    public void user_validates_all_information_from_table(String name,String product, String quantity,
                                                          String street,String city,String state, String zipCode,
                                                          String cardType,String cardNumber,String expireDate) {
     vievAllOrderPage.validateInfoFromTable(name,product,quantity,
             street,city,state,zipCode,
             cardType,cardNumber,expireDate);

    }
    @When("User clicks OrderButton and provides the product and quantity for product information")
    public void user_clicks_order_button_and_provides_the_product_and_quantity_for_product_information(DataTable dataTable) {
        Map<String,String> productInformation=dataTable.asMap();
        System.out.println(productInformation);//product= MyMoney quantity=4 .....
        smartBeartMainPage.orderClickFunc();
        smartBearOrderPage.sendProductInformation(productInformation.get("product"),
                                                  productInformation.get("quantity"));
    }
    @When("User provides customerName,street,city,state,zipCode for address information")
    public void user_provides_customer_name_street_city_state_zip_code_for_address_information(DataTable dataTable) throws InterruptedException {
          Map<String,String> addressInformation=dataTable.asMap();
          smartBearOrderPage.sendAddressInformation(addressInformation.get("customerName"),
                  addressInformation.get("street"),
                  addressInformation.get("city"),
                  addressInformation.get("state"),
                  addressInformation.get("zipCode"));

    }
    @When("User provides cardType,cardNumber,expireDate for payment information")
    public void user_provides_card_type_card_number_expire_date_for_payment_information(DataTable dataTable) throws InterruptedException {
        Map<String,String> sendPaymentInformation=dataTable.asMap();
        smartBearOrderPage.sendPaymentInformation(sendPaymentInformation.get("cardType"),
                sendPaymentInformation.get("cardNumber"),sendPaymentInformation.get("expireDate"));
    }
    @When("User clicks process button and validates message")
    public void user_clicks_process_button_and_validates_message(DataTable dataTable) {
         smartBearOrderPage.clickProcessButton();
         List<String> message=dataTable.asList();
         Assert.assertEquals(message.get(0),smartBearOrderPage.getMessage());
    }


}
