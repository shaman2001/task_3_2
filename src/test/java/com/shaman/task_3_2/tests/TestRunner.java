package com.shaman.task_3_2.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;

public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final TestNG testNG = new TestNG(true);
		testNG.setTestClasses(new Class[] {BasePassPlaneTest.class});
		XmlSuite suite = new XmlSuite();
		suite.setName("TmpSuite");
		suite.setParallel(XmlSuite.ParallelMode.METHODS);
		suite.setThreadCount(4);
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		testNG.setXmlSuites(suites);
		//testNG.setExcludedGroups("optional");
		testNG.run();
	}

}
