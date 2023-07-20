package Edit.CursoSelenium_1;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class PracticeTest_2 {
	String url = "http://www.automationpractice.pl";
	
	@Test
	public void registrarUsuario() {
		// 1 - Definir navegador
		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		// 2 - Abrir el navegador en la pagina que queremos probar
		
		// driver.get(url);
		driver.navigate().to(url); // otra forma de abrir la pagina
		
		// 3 - Maximizar la ventana y limpiar las cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		// 4 - Hacer click en "Sign In"
		
		WebElement lnkSignIn = driver.findElement(By.partialLinkText("Sign"));
		lnkSignIn.click();
		
		// String email = "correo" + Math.random() +"gmail.com";
		Faker faker = new Faker ();
		String email = faker.internet().emailAddress();
		
		// 5 - Escribir el correo electronico  y hacer click en 'Create An Account'
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email_create']"));
		txtEmail.sendKeys(email);
		
		WebElement btnCreate = driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();
		
		// ESPERA...
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));
		
		// 6 - Completar el formulario
		WebElement radioTitle = driver.findElement(By.id("id_gender1"));
		radioTitle.click();
		
		WebElement txtFirstName = driver.findElement(By.cssSelector("#customer_firstname"));
		txtFirstName.sendKeys("Nahuel");
		
		WebElement txtLastName = driver.findElement(By.name("customer_lastname"));
		txtLastName.sendKeys("Perez");
		
		WebElement txtCorreo = driver.findElement(By.id("email"));
		txtCorreo.clear();
		txtCorreo.sendKeys(email);
		
		WebElement txtPassword = driver.findElement(By.cssSelector("#passwd"));
		txtPassword.sendKeys("123abc");
		
		// DESPLEGABLE ...
		
		Select lstDays = new Select(driver.findElement(By.name("days")));
		lstDays.selectByVisibleText("18  ");
		
		Select lstMonths = new Select (driver.findElement(By.id("months")));
		lstMonths.selectByValue("6");
		
		Select lstYears = new Select (driver.findElement(By.cssSelector("#years")));
		lstYears.selectByVisibleText("1998  ");
		
		WebElement chkNews = driver.findElement(By.xpath("//input[@id='newsletter']"));
		chkNews.click();
		
		
		// 7 - Hacer click en 'Register'
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		btnRegister.click();
		
		driver.close();
		
		
		
		
	}

}
