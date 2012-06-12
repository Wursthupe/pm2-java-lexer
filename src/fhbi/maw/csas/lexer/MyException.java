package fhbi.maw.csas.lexer;
public class MyException extends Exception{

	private static final long serialVersionUID = 1L;

	// Konstruktor unserer eigenen Exception
   public MyException()
    {
        // Aufruf des übergeordneten Konstruktors mit dem zu
        // erscheinenden Fehlertext
        super("No token matches the expression");
	}


}
