package test.java;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;
import org.testng.collections.Lists;



public class MainOne2 {
	final static Logger Log = Logger.getLogger(MainOne2.class);
    public static void main(String[] args) {
    	// Create object of TestNG Class
    	TestNG runner=new TestNG();

    	// Create a list of String 
    	List<String> suitefiles=new ArrayList<String>();

    	// Add xml file which you have to execute
    	suitefiles.add("testng.xml");
    	

    	// now set xml file for execution
    	runner.setTestSuites(suitefiles);

    	// finally execute the runner using run method
    	runner.run();
    } 
}