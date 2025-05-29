package com.demoqa;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.qameta.allure.Allure;

public class Formulario extends Base{
	
	By nameLocator = By.id("firstName");
	By lastnameLocator = By.id("lastName");
	By emailLocator = By.id("userEmail");
	By genderLocator = By.xpath("//label[@for='gender-radio-1' or @for='gender-radio-2' or @for='gender-radio-3']");
	By mobileNumberLocator = By.id("userNumber");
	By dateOfBirthLocator = By.id("dateOfBirthInput");
	By subjectsLocator = By.xpath("//input[@id='subjectsInput']");
	By checkBoxLocator = By.xpath("//label[contains(@for,'hobbies-checkbox-')]");
	By currentAddressLocator = By.id("currentAddress");
	By stateLocator = By.id("state");
	By optionStateLocator = By.xpath("//div[contains(@id,'react-select-3-option-')]");
	By cityLocator = By.id("city");
	By optionCityLocator = By.xpath("//div[contains(@id,'react-select-4-option-')]");
	By submitLocator = By.id("submit");
	By resumeStateAndCityLocator = By.xpath("//td[text()='State and City']/following-sibling::td");
	
	public Formulario(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//Método para digitar en el campo name
	public Formulario name(String userName) throws InterruptedException{
		scroll(200);
		click(nameLocator);
		type(userName,nameLocator);
		return this;
	}
	//Método para digitar en el campo lastname
	public Formulario lastname(String lasName) throws InterruptedException{
		click(lastnameLocator);
		type(lasName,lastnameLocator);
		return this;		
	}
	//Método para digitar en el campo email
	public Formulario email(String email) throws InterruptedException{
		click(emailLocator);
		type(email,emailLocator);
		return this;		
	}	
	//Método para seleccionar genero
	public Formulario selectGender() throws InterruptedException {
        //Encuentra todos los radio buttons por medio del xpath
        List<WebElement> genderRadioButtons = findElements(genderLocator);
        // Genera un inidice aleatorio
        Random random = new Random();
        int randomIndex = random.nextInt(genderRadioButtons.size()); // Selecciona un índice válido de la lista
        //Selecciona un Webelement aleatorio y presiona click
        WebElement selectedRadioButton = genderRadioButtons.get(randomIndex);
        selectedRadioButton.click();
        return this;
	}
	//Método para digitar en el campo mobileNumber
	public Formulario mobileNumber(String mobileNumber) throws InterruptedException{
		click(mobileNumberLocator);
		scroll(200);
		type(mobileNumber,mobileNumberLocator);
		return this;		
	}
	
	//Método para digitar en el campo mobileNumber
	public Formulario mobileNumberError(String mobileNumber) throws InterruptedException{
		click(mobileNumberLocator);
		scroll(200);
		type(mobileNumber,mobileNumberLocator);
		return this;		
	}
	//Método para mapear el campo dateOfBirth
	public Formulario dateofBirth(WebDriver driver, String dia, String mes, String anio) {
	    //Se usa la libreria localDate para validar que la fecha no sea una fecha futura a la actual
	    LocalDate fechaActual = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMMM-yyyy", Locale.ENGLISH);//Se da formato para digitar la fecha 
	    LocalDate fechaNacimiento = LocalDate.parse(dia + "-" + mes + "-" + anio, formatter);
	    //Muestra exepción en caso de que la fecha sea una fecha futura
	    if (fechaNacimiento.isAfter(fechaActual)) {
	        throw new IllegalArgumentException("La fecha de nacimiento no puede ser futura.");
	    }

	    // Abrir el date picker
	    WebElement dateInput = driver.findElement(By.id("dateOfBirthInput"));
	    dateInput.click();
	    // Seleccionar mes
	    Select mesSelect = new Select(driver.findElement(By.className("react-datepicker__month-select")));
	    mesSelect.selectByVisibleText(mes);
	    // Seleccionar año
	    Select anioSelect = new Select(driver.findElement(By.className("react-datepicker__year-select")));
	    anioSelect.selectByVisibleText(anio);
	    // Seleccionar día
	    List<WebElement> dias = driver.findElements(By.cssSelector(".react-datepicker__day"));
	    for (WebElement d : dias) {
	        if (!d.getAttribute("class").contains("react-datepicker__day--outside-month") &&
	            d.getText().equals(dia)) {
	            d.click();
	            break;
	        }
	    }
		return this;
	}
	//Método para seleccionar digitar un valor y seleccionar subject
	public Formulario subjects(String subjects) throws InterruptedException {
		click(subjectsLocator);
		scroll(200);
		type(subjects.substring(0,1),subjectsLocator);
		Thread.sleep(2000);
        //Enncuentra todas las opciones de la lista
        List<WebElement> listSubjects = driver.findElements(By.cssSelector(".subjects-auto-complete__menu-list div"));
        //Genera un indice aleatorio
        Random random = new Random();
        int randomIndex = random.nextInt(listSubjects.size()); // Selecciona un índice válido de la lista
        //Selecciona el webElement y le da click
        WebElement selectedSubjectsList = listSubjects.get(randomIndex);
        selectedSubjectsList.click();
        return this;
	}
	
	//Método para seleccionar uno o mas Hobbies
	public Formulario selectHobbies() {
		//Encuentra todas las opciones de la lista y selecciona un valor aleatorio
	    List<WebElement> hobbiesCheckBox = findElements(checkBoxLocator);
	    Random random = new Random();
	    boolean atLeastOneSelected = false;
	    //Se genera un ciclo para evaliar si el checkBox se encuentra seleccionado
	    for (WebElement checkBox : hobbiesCheckBox) {
	        // 50% de probabilidad de seleccionar este checkbox
	        if (random.nextBoolean()) {
	            if (!checkBox.isSelected()) {
	                checkBox.click();
	            }
	            atLeastOneSelected = true;
	        }
	    }
	    // Si no se ha seleccionado ningun checkBox se selecciona uno de manera aleatoria
	    if (!atLeastOneSelected && !hobbiesCheckBox.isEmpty()) {
	        WebElement randomCheckBox = hobbiesCheckBox.get(random.nextInt(hobbiesCheckBox.size()));
	        if (!randomCheckBox.isSelected()) {
	            randomCheckBox.click();
	        }
	    }
	    return this;
	}
	//Método para cargar una imagen
	public Formulario fileUpload() {
		scroll(300);
	    File uploadFile = new File("C:\\Users\\ASUS 15\\Desktop\\Prueba Seguros Bolivar\\testCases.docx");
	    WebElement fileInput = driver.findElement(By.cssSelector("input[type='file']"));
	    fileInput.sendKeys(uploadFile.getAbsolutePath());
		return this;
	  }
	//Método para digitar la dirección
	public Formulario currentAddress(String currentAddress) {
		scroll(200);
		click(currentAddressLocator);
		type(currentAddress,currentAddressLocator);
		return this;		
	}
	//Método para seleccionar el estado
	public Formulario state() throws InterruptedException {
		click(stateLocator);
		click(optionStateLocator);
		return this;
	}
	//Método para seleccionar la ciudad
	public Formulario city() throws InterruptedException {
		click(cityLocator);
		click(optionCityLocator);
		return this;
	}
	//Método para hacer click en el botón Submit
	public Formulario submit() throws InterruptedException {
	    WebElement submitButton = driver.findElement(submitLocator);
	    // Scroll hasta que el botón sea visible
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
	    // Luego haz clic
	    click(submitLocator);
	    Thread.sleep(2000);
	    return this;
	}
	
	//Método para validar formulario vacio
	public Formulario validateAlertsSubmitVacio() throws InterruptedException, IOException {
		scroll(-500);
		validateFieldState(nameLocator, "rgb(220, 53, 69)");
		validateFieldState(lastnameLocator, "rgb(220, 53, 69)");
		validateFieldState(mobileNumberLocator, "rgb(220, 53, 69)");
		screenshot(driver);
		return this;
	}
	//Método para validar numero de telefono corto
	public Formulario validateShortNumber() throws InterruptedException, IOException {
		scroll(-500);
		validateFieldState(mobileNumberLocator, "rgb(220, 53, 69)");
		screenshot(driver);
		return this;
	}
	//Método para validar nombre muy largo
	public Formulario validateLargeName() throws InterruptedException, IOException {
		scroll(-500);
		validateFieldState(nameLocator, "rgb(220, 53, 69)");
		screenshot(driver);
		return this;
	}
	//Método para validar fecha de nacimiento opcional
	public Formulario validateDateOfBirthToday() throws InterruptedException, IOException {
		scroll(-500);
		validateFieldState(dateOfBirthLocator, "rgb(220, 53, 69)");
		screenshot(driver);
		return this;
	}
	//Método para validar genero obligatorio
	public Formulario validategender() throws InterruptedException, IOException {
		scroll(-500);
		validateFieldState(genderLocator, "rgb(220, 53, 69)");
		screenshot(driver);
		return this;
	}
	//Método para validar direccion opcional	
	public Formulario validateCurrentAddress() throws InterruptedException, IOException {
		scroll(-500);
		validateFieldState(currentAddressLocator, "rgb(40, 167, 69)");
		screenshot(driver);
		return this;
	}
	//Método para validar hobbies opcionales
	public Formulario validateHobbies() throws InterruptedException, IOException {
		scroll(-500);
		List<WebElement> hobbiesCheckBox = findElements(checkBoxLocator);
		for(WebElement hobby: hobbiesCheckBox) {
			assertEquals("rgb(40, 167, 69)", hobby.getCssValue("border-color") );
		}		
		screenshot(driver);
		return this;
	}
	//Método para validar ciudad y estado opcionales
	public Formulario validateStateAndCity() throws InterruptedException, IOException {
		assertEquals("", driver.findElement(resumeStateAndCityLocator).getText());
		screenshot(driver);
		return this;
	}
	
	//Método valdiar estado del campo
	public void validateFieldState(By locator, String expectedColor) throws InterruptedException, IOException {
		WebElement element = driver.findElement(locator);
		assertEquals(expectedColor, element.getCssValue("border-color"));
	}
}
