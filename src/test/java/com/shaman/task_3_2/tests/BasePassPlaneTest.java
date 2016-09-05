package com.shaman.task_3_2.tests;

import java.util.Date;

import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.Assert;

import com.shaman.task_3_2.classes.*;
//import com.shaman.task_3_2.classes.Plane;

public class BasePassPlaneTest {
	PassPlane testPassPlane = null;
	//Plane testPassPlane = new PassPlane("Сухой", "SSJ-95LR", 925, 3.576f, 15.805f, 98);
	
	private void checkTime() {
		System.out.println("Current time: " + new Date(System.currentTimeMillis()));
	}
	
	@BeforeClass
	public void createObject() {
		testPassPlane = new PassPlane("Сухой", "SSJ-95LR", 925, 3.576f, 15.805f, 98);
		//testPassPlane = new PassPlane();
		System.out.println("Объект создан успешно");
		checkTime();
	}
	@BeforeMethod
	public void timeChecking() {
		checkTime();
	}
	
	@Test(description="toString method test",enabled = true)
  	public void toStringTest() {
		String testString = testPassPlane.toString();
		Assert.assertEquals(testString, "пассажирский самолет Сухой SSJ-95LR кр.скорость-925 км/ч, макс.дальность-4419.743 км, пассажировместимость-98 мест");
	}
	@Test(description="getSeating test",enabled = true)
  	public void getSeatingTest() {
		Assert.assertEquals(testPassPlane.getSeating(),98);
	}
	
	@Test(description="setSeating  test",dependsOnMethods = "getSeatingTest",enabled = true)
  	public void setSeatingTest() {
		testPassPlane.setSeating(120);
		Assert.assertEquals(testPassPlane.getSeating(),120);
		checkTime();
	}
	@Test(description="getMfact  test",enabled = true)
  	public void getMfactTest() {
		Assert.assertEquals(testPassPlane.getMfact(),"Сухой");
	}
	@Parameters({"mfact-name"})
	@Test(description="setMfact  test",dependsOnMethods = "getMfactTest",enabled = true)
  	public void setMfactTest(@Optional(value = "Cessna") String mfact) {
		testPassPlane.setMfact(mfact);
		Assert.assertEquals(testPassPlane.getMfact(),mfact);
		System.out.println(mfact);
	}
	@Test(description="getModel  test",enabled = true)
  	public void getModelTest() {
		Assert.assertEquals(testPassPlane.getModel(),"SSJ-95LR");
	}
	@Parameters({"model-name"})
	@Test(description="setModel  test",dependsOnMethods = "getModelTest",enabled = true)
  	public void setModelTest(@Optional(value = "Mig-29_Fulcrum") String model)  {
		testPassPlane.setMfact(model);
		Assert.assertEquals(testPassPlane.getMfact(),model);
		System.out.println(model);
	}
	@Test(description="getCSpeed  test",enabled = true)
  	public void getCSpeedTest() {
		Assert.assertEquals(testPassPlane.getCspeed(),925);
	}
	@Test(description="setCSpeed  test",dependsOnMethods = "getCSpeedTest",enabled = true)
  	public void setCSpeedTest() {
		testPassPlane.setCspeed(1000);
		Assert.assertEquals(testPassPlane.getCspeed(),1000);
	}
	//<<------->>
	@Test(description="getFcons  test",enabled = true)
  	public void getFconsTest() {
		Assert.assertEquals(testPassPlane.getFcons(),3.576f);
	}
	@Test(description="setFcons  test",dependsOnMethods = "getFconsTest",enabled = true)
  	public void setFconsTest() {
		testPassPlane.setFcons(9.645f);
		Assert.assertEquals(testPassPlane.getFcons(),9.645f);
	}
	//<<------->>
	@Test(description="getTcapacity test",enabled = true)
	public void getTcapacityTest() {
		Assert.assertEquals(testPassPlane.getTcapacity(),15.805f);
	}
	@Parameters({"tcapas"})
	@Test(description="setTcapacity test",dependsOnMethods = "getTcapacityTest",enabled = true)
	public void setTcapacityTest(@Optional(value = "16.0f") float tcap) {
		testPassPlane.setTcapacity(tcap);
		Assert.assertEquals(testPassPlane.getTcapacity(),tcap);
		System.out.println("Set tank capacity " + testPassPlane.getTcapacity());
	}
	@Test(description="getFquantity test",dependsOnMethods = "setTcapacityTest",enabled = true)
	public void getFquantityTest() {
		Assert.assertEquals(testPassPlane.getFquantity()!=0,true);
	}
	@Parameters({"fuelqty"})
	@Test(description="setTFquantity",dependsOnMethods = {"getFquantityTest","setTcapacityTest"},enabled = true)
	public void setFquantityTest(@Optional(value = "3.0f") float fqty) {
		testPassPlane.setFquantity(fqty);
		Assert.assertEquals(testPassPlane.getFquantity(),fqty);
	}

	/*@BeforeMethod
	public void refuelingTestPrepare() {
			testPassPlane.setFquantity(3.0f);
	}*/
	/*@Test(description="refuelling method test",dependsOnMethods = {"setTcapacityTest","setFquantityTest"}, enabled = true, priority=1)
	public void refuelingTest() {
		testPassPlane.setFquantity(3.0f);
		testPassPlane.refueling(8.0f);
		Assert.assertEquals(testPassPlane.getFquantity(),11.0f);
		checkTime();
	}*/
	
	@Test(description="refuelling method test",priority=1,enabled=true,dataProvider="refuelingDP",dependsOnMethods={"setTcapacityTest","setFquantityTest"})
	public void refuelingTest(float fuelref, float fuelqty) throws Exception {
		testPassPlane.setFquantity(3.0f);
		testPassPlane.refueling(fuelref);
	    Assert.assertEquals(testPassPlane.getFquantity(), fuelqty);
	    System.out.println("Запрошено-" + fuelref + "; Заправлено-" + testPassPlane.getFquantity() + "; Ожидалось" + fuelqty);
	}
	
	@DataProvider (name = "refuelingDP")
	public static Object[][] refuelingDP() {
		return new Object[][] {
            {3.0f, 6.0f}, 
            {10.0f, 13.0f}, 
            {15.0f, 16.0f}, 
            {17.8f, 16.0f}};
    }
	
}
