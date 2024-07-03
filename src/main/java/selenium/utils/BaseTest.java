package selenium.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

public class BaseTest extends Driver{
	
public WebDriver driver; //l am facut static pentru a avea un singur obiect, altfel cand s a facut mostenirea se pierde 

public JavascriptExecutor jse;

/*
   @BeforeClass
   public void deleteAllCookies() {                      //daca nu folosim @AfterClass ca sa inchdem browserul atunci trebuie sa stergem cookie urile ca sa nu incarc memoria si sa nu ramana in memorie
	   
	   driver.manage().deleteAllCookies();
   }
	*/


    @Parameters({"appUrl", "browser"})
	@BeforeClass
	public void setup(String URL, String browser) throws InterruptedException {
		
		//driver = new ChromeDriver();
    	
    	driver = initDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // se adauga in Base Test si nu in @Test pentru ca e o actiune generala
		//driver.get("https://keybooks.ro");
		jse = (JavascriptExecutor) driver;
		driver.get(URL);
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000); //pauza de 5sec executiei, este bad practice in testarea automata
		driver.quit();	
	}
	
	@AfterClass   //ruleaza dupa fiecare test case @Test  
	public void recordFailure(ITestResult result) {
		
		//va face printscreen dupa fiecare methoda care este failed
		if(result.getStatus() == ITestResult.FAILURE) {                      //ITestResult  este listner din testng
			TakesScreenshot obj = (TakesScreenshot) driver;
			File picture = obj.getScreenshotAs(OutputType.FILE);
			
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
			
			try {
				Files.copy(picture, new File("poze/"+result.getName() + "-"+timestamp +".png"));  //se poate salva si direct pe un hard extern
				                                        //getName aduce numele metodei care a picat
				                                        
			}catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		
	}

}
