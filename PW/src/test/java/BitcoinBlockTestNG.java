import org.example.BitcoinBlockTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class BitcoinBlockTestNG extends BitcoinBlockTest {

    @BeforeMethod
    public void setUp() {
        super.setUp();
        driver.get(url);
    }

    @Test
    public void validateTransactionSection() {
        try {
            WebElement heading = driver.findElement(By.xpath("//h3[@class='font-h3']"));
            Assert.assertTrue(heading.getText().contains("25 of 2875 Transactions"), "Wrong heading");
            System.out.println("Test Case 1 Pass");
        } catch (Exception e) {
            Assert.fail("Error: Transaction section heading not found./Wrong heading");
        }
    }

    @Test
    public void parseTransactions() {
        try {
            for (int i = 1; i <= 25; i++) {
                int inputs = driver.findElements(By.xpath("//div[@class='transaction-box']" + "[" + i + "]" + "//div[@class='vin-header']")).size();
                int outputs = driver.findElements(By.xpath("//div[@class='transaction-box']" + "[" + i + "]" + "//div[@class='vout-header']")).size();
                if (inputs == 1 && outputs == 2) {
                    String txHash = driver.findElement(By.xpath("//div[@class='txn font-p2']" + "[" + i + "]")).getText();
                    System.out.println("Transaction with 1 input and 2 outputs: " + txHash);
                }
            }
        }
        catch (Exception e){
            Assert.fail("Error parsing transactions: " + e.getMessage());
        }


//        try {
//            List<WebElement> transactions = driver.findElements(By.xpath("//div[@class='transaction-box']"));
//            for (WebElement transaction : transactions) {
//                int inputs = transaction.findElements(By.xpath("div[@class='vin-header']")).size();
//                int outputs = transaction.findElements(By.xpath("div[@class='vout-header']")).size();
//                if (inputs == 1 && outputs == 2) {
//                    String txHash = transaction.findElement(By.xpath("//div[@class='txn font-p2']")).getText();
//                    System.out.println("Transaction with 1 input and 2 outputs: " + txHash);
//                }
//            }
//        } catch (Exception e) {
//            Assert.fail("Error parsing transactions: " + e.getMessage());
//        }
    }

    @AfterMethod
    public void tearDown() {
        super.close();
    }
