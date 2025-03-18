package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SigninPage extends BaseClass {

	public SigninPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "Email")
	private WebElement emailTextField;
	
	@FindBy(id = "Password")
	private WebElement passwordTextField;
	
	@FindBy(xpath ="//input[@value='Log in']")
	private WebElement loginButton;
	
	/*
	 * this method will perform login operation
	 */
	public void toSignIn(String username,String password)
	{
		emailTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
		
	}

}
