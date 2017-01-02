/**
 * 
 */
package cn.learntd.utils;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestContext;

/**
 * @author zhousiyuan
 * Create time:2017-01-02 上午9:02:19
 * Desciption:浏览器选择，根据不同系统平台自动决定使用什么平台
 */
public class ChooseBrowser {

	static Logger logger = Logger.getLogger(ChooseBrowser.class.getName());
	
	public WebDriver selectBrowserByName(String browser,ITestContext context){
		Properties properties = System.getProperties(); //获取系统属性集
		String currentPlatform = properties.getProperty("os.name");
		String arch = properties.getProperty("os.arch");
		logger.info("您当前的操作系统是：[" + currentPlatform + "]"); //获取系统名称
		logger.info("您当前的操作系统架构是：[" + arch + "]"); //获取系统是x64还是x86
		logger.info("启动的浏览器是：[" + browser + "]");
		String driverConfigFilePath = context.getCurrentXmlTest().getParameter("driverConfigFilePath");
		
		//驱动声明
		String chromeDriver_win = PropertiesDataProvider.getProData(driverConfigFilePath, "chromeDriver_win");
		String chromeDriver_linux = PropertiesDataProvider.getProData(driverConfigFilePath, "chromeDriver_linux");
		
		String firefoxDriver_linux = PropertiesDataProvider.getProData(driverConfigFilePath, "firefoxDriver_linux");
		
		if(currentPlatform.toLowerCase().contains("win")){//windows 平台
			if(browser.equalsIgnoreCase("ie")){
				String ieDriver = PropertiesDataProvider.getProData(driverConfigFilePath, "ieDriver");
				System.setProperty("webdriver.ie.driver",ieDriver);
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				return new InternetExplorerDriver(ieCapabilities);
			}else if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver",chromeDriver_win);
				return new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")){
				String firefoxDriver_win = PropertiesDataProvider.getProData(driverConfigFilePath, "firefoxDriver_win");
				System.setProperty("webdriver.gecko.driver",firefoxDriver_win);
				DesiredCapabilities firefoxCapabilities = DesiredCapabilities.firefox();
				return new FirefoxDriver(firefoxCapabilities);
			}else{
				logger.error("The [" + browser + "]" + " explorer is not applicable  for  [" + currentPlatform + "] OS");
				Assert.fail("The [" + browser + "]" + " explorer does not apply to  [" + currentPlatform + "] OS");
			}
		}else if(currentPlatform.toLowerCase().contains("linux")){
			if(browser.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", chromeDriver_linux);
				return new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")){
				return new FirefoxDriver();
			}else{
				logger.error("The [" + browser + "]" + " explorer is not applicable  for  [" + currentPlatform + "] OS");
				Assert.fail("The [" + browser + "]" + " explorer does not apply to  [" + currentPlatform + "] OS");
			}
		}else{
			logger.error("The [" + currentPlatform + "] is not supported for this automation frame,please change the OS(Windows,MAC or LINUX)");
			Assert.fail("The [" + currentPlatform + "] is not supported for this automation frame,please change the OS(Windows,MAC or LINUX)");
		}
			return null;

	}
}
