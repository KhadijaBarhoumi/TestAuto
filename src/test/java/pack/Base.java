package pack;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class Base {

	public static WebDriver driver;



	@BeforeMethod

	public void avant() throws IOException {

		// Ajouter le pilote

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\KHADIJA\\Desktop\\testauto\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");


		// Création d'une instance du WebDriver (ChromeDriver) : ouvrir navigateur

		// chrome

		driver = new ChromeDriver();



		// Maximisation de la fenêtre du navigateur

		driver.manage().window().maximize();



		// Ouverture de l'URL de Facebook :
		Properties prop = new Properties();

		FileInputStream FIchier = new FileInputStream(

				"C:\\Users\\KHADIJA\\Desktop\\MavenProject\\my-app\\data.properties");

		prop.load(FIchier);

		driver.get(prop.getProperty("url"));



		

	}

	

	@AfterMethod

	

	public void after() {

		driver.quit();

	}
	
	public void impecran() 
	{
	TakesScreenshot scrShot = ((TakesScreenshot) driver ) ;
	File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
	long a = System.currentTimeMillis();
	File DestFile = new File ("C:\\Users\\KHADIJA\\Desktop\\testauto\\screen\\imp" + a + "sccrrr.png"); 
	try {
		FileUtils.copyFile(ScrFile, DestFile);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}
