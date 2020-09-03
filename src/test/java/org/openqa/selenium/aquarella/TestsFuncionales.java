package org.openqa.selenium.aquarella;

import java.lang.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestsFuncionales {
	private static FirefoxDriver driver;
	WebElement element;
 
	@BeforeAll
	public static void openBrowser() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} 

	@Test
	@DisplayName("Test funcional de obtención de saldo")
	public void obtenerSaldo() throws InterruptedException {

		System.out.println(">>> Iniciando obtenerSaldo()");

		driver.get("http://test:9090/");
		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.id("userid")).sendKeys("666");
		TimeUnit.SECONDS.sleep(3);

		driver.findElement(By.id("ingresar")).click();

		try {
			element = driver.findElement(By.id("saldo"));
		} catch (Exception e) {
			// Vacío
		}
		Assertions.assertNotNull(element);
		Assertions.assertEquals(element.getText(), "$96.500.000.000");
		TimeUnit.SECONDS.sleep(3);
		System.out.println(">>> Finalizando obtenerSaldo()");
     }
 

	@AfterAll
	public static void closeBrowser() {
		driver.quit();
	}

}
