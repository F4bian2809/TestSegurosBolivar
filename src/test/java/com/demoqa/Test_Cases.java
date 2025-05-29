package com.demoqa;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.*;
import io.qameta.allure.junit4.AllureJunit4;

public class Test_Cases {
	
	private WebDriver driver;
	Formulario locatorFormulario;

	@Before
	public void setUp() throws Exception {
		locatorFormulario = new Formulario(driver);
		driver = locatorFormulario.chromeDriverConnection();
		driver.manage().window().maximize();
		locatorFormulario.visit("https://demoqa.com/automation-practice-form");
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	@Test
	public void formularioVacio() throws InterruptedException, IOException {
		locatorFormulario.submit().validateAlertsSubmitVacio();
	}
	
	/*@Test
	public void formularioLleno() throws InterruptedException {
		locatorFormulario.name("Fabian").lastname("Arias").email("fabian@pruebas.com").selectGender().mobileNumber("3000000001").dateofBirth(driver, "05","September","2025").
		subjects("I").selectHobbies().fileUpload().currentAddress("Calle falsa # 123").state().city().submit();
	}
	
	@Test
	public void mobileNumberinferior() throws InterruptedException, IOException {
		locatorFormulario.mobileNumber("300000").submit().validateShortNumber();
	}
	
	@Test
	public void nameLarge() throws InterruptedException, IOException {
		locatorFormulario.name("FabianFabianFabianFabianFabianFabianFabianFabianFabianFabianFabianFabianFabianFabianFabianFabianFabian").submit().validateLargeName();
	}
	
	@Test
	public void DateOfBirthToday() throws InterruptedException, IOException {
		locatorFormulario.submit().validateDateOfBirthToday();
	}
	
	@Test
	public void GenderVacio() throws InterruptedException {
		locatorFormulario.name("Fabian")
		.lastname("Arias").email("fabian@pruebas.com").selectGender().mobileNumber("3000000003").dateofBirth(driver, "05","September","2025").
		subjects("I").selectHobbies().fileUpload().currentAddress("Calle falsa # 123").state().city().submit();
	}

	@Test
	public void HobbieVacio() throws InterruptedException {
		locatorFormulario.name("Fabian")
		.lastname("Arias").email("fabian@pruebas.com").selectGender().mobileNumber("3000000004").dateofBirth(driver, "05","September","2025").
		subjects("I").selectHobbies().fileUpload().currentAddress("Calle falsa # 123").state().city().submit();
	}
	
	@Test
	public void FileUpload() throws InterruptedException {
		locatorFormulario.name("Fabian")
		.lastname("Arias").email("fabian@pruebas.com").selectGender().mobileNumber("3000000004").dateofBirth(driver, "05","September","2025").
		subjects("I").selectHobbies().fileUpload().currentAddress("Calle falsa # 123").state().city().submit();
	}
	
	@Test
	public void CurrentAddressVacio() throws InterruptedException {
		locatorFormulario.name("Fabian")
		.lastname("Arias").email("fabian@pruebas.com").selectGender().mobileNumber("3000000005").dateofBirth(driver, "05","September","2025").
		subjects("I").selectHobbies().fileUpload().currentAddress("Calle falsa # 123").state().city().submit();
	}
	
	@Test
	public void StateAndCityVacios() throws InterruptedException {
		locatorFormulario.name("Fabian")
		.lastname("Arias").email("fabian@pruebas.com").selectGender().mobileNumber("3000000006").dateofBirth(driver, "05","September","2025").
		subjects("I").selectHobbies().fileUpload().currentAddress("Calle falsa # 123").state().city().submit();
	}
	
	@Test
	public void CityVacio() throws InterruptedException {
		locatorFormulario.name("Fabian")
		.lastname("Arias").email("fabian@pruebas.com").selectGender().mobileNumber("3000000007").dateofBirth(driver, "05","September","2025").
		subjects("I").selectHobbies().fileUpload().currentAddress("Calle falsa # 123").state().city().submit();
	}*/
}
