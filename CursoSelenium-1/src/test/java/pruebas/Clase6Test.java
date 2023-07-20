package pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import paginas.PaginaInicio;
import paginas.PaginaLogin;

public class Clase6Test {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	
	@BeforeSuite
	public void setUp() {

		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(dataProvider="Datos Login")
	public void login(String email, String password) {
		PaginaInicio inicio = new PaginaInicio(driver);
		inicio.hacerClicEnSignIn();
		
		PaginaLogin login = new PaginaLogin(driver);
		login.escribirEmail(email);
		login.escribirPassword(password);
		login.hacerClicEnLogin();
	}
	
	@DataProvider(name="Datos Login")
	public Object[][] obtenerDatosLogin() {
		// Armar la tabla de valores de prueba = Arreglo de Objetos
		Object[][] datos = new Object[3][2];
		datos[0][0] = "abcd@gmail.com"; // email
		datos[0][1] = "45wtwerw"; // password
		
		datos[1][0] = "efgh@gmail.com";
		datos[1][1] = "o9y7ki8y7";
		
		datos[2][0] = "ijkl@gmail.com";
		datos[2][1] = "3rwafsdz";
		
		return datos;
	}
	
	@AfterSuite 
	public void tearDown() {
		//driver.close();
	}
}