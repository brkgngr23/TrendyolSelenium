package com.trendyol.pages.selenium.trendyol;

import com.trendyol.base.SeleniumAbstractTest;
import com.trendyol.commons.selenium.TrendyolCommons;
import com.trendyol.data.GetData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;



public class PageTrendyolLogin extends SeleniumAbstractTest {
	TrendyolCommons lib;
	public WebDriver test;
	public PageTrendyolLogin (WebDriver driver) {
		lib= new TrendyolCommons(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy (how =How.CSS, using ="[id='accountBtn']")
	WebElement btnGiris;
	@FindBy (how =How.XPATH, using ="//input[@id='login-email']")
	WebElement txtUserName;
	@FindBy (how =How.XPATH, using ="//input[@id='login-password-input']")
	WebElement txtPassword;
	@FindBy (how =How.XPATH, using ="//body/div[@id='container']/div[@id='login-register']/div[3]/div[1]/form[1]/button[1]/span[1]")
	WebElement btnLoginGirisi;
	@FindBy (how =How.CSS, using ="[class='fancybox-item fancybox-close']")
	WebElement closePoPuP;
	@FindBy (how =How.XPATH, using ="//*[name()='path' and @id='Combined-Shape']")
	WebElement closePoPuPMainPage;
	@FindBy (how =How.CSS, using ="[id='browsing-gw-homepage']")
	List <WebElement> mainPage;
	@FindBy (how =How.XPATH, using ="//span[contains(text(),'Hesab')]")
	List <WebElement> txtHesabim;



	public PageTrendyolAnaSayfa login () throws InterruptedException, IOException {
		
		lib.navigateTo(GetData.url);
		girisYap();
		return new PageTrendyolAnaSayfa(lib);
	}



	
	public PageTrendyolLogin girisYap() throws InterruptedException, IOException {
		String username;
		String password;
		Thread.sleep(1000);
		lib.click(closePoPuP);
		lib.Control(lib.isElementExist(mainPage), "Ana Sayfa Kontrolü Başarılı", "Ana Sayfa Kontrolü Başarısız !");
		lib.click(btnGiris);
		
		
		FileReader reader= new FileReader(System.getProperty("user.dir") + "/username.txt");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(reader);
		while ((username = br.readLine()) != null) {

		    System.out.println("username= " +username);
		    Thread.sleep(1000);
		    lib.sendKeys(txtUserName, username);
		}
		
		FileReader readerPass= new FileReader(System.getProperty("user.dir") + "/password.txt");
		@SuppressWarnings("resource")
		BufferedReader brr = new BufferedReader(readerPass);
		while ((password = brr.readLine()) != null) {

		    System.out.println("password= " +password);
		    lib.sendKeys(txtPassword, password);
		}
		
		lib.click(btnLoginGirisi);
		lib.click(closePoPuPMainPage);
		lib.Control(lib.isElementExist(txtHesabim), "Giris Yapildi", "Giris Yapilamadi");
		
		return this;
		
	}
}