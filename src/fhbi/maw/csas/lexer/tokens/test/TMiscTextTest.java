/**
 * 
 */
package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TMiscText;

/**
 * @author Wursthupe
 *
 */
public class TMiscTextTest {
	
	private String expr_true, expr_false, expr_expected;
	private TMiscText tmt;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		/*
		 * package|import|class|interface|extends|implements
		 * |public|private|protected|final|static|void|return
		 * |if|else|while|try|catch|finally|true|false
		 */
		
		expr_true = "   myMethod2(String s) {\n";
		
		expr_false = "";
		
		expr_expected = "   m";
		
		tmt = new TMiscText();
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TMiscText#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tmt.startsWithRegex(expr_true);
		assertTrue("True expected", tmt.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TMiscText#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tmt.startsWithRegex(expr_true));
		assertFalse("False Expression", tmt.startsWithRegex(expr_false));
	}

}
