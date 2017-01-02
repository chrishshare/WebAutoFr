/**
 * 
 */
package cn.learntd.utils;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;

/**
 * @author zhousiyuan
 * Create time:2017-01-02 上午10:21:36
 * Desciption:
 */
public class CommonOperUtil {

	public static Logger logger = Logger.getLogger(CommonOperUtil.class.getName());
	public ITestResult it = null;
	public WebDriver driver = null;
	public WebDriver window = null;
	/**
	 * 启动浏览器,将浏览器最大化，并打开测试页面
	 * @param browserName
	 * @param context
	 * @param weburl
	 * @param timeout
	 */
	public void launchBrowser(String browserName,ITestContext context,String weburl,int timeout){
		ChooseBrowser browser = new ChooseBrowser();
		driver = browser.selectBrowserByName(browserName, context);
		try {
			driver.manage().window().maximize();//最大化浏览器
			waitForPageLoad(timeout);
			openTestUrl(weburl);
		} catch (Exception e) {
			logger.warn("页面加载失败，请重试...");
			refresh();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			String status= (String)js.executeScript("return document.readyState");
			logger.info("状态："+status);
		}
	}
	
	/**
	 * 等待页面加载完成
	 * @param timeout
	 */
	public void waitForPageLoad(int timeout){
		driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
	}
	
	/**
	 * 打开测试网址
	 * @param url
	 */
	public void openTestUrl(String url){
		driver.get(url);
		logger.info("打开测试网址：" + url);
	}
	/**
	 * 刷新页面
	 */
	public void refresh(){
		driver.navigate().refresh();
		logger.info("页面刷新成功！");
	}
}
