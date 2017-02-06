package psq.loggly.logback;

import java.io.*;
import org.slf4j.*;

/**
 * Hello world!
 *
 */
public class App {
	final static Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		App obj = new App();
		String multiLineLogs = new String("{\"message\":\"first log\n\tsecond log\n\tthird log\"}");
		logger.info(multiLineLogs);
		System.out.println("logssent :" + multiLineLogs);

		obj.write("Hello world");
	}

	public void write(String data) {
		FileWriter fw;
		try {
			fw = new FileWriter(new File("abc1//myFile.txt"));
			fw.write(data);
			fw.close();
		} catch (Exception e) {
			StringWriter stack = new StringWriter();
			e.printStackTrace(new PrintWriter(stack));
			logger.error("Caught exception " + stack.toString());
			System.out.println(stack.toString());
		}
	}
}
