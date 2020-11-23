package com.trendyol.test.selenium.trendyol;

import com.trendyol.pages.selenium.trendyol.PageTrendyolLogin;
import com.trendyol.pages.selenium.trendyol.Trendyol;
import org.testng.annotations.Test;

import java.io.IOException;

public class TrendyolLoginTest extends Trendyol {
	PageTrendyolLogin lib = new PageTrendyolLogin(driver);
@Test
public void TrendyolSenaryo() throws InterruptedException, IOException {
	startTest().login().UrunArama("bilgisayar")
	.UrunSec()
	.SepetimUrunFiyatKarsilastir()
	.SepetimUrunAdetArtir();
}

}