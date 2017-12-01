package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class RespositoryParser {

	private static Logger Log = Logger.getLogger(RespositoryParser.class);
	private FileInputStream stream;
	private String RepositoryFile;
	private Properties propertyFile = new Properties();

	public RespositoryParser(String fileName) throws IOException
	{
		//this.RepositoryFile = fileName;
		//stream = new FileInputStream(RepositoryFile);
		//propertyFile.load(stream);
		
	//	Properties properties = null;

		try {
			//propertyFile = new Properties();
		    InputStream resourceAsStream =  RespositoryParser.class.getClassLoader().getResourceAsStream(fileName);
		    if (resourceAsStream != null) {
		    	propertyFile.load(resourceAsStream);
		    }
		  
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	public By getbjectLocator(String locatorName)
	{
		String locatorProperty = propertyFile.getProperty(locatorName);
		System.out.println("Abhishek"+locatorProperty.toString());
		String locatorType = locatorProperty.split(":")[0];
		String locatorValue = locatorProperty.split(":")[1];

		By locator = null;
		switch(locatorType)
		{
		case "Id":
			locator = By.id(locatorValue);
			break;
		case "Name":
			locator = By.name(locatorValue);
			break;
		case "CssSelector":
			locator = By.cssSelector(locatorValue);
			break;
		case "LinkText":
			locator = By.linkText(locatorValue);
			break;
		case "PartialLinkText":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TagName":
			locator = By.tagName(locatorValue);
			break;
		case "Xpath":
			locator = By.xpath(locatorValue);
			break;
		}
		return locator;
	}
}