package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TAnnotationen;

public class TAnnotationTest {
	
	private String expr_true, expr_false, expr_expected;
	private TAnnotationen tannot;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() {
		expr_true = "   @Annot blabla\nint a = 0;";
		expr_false = " s  @Annot blabla;\nint a = 0;";
		expr_expected = "   @Annot blabla\n";
		
		tannot = new TAnnotationen();
	}
	
	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TAnnotationen#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tannot.startsWithRegex(expr_true);
		assertTrue("True expected", tannot.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TAnnotationen#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tannot.startsWithRegex(expr_true));
		assertFalse("False Expression", tannot.startsWithRegex(expr_false));
	}

}