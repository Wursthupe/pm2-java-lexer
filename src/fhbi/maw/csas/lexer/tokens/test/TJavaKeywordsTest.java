/**
 * 
 */
package fhbi.maw.csas.lexer.tokens.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.tokens.TJavaKeywords;

/**
 * @author Wursthupe
 *
 */
public class TJavaKeywordsTest {
	
	private String expr_true, expr_false, expr_expected;
	private TJavaKeywords tjkw;

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
		
		expr_true = "  catch (Exception e) {\n";
		
		expr_false = "s  catch (Exception e) {\n";
		
		expr_expected = "  catch";
		
		tjkw = new TJavaKeywords();
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TJavaKeywords#getExpression()}.
	 */
	@Test
	public void testGetExpression() {
		tjkw.startsWithRegex(expr_true);
		assertTrue("True expected", tjkw.getExpression().equals(expr_expected));
	}

	/**
	 * Test method for {@link fhbi.maw.csas.lexer.tokens.TJavaKeywords#startsWithRegex(java.lang.String)}.
	 */
	@Test
	public void testStartsWithRegex() {
		assertTrue("True Expression", tjkw.startsWithRegex(expr_true));
		assertFalse("False Expression", tjkw.startsWithRegex(expr_false));
	}

}
