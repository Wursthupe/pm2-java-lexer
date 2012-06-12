/**
 * 
 */
package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TJavaDocComment;

/**
 * @author Wursthupe
 *
 */
public class TJavaDocCommentTest {
	
	private String expr_true, expr_false, expr_expected;
	private TJavaDocComment tjdc;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		expr_true = "      /**\n"
				 + "* JavaDoc-Kommentar\n"
				 + "* \n"
				 + "* @author Christian Stührmann\n"
				 + "* @author Alexander Sundermann\n"
				 + "*/\n"
				 + "public void sadhasjkldh";
		
		expr_false = "  ff    /**\n"
				 + "* JavaDoc-Kommentar\n"
				 + "* \n"
				 + "* @author Christian Stührmann\n"
				 + "* @author Alexander Sundermann\n"
				 + "*/\n"
				 + "public void sadhasjkldh";
		
		expr_expected = "      /**\n"
				 + "* JavaDoc-Kommentar\n"
				 + "* \n"
				 + "* @author Christian Stührmann\n"
				 + "* @author Alexander Sundermann\n"
				 + "*/";
		
		tjdc = new TJavaDocComment();
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TJavaDocComment#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tjdc.startsWithRegex(expr_true);
		assertTrue("True expected", tjdc.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TJavaDocComment#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tjdc.startsWithRegex(expr_true));
		assertFalse("False Expression", tjdc.startsWithRegex(expr_false));
	}

}
