package Master.Screenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class ScreenShotMaster {

	public void CaptureFullScreen(String chromeDriverpath,String url,String pngDestinationLocation) {
		WebDriver driver;                                   
		System.setProperty("webdriver.chrome.driver", chromeDriverpath);             
		driver=new ChromeDriver();             
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);             
		driver.manage().window().maximize();             
		driver.get(url);              
		//take screenshot of the entire page             
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);             
		try {                 
			ImageIO.write(screenshot.getImage(),"PNG",new File(pngDestinationLocation));             
		} catch (IOException e) {                 // TODO Auto-generated catch block                 
			e.printStackTrace();  
		}  
		driver.quit(); 
	}
	
	

}
