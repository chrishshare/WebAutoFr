package cn.learntd.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import cn.learntd.base.BaseParpare;

public class Demo_001_DemoTestCase_Test extends BaseParpare{

	@Test
	public void search(){
		
		WebElement textInput = commonOperUtil.driver.findElement(By.id("kw"));
		textInput.sendKeys("selenium");
	}
}
