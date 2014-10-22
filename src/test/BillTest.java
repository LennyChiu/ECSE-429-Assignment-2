package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import correctedBill.CorrectedBill;

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
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
		aBill.modify();
		assertEquals("inPreparation", aBill.getBillState());
		
		//Sneak Paths
		//Test ID 1.1
		aBill.votePasses();
		assertEquals("inPreparation", aBill.getBillState());
		//Test ID 1.2
		aBill.voteFails();
		//Test ID 1.3
		assertEquals("inPreparation", aBill.getBillState());
		//Test ID 1.4
		aBill.withdraw();
		assertEquals("inPreparation", aBill.getBillState());
		//Test ID 1.5
		aBill.royalAssent();
		assertEquals("inPreparation", aBill.getBillState());
		//Test ID 1.6
		aBill.modify();
		assertEquals("inPreparation", aBill.getBillState());
	}
	
	@Test
	public void testcase2() {
		//Conformance Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		System.out.println(aBill.getBillState());
		aBill.voteFails();
		//error: should go to withdrawn state, but enters secondReading instead
		assertEquals("withdrawn", aBill.getBillState());

		//Sneak Paths
		//Test ID 2.1
		aBill.votePasses();
		assertEquals("withdrawn", aBill.getBillState());
		//Test ID 2.2
		aBill.voteFails();
		assertEquals("withdrawn", aBill.getBillState());
		//Test ID 2.3
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
		//Test ID 2.4
		aBill.introduceInHouse();
		assertEquals("withdrawn", aBill.getBillState());
		//Test ID 2.5
		aBill.introduceInSenate();
		assertEquals("withdrawn", aBill.getBillState());
		//Test ID 2.6
		aBill.royalAssent();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase3() {
		//Conformance Test
		CorrectedBill aBill = new CorrectedBill();
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
		CorrectedBill aBill = new CorrectedBill();
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
		CorrectedBill aBill = new CorrectedBill();
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
		CorrectedBill aBill = new CorrectedBill();
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
		CorrectedBill aBill = new CorrectedBill();
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
		CorrectedBill aBill = new CorrectedBill();
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
		CorrectedBill aBill = new CorrectedBill();
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
		CorrectedBill aBill = new CorrectedBill();
		aBill.setIsCommonsBill(false);
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
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase12() {
		//Conformance Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.voteFails();
		assertEquals("withdrawn", aBill.getBillState());
	}
	
	@Test
	public void testcase13() {
		//Conformance Test
		CorrectedBill aBill = new CorrectedBill();
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
		CorrectedBill aBill = new CorrectedBill();
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
		CorrectedBill aBill = new CorrectedBill();
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
	@Test
	public void testcase16() {
		//Conformance Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());
		aBill.voteFails();
		assertEquals("withdrawn", aBill.getBillState());
	}
	@Test
	public void testcase17() {
		//Conformance Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("thirdReadingS", aBill.getBillStateInSenate());
		aBill.withdraw();
		assertEquals("withdrawn", aBill.getBillState());

	}
	
	@Test
	public void testcase18() {
		//Conformance Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("thirdReadingS", aBill.getBillStateInSenate());
		aBill.voteFails();
		assertEquals("withdrawn", aBill.getBillState());

	}
	@Test
	public void testcase19() {
		//Conformance Test
		CorrectedBill aBill = new CorrectedBill();
		aBill.setIsCommonsBill(false);
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("thirdReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		//error
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());

	}
	@Test
	public void testcase20() {
		//Conformance Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("thirdReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		//error
		assertEquals("awaitingRoyalAssent", aBill.getBillState());

	}
	@Test
	public void testcase21() {
		//Sneak Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		
		aBill.introduceInSenate();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		
		aBill.royalAssent();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());

		aBill.modify();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());

		
	}
	
	@Test
	public void testcase22() {
		//Sneak Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.introduceInHouse();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		
		aBill.introduceInSenate();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		
		aBill.royalAssent();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());

		aBill.modify();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());

	}
	@Test
	public void testcase23() {
		//Sneak Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());
		
		aBill.introduceInSenate();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());
		
		aBill.royalAssent();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());

		aBill.modify();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());

	}
	
	@Test
	public void testcase24() {
		//Sneak Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInHouse();
		assertEquals("firstReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("secondReading", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("committeeConsideration", aBill.getBillStateInHouseOfCommons());
		aBill.votePasses();
		assertEquals("thirdReading", aBill.getBillStateInHouseOfCommons());

		aBill.introduceInSenate();
		assertEquals("thirdReading", aBill.getBillStateInHouseOfCommons());
		
		aBill.royalAssent();
		assertEquals("thirdReading", aBill.getBillStateInHouseOfCommons());

		aBill.modify();
		assertEquals("thirdReading", aBill.getBillStateInHouseOfCommons());

	}
	
	@Test
	public void testcase25() {
		//Sneak Test
		CorrectedBill aBill = new CorrectedBill();
		aBill.setIsCommonsBill(false);
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
		assertEquals("awaitingRoyalAssent", aBill.getBillState());

		aBill.votePasses();
		assertEquals("awaitingRoyalAssent", aBill.getBillState());
		
		aBill.voteFails();
		assertEquals("awaitingRoyalAssent", aBill.getBillState());

		aBill.withdraw();
		assertEquals("awaitingRoyalAssent", aBill.getBillState());

		aBill.introduceInHouse();
		assertEquals("awaitingRoyalAssent", aBill.getBillState());

		aBill.introduceInSenate();
		assertEquals("awaitingRoyalAssent", aBill.getBillState());

		aBill.modify();
		assertEquals("awaitingRoyalAssent", aBill.getBillState());

	}
	
	@Test
	public void testcase26() {
		//Sneak Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.introduceInHouse();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());

		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());

		aBill.royalAssent();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());

		aBill.modify();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());

		
	}
	@Test
	public void testcase27() {
		//Sneak Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.introduceInHouse();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());

		aBill.introduceInSenate();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());

		aBill.royalAssent();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());

		aBill.modify();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());

	}
	
	@Test
	public void testcase28() {
		//Sneak Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());
		aBill.introduceInHouse();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());

		aBill.introduceInSenate();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());

		aBill.royalAssent();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());

		aBill.modify();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());

	}
	
	@Test
	public void testcase29() {
		//Sneak Test
		CorrectedBill aBill = new CorrectedBill();
		assertEquals("inPreparation", aBill.getBillState());
		aBill.introduceInSenate();
		assertEquals("firstReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("secondReadingS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("committeeConsiderationS", aBill.getBillStateInSenate());
		aBill.votePasses();
		assertEquals("thirdReadingS", aBill.getBillStateInSenate());
		aBill.introduceInHouse();
		assertEquals("thirdReadingS", aBill.getBillStateInSenate());

		
		aBill.introduceInSenate();
		assertEquals("thirdReadingS", aBill.getBillStateInSenate());

		aBill.royalAssent();
		assertEquals("thirdReadingS", aBill.getBillStateInSenate());

		aBill.modify();
		assertEquals("thirdReadingS", aBill.getBillStateInSenate());

	}
	
	
}