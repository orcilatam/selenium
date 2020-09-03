package org.openqa.selenium.aquarella;

import java.lang.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestsFuncionales {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://localhost:9090/");

		WebElement rutdni = driver.findElement(By.id("userid"));
		rutdni.sendKeys("12345678");

		WebElement ingresar = driver.findElement(By.id("ingresar"));
		ingresar.click();

		// Timeout de 10 segundos
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().startsWith("Banco Aquarella - Saldo");
			}
		});

		System.out.println(">>> Consulta de saldo exitosa: " + driver.getTitle());
		driver.quit();
	}
}
