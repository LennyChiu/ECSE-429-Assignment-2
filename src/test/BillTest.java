package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bill.Bill;

public class BillTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testcase1() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
		aBill.modify();
		assertEquals("inPreparation", aBill.getBillState());
		
		//Sneak Paths
		aBill.votePasses();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.voteFails();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.withdraw();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.royalAssent();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.modify();
		assertEquals("inPreparation", aBill.getBillState());
	}
	
	@Test
	public void testcase2() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.voteFails();
		assertEquals("withdrawn", aBill.getBillState());
		
		//Sneak Paths
		aBill.votePasses();
		assertEquals("withdrawn", aBill.getBillState());
		aBill.modify();
		assertEquals("inPreparation", aBill.getBillState());
	}
}