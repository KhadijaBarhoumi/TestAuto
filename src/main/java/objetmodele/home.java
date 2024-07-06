package objetmodele;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class home  {
WebDriver driver; 

	

	public home (WebDriver driver) {

		this.driver = driver;

	}

	

		By email = By.id("email");
		By password = By.id("pass");
		By login = By.name("login");
		By forget = By.linkText("Forgot password?");

	

		

		public WebElement getemail() {

			return driver.findElement(email);

		}
		
		public WebElement getpassword() {

			return driver.findElement(password);

		}

		public WebElement getlogin() {

			return driver.findElement(login);

		}
		public WebElement getforget() {

			return driver.findElement(forget);

		}
		


}
