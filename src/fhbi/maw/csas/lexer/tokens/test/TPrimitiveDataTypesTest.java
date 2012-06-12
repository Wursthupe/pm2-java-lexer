/**
 * 
 */
package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TPrimitiveDataTypes;

/**
 * @author Wursthupe
 *
 */
public class TPrimitiveDataTypesTest {
	
	private String expr_true, expr_false, expr_expected;
	private TPrimitiveDataTypes tpdt;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// boolean|char|byte|short|int|long|float|double
		expr_true = "  short s = 3;\n";
		
		expr_false = "  s  short s = 3;\n";
		
		expr_expected = "  short";
		
		tpdt = new TPrimitiveDataTypes();
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TPrimitiveDataTypes#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tpdt.startsWithRegex(expr_true);
		assertTrue("True expected", tpdt.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TPrimitiveDataTypes#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tpdt.startsWithRegex(expr_true));
		assertFalse("False Expression", tpdt.startsWithRegex(expr_false));
	}

}
