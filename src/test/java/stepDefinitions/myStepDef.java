package stepDefinitions;

import com.aventstack.extentreports.App;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Properties;

public class myStepDef {
    WebDriver driver;
    Properties prop=getData();
    ExtentTest test;
    public static ExtentReports extent;
    @Given("^User navigates to the website$")
    public void user_navigates_to_the_website() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:/Users/CMDQ123/Downloads/chromedriver_win32 (3)/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        WebElement careers= driver.findElement(By.xpath("//*[@id=\"menu-item-1373\"]/a"));
        careers.click();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)","");
        Thread.sleep(2000);
    }
    @Then("^Under careers selects South Africa$")
    public void under_careers_selects_south_africa() throws InterruptedException {
        WebElement SA= driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div[3]/div[2]/div/div/div[4]/a"));
        SA.click();
        Thread.sleep(2000);
    }
    @Then("^click on the first available job$")
    public void click_on_the_first_available_job(){
        WebElement firstLink= driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div/div[3]/div[2]/div/div/div/div/div/div[1]/div[1]/div[2]/div[1]/a"));
        firstLink.click();
    }
    @Then("^click on apply$")
    public void click_on_apply() throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)","");
        WebElement btnApply= driver.findElement(By.xpath("//*[@id=\"wpjb-scroll\"]/div[1]/a"));
        btnApply.click();
        Thread.sleep(2000);
    }
    @Then("^input name, email and phone$")
    public void input_name_email_and_phone() throws InterruptedException {
        WebElement txtName=driver.findElement(By.name("applicant_name"));
        txtName.sendKeys(prop.getProperty("name"));
        WebElement txtEmail=driver.findElement(By.name("email"));
        txtEmail.sendKeys(prop.getProperty("email"));
        WebElement txtPhone=driver.findElement(By.name("phone"));
        txtPhone.sendKeys(prop.getProperty("phone"));
        WebElement btnSend= driver.findElement(By.xpath("//*[@id=\"wpjb_submit\"]"));
        btnSend.click();
        Thread.sleep(3000);
    }
    @And("^validate the text$")
    public void validate_the_text(){
        WebElement txtCheck=driver.findElement(By.xpath("//*[@id=\"wpjb-apply-form\"]/fieldset[1]/div[5]/div/ul/li"));
        if(txtCheck.isDisplayed()){
            System.out.println("Text is displayed");
        }else{
            System.out.println("Text not displayed");
        }
    }
    public Properties getData() {
        Properties prop = new Properties();
        try {
            prop.load(App.class.getClassLoader().getResourceAsStream("prop.properties"));
        } catch (
                IOException ex) {
            ex.printStackTrace();
        }
        return prop;
    }

}
