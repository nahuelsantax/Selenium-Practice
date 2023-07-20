package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaLogin {
	// Atributos
	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmail;
	
	@FindBy(css="#passwd")
	WebElement txtPassword;
	
	@FindBy(name="SubmitLogin")
	WebElement btnLogin;
	
	// Constructor
	public PaginaLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Acciones
	public void escribirEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void escribirPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void hacerClicEnLogin() {
		btnLogin.click();
	}
	
	public void ingresarCredenciales(String email, String password) {
		escribirEmail(email);
		escribirPassword(password);
		hacerClicEnLogin();
	}
}