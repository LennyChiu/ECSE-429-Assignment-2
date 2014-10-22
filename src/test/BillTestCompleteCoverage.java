package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import bill.Bill;

public class BillTestCompleteCoverage {

	@Test
	public void testcase1() {
		Bill aBill = new Bill();
		boolean aIsCommonsBill = true;
		aBill.setIsCommonsBill(aIsCommonsBill);
		assertTrue(aBill.getIsCommonsBill());
		//Test case 1.1
		assertTrue(aBill.isIsCommonsBill());
	}

}
