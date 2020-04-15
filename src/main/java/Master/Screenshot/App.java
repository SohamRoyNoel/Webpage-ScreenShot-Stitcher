package Master.Screenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;


public class App 
{
	public static void main( String[] args ) throws  MalformedURLException, IOException, InvalidFormatException, XmlException
	{
		ScreenShotMaster sm = new ScreenShotMaster();
		String chromeDriverpath = "E:\\Jars\\ChromeDriver-79\\chromedriver.exe";
		String url = "https://mvnrepository.com/";
		String pngLocation = "D:\\New Java Workspace\\ScreenShots\\Screenshot\\OP\\ScreenOP.png";
		String docxDestination = "D:\\New Java Workspace\\ScreenShots\\Screenshot\\OP\\ScreenOP.docx";
		String pdfDestination = "D:\\New Java Workspace\\ScreenShots\\Screenshot\\OP\\ScreenOP.pdf";
		File fl = new File(pngLocation);
		
		sm.CaptureFullScreen(chromeDriverpath, url, pngLocation);
		
		/*
		 * Generates The word Document
		 * */
		WordConverter wc = new WordConverter();
		wc.addImagesToWordDocument(fl, docxDestination);
		
		/*
		 * Generate PDF FORMAT
		 * */
		PDFConverter pcv = new PDFConverter();
		pcv.generatePDFFromImage(pdfDestination, pngLocation);
		
	}

}
