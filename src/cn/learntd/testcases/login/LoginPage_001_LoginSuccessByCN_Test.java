/**
 * 
 */
package cn.learntd.testcases.login;

import org.testng.Assert;
import org.testng.annotations.Test;

import cn.learntd.base.BaseParpare;
import cn.learntd.pages.login.LoginPage;

/**
 * @author Administrator
 * Create time:2017-03-06 下午9:33:57
 * Desciption:
 */
public class LoginPage_001_LoginSuccessByCN_Test extends BaseParpare{

	@Test
	public void loginSuccess(){
		commonOperUtil.waitForPageLoad(timeOut);
		commonOperUtil.senkeys(LoginPage.USER_INPUT, "admin");
		commonOperUtil.senkeys(LoginPage.PASSWORD_INPUT, "123456");
		commonOperUtil.click(LoginPage.SUBMIT_BTN);
		Assert.assertEquals(commonOperUtil.getText(LoginPage.EDIT_MY_IFO), "编辑我的信息");
		
	}
}
