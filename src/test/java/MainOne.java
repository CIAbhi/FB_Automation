package test.java;

import java.io.File;
import java.util.Collections;

import org.apache.log4j.Logger;
import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.MavenInvocationException;



public class MainOne {
	final static Logger Log = Logger.getLogger(MainOne.class);
    public static void main(String[] args) {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "C:/Users/Pragati Jain/workspace/CI/pom.xml" ));
        request.setGoals( Collections.singletonList( "install" ));
        DefaultInvoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
        try {
            invoker.execute( request );
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        } 
    } 
}