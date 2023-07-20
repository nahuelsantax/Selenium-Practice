package Edit.CursoSelenium_1;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.edge.EdgeDriver;

public class PracticeTest_1 {
	
	String	url = "http://automationpractice.pl/index.php";
	
	// Metodos de prueba
	@Test
	public void buscarPalabraTest() {
		
		
		 // 1 - Indicar que navegador vamos a utilizar
		
		WebDriver navegador = new ChromeDriver();
		 
		 // 2 - Abrir la pagina que vamos a probar
		navegador.get(url);
		
		// 3 - Escribir la palabra que queremos buscar
		WebElement txtBuscador = navegador.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("dress"); // dress es el texto que se ingresa
		
		 // 4 - Hacer la busqueda (ENTER)
		txtBuscador.sendKeys(Keys.ENTER);
		
		 // 5 - Cerrar el navegador.
		navegador.close();
		// navegador.quit() // cierra todas las pestañas del navegador 
		
	}

}
