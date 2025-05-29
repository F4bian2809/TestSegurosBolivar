package com.demoqa;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.internal.shadowed.jackson.core.util.ByteArrayBuilder;

//Esta clase contiene métodos utilitarios para interactuar con elementos web utilizando Selenium WebDriver

public class Base {

	protected WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	// Ejecuta chromedriver para abrir el navegador
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	// Método para devolcer un unico elemento definido por el localizador
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	// Método para devolver los valores de una lista definida por el localizador
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	// Método obtener un elemento del texto proporcionado por el localizador
	public String getText(WebElement element) {
		return element.getText();
	}

	// Método para obtener el texto definido por el localizador
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	// Método para digitar en un campo de texto proporcionado por el localizador
	public void type(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);
	}

	// Método para dar click en el campo proporcionado por el localizador
	public void click(By locator) {
		driver.findElement(locator).click();
	}

	// Método para validar si el elemento es visible en la pagina deacuerdo al
	// localizador proporcionado
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	// Método para visitar la pagina web especificada
	public void visit(String url) {
		driver.get(url);
	}

	public static byte[] toByteArray(BufferedImage bi, String format) throws IOException {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    ImageIO.write(bi, format, baos);
	    byte[] bytes = baos.toByteArray();
	    return bytes;
	}
	// Método para tomar capturas de pantalla
	public void screenshot(WebDriver driver) throws IOException {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		BufferedImage image = ImageIO.read(file);
		byte[] screenshotBytes = toByteArray(image, "png");
		Allure.addAttachment("Captura de Pantalla", new ByteArrayInputStream(screenshotBytes));
	}	
	// Método usado para realizar scroll
	public void scroll(int pixels) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + pixels + ")");
	}

}
