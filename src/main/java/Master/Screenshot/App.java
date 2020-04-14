package Master.Screenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.xmlbeans.XmlException;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;


public class App 
{
	public static void main( String[] args ) throws BadElementException, MalformedURLException, DocumentException, IOException, InvalidFormatException, XmlException
	{
		ScreenShotMaster sm = new ScreenShotMaster();
		String chromeDriverpath = "E:\\Jars\\ChromeDriver-79\\chromedriver.exe";
		String url = "https://mvnrepository.com/";
		String pngLocation = "D:\\New Java Workspace\\ScreenShots\\Screenshot\\OP\\ScreenOP.png";
		String docxDestination = "D:\\New Java Workspace\\ScreenShots\\Screenshot\\OP\\ScreenOP.docx";
		File fl = new File(pngLocation);
		
		sm.CaptureFullScreen(chromeDriverpath, url, pngLocation);
//		generatePDFFromImage();
		WordConverter wc = new WordConverter();
		wc.addImagesToWordDocument(fl, docxDestination);
		
	}
	
	private static void generatePDFFromImage(/*String filename, String extension*/) throws BadElementException, MalformedURLException, DocumentException, IOException {
	    Document document = new Document();
	    String input = "D:\\New Java Workspace\\ScreenShots\\Screenshot\\OP\\ScreenOP.png";
	    String output = "D:\\New Java Workspace\\ScreenShots\\Screenshot\\OP\\ScreenOP.pdf";
	    FileOutputStream fos = new FileOutputStream(output);
	 
	    PdfWriter writer = PdfWriter.getInstance(document, fos);
	    writer.open();
	    document.open();
	    System.out.println(input);
	    document.add(Image.getInstance(input));
	    document.close();
	    writer.close();
	}

}
