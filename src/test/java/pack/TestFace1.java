package pack;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import objetmodele.home;

import java.io.IOException;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
public class TestFace1 extends Base {
	//annotation
	
		
		@Test (dataProvider = "driveTest")

		public void test1(String email, String password, String titre) {
			
			home hp = new home(driver);

			//WebElement mail = driver.findElement(By.id("email"));
			WebElement getinputemail = hp.getemail();

			getinputemail.sendKeys(email);
			
			

			//WebElement pass = driver.findElement(By.id("pass"));
			WebElement getinputpassword = hp.getpassword();

			getinputpassword.sendKeys(password);

			//WebElement buttonlogin = driver.findElement(By.name("login"));
			WebElement getinputlogin = hp.getlogin();

			getinputlogin.click();

			

			//WebElement lienOublié = driver.findElement(By.linkText("Forgot password?"));
			WebElement getinputforget  = hp.getforget();


			getinputforget.click();

			

			Assert.assertEquals(driver.getTitle(), titre);

		}

		

		

		

		DataFormatter formatter = new DataFormatter(); 

		@DataProvider(name ="driveTest")

		public Object[][] getData() throws IOException

		{

			//mchina jebna l fichier excel mte3na eli fih les donné de test w ya9rah 

		FileInputStream fis=new FileInputStream("C:\\Users\\KHADIJA\\Desktop\\MavenProject\\my-app\\src\\test\\resources\\testdata.xlsx");

		try (XSSFWorkbook wb = new XSSFWorkbook(fis)) {

			// ye5ouli num de page eli chn9ara menha , 0 num de page c a dire l page loula

			XSSFSheet sheet=wb.getSheetAt(0); 

			

			// e7seb nombre de ligne eli  f page

			int rowCount=sheet.getPhysicalNumberOfRows();

			

			// 5dhina 1er ligne (getRow) w 7sebna 3dad les colonne ei f ligne heki  

			XSSFRow row=sheet.getRow(0);

			int colCount=row.getLastCellNum(); 

			

			// star hedhe eli yebda b Object howa tebe3 association de testng avec le fichier excel 

			Object data[][] = new Object [rowCount - 1][colCount];



			for(int i=0;i<rowCount-1;i++)

			{

			row=sheet.getRow(i+1);           

			

			for(int j=0;j<colCount;j++)

			{

			XSSFCell cell = row.getCell(j);

			data[i][j] = formatter.formatCellValue(cell);

			}

			}

			return data;

		}
		}
		}

	
		
		
		/*public void Test2() throws InterruptedException {
		
		WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
		
		inputEmail.sendKeys("foulen@gmail.com");
		
		Thread.sleep(2000);
		
		WebElement inputPass = driver.findElement(By.cssSelector("#pass"));
		inputPass.sendKeys("password");
		
		WebElement boutonSeConnecter = driver.findElement(By.name("login"));
		boutonSeConnecter.click();
		
	    driver.findElement(By.linkText("Mot de passe oublié ?")).click();
	    
	}

		@Test
		@Parameters({"email","password"})
		
		public void Test3( ) throws InterruptedException {
			
		
		
		WebElement inputEmail = driver.findElement(By.xpath("//input[@id='email']"));
		
		inputEmail.sendKeys("foulen@gmail.com");
		
		Thread.sleep(2000);
		
		WebElement inputPass = driver.findElement(By.cssSelector("#pass"));
		inputPass.sendKeys("password");
		
		WebElement boutonSeConnecter = driver.findElement(By.name("login"));
		boutonSeConnecter.click();
		
	    driver.findElement(By.linkText("Mot de passe oublié ?")).click();
	    
	}
		
		
	}*/


