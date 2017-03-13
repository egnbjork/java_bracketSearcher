package berberyan;

import static org.junit.Assert.*;

import org.junit.Test;

public class BracketTester{
	
	@Test
	public void testNull(){
		boolean testCase = BracketValidator.bracketsComplete("");
		assertTrue(testCase);
	}
	
	@Test
	public void testNoMissingBrackets(){
		boolean testCase = BracketValidator.bracketsComplete("({[]})");
		assertTrue(testCase);
		
		testCase = BracketValidator.bracketsComplete("({})");
		assertTrue(testCase);
		
		testCase = BracketValidator.bracketsComplete("({}[]())");
		assertTrue(testCase);
		
		testCase = BracketValidator.bracketsComplete("({}([]))");
		assertTrue(testCase);
	}
	
	@Test
	public void testMissingOpenBrackets(){
		boolean testCase = BracketValidator.bracketsComplete("({]}()");
		assertFalse(testCase);
		
		testCase = BracketValidator.bracketsComplete("){}");
		assertFalse(testCase);
		
		testCase = BracketValidator.bracketsComplete("([{}]])");
		assertFalse(testCase);
		
		testCase = BracketValidator.bracketsComplete("({})[}");
		assertFalse(testCase);
	}
	
	@Test
	public void testMissingClosingBrackets(){
		boolean testCase = BracketValidator.bracketsComplete("({[]}(()");
		assertFalse(testCase);
		
		testCase = BracketValidator.bracketsComplete("{{}");
		assertFalse(testCase);
		
		testCase = BracketValidator.bracketsComplete("([{}])[");
		assertFalse(testCase);
		
		testCase = BracketValidator.bracketsComplete("({(})[])");
		assertFalse(testCase);
	}
	
	@Test
	public void testMissingBracketsWithSymbols(){
		boolean testCase = BracketValidator.bracketsComplete("({[this is test]}(()");
		assertFalse(testCase);
		
		testCase = BracketValidator.bracketsComplete("{this is{test}");
		assertFalse(testCase);
		
		testCase = BracketValidator.bracketsComplete("([this{}i]s test)[");
		assertFalse(testCase);
		
		testCase = BracketValidator.bracketsComplete("(this is {%(}test)[])");
		assertFalse(testCase);
	}
	
	@Test
	public void testNoMissingBracketsWithSymbols(){
		boolean testCase = BracketValidator.bracketsComplete("({[#]}this is test)");
		assertTrue(testCase);
		
		testCase = BracketValidator.bracketsComplete("(this{// is test})");
		assertTrue(testCase);
		
		testCase = BracketValidator.bracketsComplete("(this test{is}[]())");
		assertTrue(testCase);
		
		testCase = BracketValidator.bracketsComplete("({}([this is])test)");
		assertTrue(testCase);
	}
}
