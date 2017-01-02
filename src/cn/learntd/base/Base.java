/**
 * 
 */
package cn.learntd.base;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cn.learntd.utils.CommonOperUtil;

/**
 * @author Administrator
 * Create time:2017-01-02 上午8:54:34
 * Desciption:
 */
public class Base {
	
	static Logger logger = Logger.getLogger(Base.class.getName());
	protected CommonOperUtil operUtil = null;
	protected ITestContext iTestContext = null;
	int timeout = 0;
	String weburl = "";
	@BeforeClass
	public void startTest(ITestContext context){
		operUtil = new CommonOperUtil();
		this.iTestContext = context;
		String browserName = context.getCurrentXmlTest().getParameter("");
		timeout = Integer.valueOf(context.getCurrentXmlTest().getParameter("timeout"));
		try {
			operUtil.launchBrowser(browserName, context, weburl, timeout);
		} catch (Exception e) {
			logger.error("浏览器工作异常",e);
		}
		//设置一个testng上下文属性，将driver存起来，之后可以使用context随时取到，主要是提供arrow 获取driver对象使用的，因为arrow截图方法需要一个driver对象
		iTestContext.setAttribute("SELENUIM_DRIVER", operUtil.driver);
	}
	
	@AfterClass
	public void endTest(){
		if(operUtil.driver != null){
			operUtil.driver.quit();
		}else{
			logger.error("浏览器driver没有获得对象,退出操作失败");
			Assert.fail("浏览器driver没有获得对象,退出操作失败");
		}
	}

}
