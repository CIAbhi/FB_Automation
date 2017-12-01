package test.java;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//   CommandLineOptions options = new CommandLineOptions();
		   // JCommander jCommander = new JCommander(options, args);

		    XmlSuite suite = new XmlSuite();
		    suite.setName("testng.xml");
	//	    suite.setParameters(options.convertToMap());

		    List<XmlClass> classes = new ArrayList<XmlClass>();
		  classes.add(new XmlClass("test.java.DriverScriptTest"));

		    XmlTest test = new XmlTest(suite);
		    test.setName("testng.xml");
		    test.setXmlClasses(classes);

		    List<XmlSuite> suites = new ArrayList<XmlSuite>();
		    suites.add(suite);

		    TestNG testNG = new TestNG();
		    testNG.setXmlSuites(suites);
		    testNG.run();

	}

}
