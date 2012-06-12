/**
 * 
 */
package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TCommentMore;

/**
 * @author Wursthupe
 *
 */
public class TCommentMoreTest {
	
	private String expr_true, expr_false, expr_expected;
	private TCommentMore tcm;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		expr_true = "	/*\n" +
					"* Mehrzeiliger Kommentar\n" +
					"*/\n" +
					"private void";
		
		expr_false = "s	/*\n" +
					"* Mehrzeiliger Kommentar\n" +
					"*/\n" +
					"private void";
		
		expr_expected = "	/*\n" +
						"* Mehrzeiliger Kommentar\n" +
						"*/";
		
		tcm = new TCommentMore();
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TCommentMore#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tcm.startsWithRegex(expr_true);
		assertTrue("True expected", tcm.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TCommentMore#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tcm.startsWithRegex(expr_true));
		assertFalse("False Expression", tcm.startsWithRegex(expr_false));
	}

}
