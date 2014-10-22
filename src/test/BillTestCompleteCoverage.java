package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import correctedBill.CorrectedBill;

public class BillTestCompleteCoverage {

	@Test
	public void testcase1() {
		CorrectedBill aBill = new CorrectedBill();
		boolean aIsCommonsBill = true;
		aBill.setIsCommonsBill(aIsCommonsBill);
		assertTrue(aBill.getIsCommonsBill());
		//Test case 1.1
		assertTrue(aBill.isIsCommonsBill());
	}

}
