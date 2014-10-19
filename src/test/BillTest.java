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
		System.out.println(aBill.getBillState());
		aBill.voteFails();
		//error: should go to withdrawn state, but enters secondReading instead
		assertEquals("withdrawn", aBill.getBillState());

		//Sneak Paths
		aBill.votePasses();
		assertEquals("withdrawn", aBill.getBillState());
		aBill.voteFails();
		assertEquals("withdrawn", aBill.getBillState());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("withdrawn", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("withdrawn", aBill.getBillState());
		aBill.royalAssent();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase3() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase4() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.voteFails();
		//error
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase5() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase6() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());
		aBill.voteFails();
		//error
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase7() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("thirdReading", aBill.getBillStateInHouseOfCommons());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase8() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("thirdReading", aBill.getBillStateInHouseOfCommons());
		aBill.voteFails();
		//error
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase9() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("thirdReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
	}
	
	@Test
	public void testcase10() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("thirdReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		//error
		assertEquals("awaitingRoyalAssent", aBill.getBillState());
		aBill.royalAssent();
		assertEquals("actOfParliament", aBill.getBillState());
	}
	
	@Test
	public void testcase11() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase12() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.voteFails();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase13() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase14() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.voteFails();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase15() {
		//Conformance Test
		Bill aBill = new Bill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
	}
}