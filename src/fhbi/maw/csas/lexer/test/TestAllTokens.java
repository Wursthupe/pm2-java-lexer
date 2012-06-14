package fhbi.maw.csas.lexer.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        fhbi.maw.csas.lexer.tokens.test.TAnnotationTest.class,
        fhbi.maw.csas.lexer.tokens.test.TCharTest.class,
        fhbi.maw.csas.lexer.tokens.test.TCommentMoreTest.class,
        fhbi.maw.csas.lexer.tokens.test.TCommentOneTest.class,
        fhbi.maw.csas.lexer.tokens.test.TEndLineTest.class,
        fhbi.maw.csas.lexer.tokens.test.TJavaDocCommentTest.class,
        fhbi.maw.csas.lexer.tokens.test.TMiscTextTest.class,
        fhbi.maw.csas.lexer.tokens.test.TJavaKeywordsTest.class,
        fhbi.maw.csas.lexer.tokens.test.TPrimitiveDataTypesTest.class,
        fhbi.maw.csas.lexer.tokens.test.TStringTest.class   
        
})

public class TestAllTokens {

}
