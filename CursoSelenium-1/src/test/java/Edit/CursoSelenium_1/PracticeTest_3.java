package Edit.CursoSelenium_1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilidades.CapturaEvidencia;
public class PracticeTest_3 {
	String url = "http://www.automationpractice.pl";
	WebDriver driver;
	String directorioEvidencias = "..\\CursoSelenium-1\\Evidencias\\";
	File pantalla;
	String nombreDocumento = "Documento de Evidencias - AutomationPractice.docx";
	
	@BeforeSuite
	public void antesDeTodasLasPruebas() {
		// Definir el navegador
		driver = new ChromeDriver();
				
		// Abrir la página
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterSuite
	public void despuesDeTodasLasPruebas() {
		driver.close();
	}
	
	@Test(description="CP01 - Ir a Contactanos en AutomationPractice",priority=2)
	public void irAContactanos() throws InvalidFormatException, IOException, InterruptedException {
		// Captura de Evidencia: Pantalla Principal
		CapturaEvidencia.escribirTituloEnDocumento(
				directorioEvidencias + nombreDocumento, 
				"Documento de Evidencias - AutomationPractice", 
				20);
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg", 
				directorioEvidencias + nombreDocumento, 
				"Paso 1 - Pantalla Principal");
			
		// Hacer clic en 'Contact us'
		WebElement lnkContact = driver.findElement(By.linkText("Contact us"));
		lnkContact.click();
		
		// Captura de Evidencia: Clic en Contact us
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg", 
				directorioEvidencias + nombreDocumento, 
				"Paso 2 - Después de hacer clic en Contact Us");
		
		// Completar el formulario
		Select lista = new Select(driver.findElement(By.cssSelector("#id_contact")));
		lista.selectByVisibleText("Webmaster");
		
		WebElement txtEmail = driver.findElement(By.xpath("//input[@id='email']"));
		txtEmail.sendKeys("correo0112@gmail.com");
		
		WebElement txtOrder = driver.findElement(By.id("id_order"));
		txtOrder.sendKeys("ORD-1548");
		
		// Campo para adjuntar archivo (input type="file"...)
		WebElement filAttached = driver.findElement(By.name("fileUpload"));
		filAttached.sendKeys("C:\\addIntegerData.txt"); // ruta que exista
		
		WebElement txtMessage = driver.findElement(By.tagName("textarea"));
		txtMessage.sendKeys("Mensaje de Contacto");
		
		// Captura de Evidencia: Formulario Lleno
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg", 
				directorioEvidencias + nombreDocumento, 
				"Paso 3 - Después de completar el formulario");
		
		// Hacer clic en 'Send'
		WebElement btnSend  = driver.findElement(By.cssSelector("#submitMessage"));
		btnSend.click();
		
		// Captura de Evidencia: Envío de Mensaje
		CapturaEvidencia.capturarPantallaEnDocumento(
				driver, 
				directorioEvidencias + "img.jpg", 
				directorioEvidencias + nombreDocumento, 
				"Paso 4 - Después de enviar el mensaje de contacto");
	}
	
	@Test(description="CP02 - Buscar Palabra en AutomationPractice",priority=1)
	public void buscarPalabra() throws IOException {
		// Captura de Evidencia: Pantalla Principal
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(directorioEvidencias + "01_PantallaPrincipal.jpg"));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress");
		
		// Captura de Evidencia: Palabra a Buscar
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(directorioEvidencias + "02_PalabraABuscar.jpg"));
		
		txtBuscador.sendKeys(Keys.ENTER);
		
		// Captura de Evidencia: Resultados de la Búsqueda
		pantalla = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(pantalla, new File(directorioEvidencias + "03_ResultadosBusqueda.jpg"));
		
		// Incorporar chequeos para verificar que la prueba fue exitosa
		// Validación es comparar resultado esperado y resultado obtenido
		String tituloEsperado = "Search - My Shop";
		String tituloObtenido = driver.getTitle();
		
		Assert.assertEquals(tituloObtenido, tituloEsperado);
		
		/*
		Assert.assertNotEquals("A", "B"); // se valida que no sean iguales
		Assert.assertNull(null); // valida que la variable esté vacía
		Assert.assertNotNull("XXX"); // validar que la variable tenga un valor
		Assert.assertTrue(1==1); // validar que sea verdadero
		Assert.assertFalse(2==3); // validar que sea falsa
		*/
		
		// SoftAssert => Validaciones que si no se cumplen no interrumpen la ejecución
	}
}
