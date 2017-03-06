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
public class LoginPage_001_LoginSuccessByEN_Test extends BaseParpare{

	@Test
	public void loginSuccess(){
		commonOperUtil.waitForPageLoad(timeOut);
		commonOperUtil.select(LoginPage.LANG_BOX, 1);
		Assert.assertEquals(commonOperUtil.getText(LoginPage.USER_LABEL), "Username");
		commonOperUtil.senkeys(LoginPage.USER_INPUT, "admin");
		Assert.assertEquals(commonOperUtil.getText(LoginPage.PASSWORD_LABEL), "Password");
		commonOperUtil.senkeys(LoginPage.PASSWORD_INPUT, "123456");
		Assert.assertEquals(commonOperUtil.getText(LoginPage.LANG_LABEL), "Language");
		Assert.assertEquals(commonOperUtil.getText(LoginPage.REMME_LABEL), "Remember me");
		commonOperUtil.click(LoginPage.SUBMIT_BTN);
		Assert.assertEquals(commonOperUtil.getText(LoginPage.EDIT_MY_IFO), "Edit My Info");
		
	}
}
