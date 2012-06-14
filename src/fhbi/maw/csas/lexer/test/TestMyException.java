package fhbi.maw.csas.lexer.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import fhbi.maw.csas.lexer.MyException;
import fhbi.maw.csas.lexer.MyLexer;
import fhbi.maw.csas.lexer.Regex;

public class TestMyException {

	private String sourceString;
	private MyLexer lexer;

	@Before
	public void setUp() throws Exception {
		sourceString = "class X extends List implements Cloneable { \n"
				+ "/** \n" + "* JavaDoc-Kommentar\n" + "* \n"
				+ "* @author Christian Stührmann\n"
				+ "* @author Alexander Sundermann\n" + "*/\n"
				+ "public void myMethod(String s) {}\n" + "\n"
				+ "// Einzeiliger Kommentar\n"
				+ "private void myMethod2(String s) {\n" + "	int a = 17;\n"
				+ "}";
		
		lexer = new MyLexer(
			new File(".").getAbsolutePath() + "/src/fhbi/maw/csas/lexer/source.txt"
			, false);
	}

	@Test
	public void test() {
		boolean end = false;

		while (!end) {
			end = true;
			ArrayList<Regex> tempCheckList = lexer.getRegexCheckList();
			tempCheckList.remove(tempCheckList.size()-1);
			for (Regex regex : tempCheckList) {
				if (regex.startsWithRegex(sourceString)) {
					end = false;
					sourceString = sourceString.replaceFirst(
							regex.getRegexAsString(), "");
				}
			}

			if (end && !sourceString.equals("")) {
				try {
					throw new MyException();
				}
				catch (MyException e) {
					System.out.println("THROW");
					assertNotNull(e.getMessage(), e.getMessage());
				}
			}
			else if (end && sourceString.equals(""))
				fail("MyException not thrown, although Stream not empty and no token matches!");
		}
	}

}
