package steps2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepsDefination
{

	WebDriver driver;

	@Given("user launch the browser")
	public void user_launch_the_browser() 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();

	}
	@Then("user enter the URL as {string}")
	public void user_enter_the_url_as(String applicationURL) {
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	@Then("user enter the credentials as")
	public void user_enter_the_credentials_as(io.cucumber.datatable.DataTable dataTable) 
	{
		String USERNAME=dataTable.cell(0, 0);
		String PASSWORD=dataTable.cell(0, 1);

		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);

		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();

	}
	@Then("user go to Nationalities page")
	public void user_go_to_nationalities_page()
	{
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		driver.findElement(By.xpath("//a[text()='Nationalities']")).click();
		
	}
	@Then("user add Nationalities as and save the nationalities")
	public void user_add_nationalities_as_and_save_the_nationalities(io.cucumber.datatable.DataTable dataTable)
	{


         List<List<String>>  nationalityRecord=dataTable.cells();
         
         for(int i=0;i<nationalityRecord.size();i++)
         {
        	 String nationality=nationalityRecord.get(i).get(0);
        	 
        	 
        	 driver.findElement(By.xpath("//button[text()=' Add ']")).click();

        	 driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")).sendKeys(nationality);

     		driver.findElement(By.xpath("//button[text()=' Save ']")).click();	

        	 
        	 
         }

	}
	@Then("user logout from the application")
	public void user_logout_from_the_application() {

	}
	@Then("user close the browser")
	public void user_close_the_browser() {

	}




















}
