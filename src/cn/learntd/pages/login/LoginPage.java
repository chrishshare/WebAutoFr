/**
 * 
 */
package cn.learntd.pages.login;

import org.openqa.selenium.By;

/**
 * @author Administrator
 * Create time:2017-03-06 下午9:17:34
 * Desciption:
 */
public class LoginPage {
	
	/**user name label*/
	public static final By USER_LABEL = By.id("ForTestUserName");
	/**user name input*/
	public static final By USER_INPUT = By.id("LoginForm_username");
	/**user password label*/
	public static final By PASSWORD_LABEL = By.id("ForTestUserPWD");
	/**user password input*/
	public static final By PASSWORD_INPUT = By.id("LoginForm_password");
	/**select lang label*/
	public static final By LANG_LABEL = By.id("ForLanguage");
	/**select lang box*/
	public static final By LANG_BOX = By.id("LoginForm_language");
	/**rememerme checkbox*/
	public static final By REMME_CHECKBOX = By.id("LoginForm_rememberMe");
	/**rememberme label*/
	public static final By REMME_LABEL = By.id("ForRememberMe");
	/**submit button*/
	public static final By SUBMIT_BTN = By.id("SubmitLoginBTN");
	
	/**homepage edit my info*/
	public static final By EDIT_MY_IFO = By.xpath(".//*[@id='top']/div[3]/a[1]");

}
