package steps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef {
	WebDriver driver;

	@Given("user launch browser")
	public void user_launch_browser() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Then("User enters URL as {string}")
	public void user_enters_url_as(String TestURL) {
		
        driver.get(TestURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Then("user enters credentials as")
	public void user_enters_credentials_as(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		
		String username = dataTable.cell(0, 0);
		String password = dataTable.cell(0, 1);
		
		
		
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
 
		Thread.sleep(2000);
	}

	@When("go to skills page")
	public void go_to_skills_page() throws InterruptedException 
	{
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//span[text()='Qualifications ']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Skills']")).click();
		
	}

	@Then("enters skill details as")
	public void enters_skill_details_as(io.cucumber.datatable.DataTable dataTable) {
		
		List<List<String>> SkillsRecord = dataTable.cells();
		
		for(int i =0;i<SkillsRecord.size();i++) {   // 0<3, 1<3 ,2<3 ,3<3
			
			String skillname = SkillsRecord.get(i).get(0); // 2,0  
			String skilldesc = SkillsRecord.get(i).get(1);  // 2,1
			
		
		
		driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")).click();
		
        driver.findElement(By.xpath("//div[@class=\"oxd-input-group oxd-input-field-bottom-space\"]/child::div[2]/input")).sendKeys(skillname);
		
		driver.findElement(By.xpath("//textarea[@placeholder=\"Type description here\"]")).sendKeys(skilldesc);
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

		}
	}

	@Then("logout")
	public void logout() {

	}

	@Then("close the browser")
	public void close_the_browser() {

	}

}
