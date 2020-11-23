package com.trendyol.pages.selenium.trendyol;

import com.trendyol.commons.selenium.TrendyolCommons;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PageTrendyolUrunler {
	TrendyolCommons lib;
	
public PageTrendyolUrunler(TrendyolCommons lib) {
	this.lib=lib;
	PageFactory.initElements(this.lib.driver, this);
		
}

@FindBy (how =How.XPATH, using ="//div[@class='prdct-cntnr-wrppr']//div[1]//div[1]//a[1]//div[1]//div[1]//img[1]")
WebElement btnUrunSec;
@FindBy (how =How.XPATH, using ="//body/div[@id='container']/div[@id='search-app']/div[@class='search-app-container']/div[@class='srch-rslt-cntnt']/div[@class='srch-prdcts-cntnr']/div/div[@class='prdct-cntnr-wrppr']/div[1]/div[1]/a[1]/div[3]/div[1]/div[1]")
WebElement txtUrunAdi;
@FindBy (how =How.CSS, using ="[class='prc-slg']")
WebElement txtUrunFiyati;
@FindBy (how =How.CSS, using ="#product-detail-app > div > div.pr-cn > div.pr-cn-in > div.pr-in-at > div:nth-child(6) > button.pr-in-btn.add-to-bs > div.add-to-bs-tx")
WebElement btnSepeteEkle;
@FindBy (how =How.ID, using ="myBasketListItem")
WebElement btnSepetim;



public PageTrendyolSepetim UrunSec() throws IOException, InterruptedException {
	
	String urunAdi= lib.getTextOfElement(txtUrunAdi);
	FileWriter  writerUrunAdi= new FileWriter(System.getProperty("user.dir") + "/UrunAdi.txt");
	PrintWriter brr = new PrintWriter(writerUrunAdi);
	brr.println(urunAdi);
	brr.close();
	
	
	lib.click(btnUrunSec);
	
	String urunFiyati= lib.getTextOfElement(txtUrunFiyati);
	FileWriter  writerUrunFiyati= new FileWriter(System.getProperty("user.dir") + "/UrunFiyati.txt");
	PrintWriter brru = new PrintWriter(writerUrunFiyati);
	brru.println(urunFiyati);
	brru.close();
	Thread.sleep(2000);
	lib.click(btnSepeteEkle);
	lib.click(btnSepeteEkle);
	Thread.sleep(2000);
	lib.click(btnSepetim);
	return new PageTrendyolSepetim(lib);
}

}