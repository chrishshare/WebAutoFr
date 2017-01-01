package cn.learntd.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoTestCase {

	public static void main(String[] args){
		WebDriver foxdriver = new FirefoxDriver();
		foxdriver.get("https://www.baidu.com");
		WebElement searchInput = foxdriver.findElement(By.id("kw"));
		searchInput.sendKeys("selenium");
		WebElement searchBtn = foxdriver.findElement(By.id("su"));
		searchBtn.click();
		foxdriver.quit();
	}
}
