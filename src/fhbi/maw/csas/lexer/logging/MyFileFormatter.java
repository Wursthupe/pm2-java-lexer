package fhbi.maw.csas.lexer.logging;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;


public class MyFileFormatter extends Formatter{

	@Override
	public String format(LogRecord record) {
		return record.getMessage()+"\n";		
	}
	

}
