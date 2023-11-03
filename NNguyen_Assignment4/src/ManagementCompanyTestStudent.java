/*
* Class: CMSC203
* Instructor: Professor Monshi
* Description: Tests the ManagementCompany class
* Due: 11/06/2023
* Platform/compiler: javac
* I pledge that I have completed the programming assignment
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
* Print your Name here: Nicholas Nguyen
*/

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManagementCompanyTestStudent {
	Property sampleProperty, sampleProperty2;
	ManagementCompany managementCo;

	@Before
	public void setUp() throws Exception {
		managementCo= new ManagementCompany("Nick", "782340",2);
	}

	@After
	public void tearDown() throws Exception {
		managementCo=null;
	}

	@Test
	public void testAddProperty1() {
		sampleProperty = new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3);
		assertEquals(0,managementCo.addProperty(sampleProperty),0);
	}

	@Test
	public void testAddProperty2() {
		sampleProperty = new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3);

		String name = sampleProperty.getPropertyName();
		String city = sampleProperty.getCity();
		double rentAmount = sampleProperty.getRentAmount();
		String owner = sampleProperty.getOwner();

		assertEquals(0,managementCo.addProperty(name, city, rentAmount, owner),0);
	}

	@Test
	public void testAddProperty3() {
		sampleProperty = new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3);

		String name = sampleProperty.getPropertyName();
		String city = sampleProperty.getCity();
		double rentAmount = sampleProperty.getRentAmount();
		String owner = sampleProperty.getOwner();
		int x = sampleProperty.getPlot().getX();
		int y = sampleProperty.getPlot().getY();
		int width = sampleProperty.getPlot().getWidth();
		int depth = sampleProperty.getPlot().getDepth();

		assertEquals(0,managementCo.addProperty(name, city, rentAmount, owner, x, y, width, depth),0);
	}

	@Test
	public void testGetPropertiesCount() {
		sampleProperty = new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3);
		assertEquals(0,managementCo.addProperty(sampleProperty),0);
		assertEquals(1, managementCo.getPropertiesCount());
	}

	@Test
	public void testGetTotalRent() {
		sampleProperty = new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3);
		assertEquals(0,managementCo.addProperty(sampleProperty),0);
		assertEquals(1000, managementCo.getTotalRent());
	}

	@Test
	public void testGetName() {
		assertEquals("Nick", managementCo.getName());
	}

	@Test
	public void testGetTaxID() {
		assertEquals("782340", managementCo.getTaxID());
	}

	@Test
	public void testGetProperties() {
		sampleProperty = new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3);
		Property[] propertyArray = new Property[managementCo.getProperties().length];
		propertyArray[0] = sampleProperty;
		assertEquals(sampleProperty, propertyArray[0]);
	}


	@Test
	public void testIsManagementFeeValid() {
		managementCo= new ManagementCompany("Nick", "782340",2);
		assertTrue(managementCo.isManagementFeeValid());
	}

	@Test
	public void testGetPlot() {
		sampleProperty = new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3);
		assertEquals("4,7,3,3", sampleProperty.getPlot().toString());
	}

	@Test
	public void testGetMgmFeePer() {
		managementCo= new ManagementCompany("Nick", "782340",2);
		managementCo.addProperty(new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3));

		assertEquals(20, managementCo.getMgmFeePer());
	}

	@Test
	public void testRemoveLastProperty() {
		sampleProperty = new Property("Chipotle", "Germantown", 1000.0, "Tom Holland", 0, 0, 8, 8);

		managementCo.addProperty(sampleProperty);
		assertEquals(1, managementCo.getPropertiesCount());

		managementCo.removeLastProperty();
		assertEquals(0, managementCo.getPropertiesCount());
	}

	@Test
	public void testIsPropertiesFull() {
		managementCo= new ManagementCompany("Nick", "782340",2);
		managementCo.addProperty(
				new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3)
		);

		assertFalse(managementCo.isPropertiesFull());
	}


	@Test
	public void testGetHighestRentProperty() {
		sampleProperty = new Property("Burger King", "New York", 1300.0, "John Doe", 2,2,6,6);
		sampleProperty2 = new Property("Subway", "Los Angeles", 1100.0, "Emily Johnson", 4,4,3,3);


		managementCo.addProperty(sampleProperty);
		System.out.println(managementCo.addProperty(sampleProperty2));


		System.out.println(managementCo.getPropertiesCount());


	}


	@Test
	public void testToString() {
		sampleProperty = new Property ("Chipotle", "Germantown", 1000.0, "Tom Holland", 4,7,3,3);
		assertEquals(0, managementCo.addProperty(sampleProperty));
		String expectedString = "List of the properties for Nick, taxID: 782340\n"
				+ "______________________________________________________\n"
				+ "Chipotle,Germantown,Tom Holland,1000.0\n"
				+ "______________________________________________________\n"
				+"\n"
				+ " total management Fee: 20.0";
		System.out.println(expectedString);
		System.out.println(managementCo.toString());
		assertEquals(expectedString, managementCo.toString());

	}

}
