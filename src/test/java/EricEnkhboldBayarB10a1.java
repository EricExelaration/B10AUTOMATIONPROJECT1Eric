import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class EricEnkhboldBayarB10a1 {


        public static void main(String[] args){

            WebDriver driver = new ChromeDriver();
            driver.get("http://duotify.us-east-2.elasticbeanstalk.com/register.php");
            Assert.assertEquals("Welcome to Duotify!", driver.getTitle());

            WebElement searchBox = driver.findElement(By.name("Signup here")); // name buttanii ner ni q baisan
            Faker faker = new Faker();

            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
              String username = "Enkhbold";
             String password = "Password1";
            String email = "ebemgl@icloud.com";
            String searchTerm = "chatGPT";
            String expectedTitle= searchTerm+ " Google Search";
            searchBox.sendKeys(Keys.ENTER);

            WebElement signupButton = driver.findElement(By.cssSelector("button[type='submit']"));
            signupButton.click();


            String expectedUrl = "http://duotify.us-east-2.elasticbeanstalk.com/browse.php";
            String actualUrl = driver.getCurrentUrl();
            Assert.assertEquals(actualUrl, expectedUrl);

     
            WebElement fullNameLink = driver.findElement(By.className("fullNameLink"));
            String expectedFullName = firstName + " " + lastName;
            String actualFullName = fullNameLink.getText();
            Assert.assertEquals(actualFullName, expectedFullName);

            fullNameLink.click();
            WebElement nameHeading = driver.findElement(By.className("nameHeading"));
            String expectedNameHeading = "Welcome " + firstName + " " + lastName;
            String actualNameHeading = nameHeading.getText();

            String actualTitle = driver.getTitle()+"RandomWord";


            if(actualTitle.equals(expectedNameHeading)) {
                System.out.println("Test passed");
            }else{
                System.out.println("Test failed. The current title is " + actualTitle+ "The expected was "+ expectedNameHeading);
            }
        }
    }


