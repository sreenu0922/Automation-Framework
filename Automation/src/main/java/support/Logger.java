package support;
import com.epam.reportportal.service.ReportPortal;
import org.openqa.selenium.remote.server.commandhandler.Status;
import org.testng.Reporter;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Calendar;


/**
 * Initializing Logger Class For Logging Test Event Details
 * It will be used in all User Actions for having logger details
 * for further reference.
 * 
 */
public class Logger extends PrintStream {

	final StringBuilder buf;
	final PrintStream underlying;

	public Logger(StringBuilder sb, OutputStream os, PrintStream ul) {
		super(os);
		this.buf = sb;
		this.underlying = ul;
	}

	public static Logger create(PrintStream toLog) {
		try {
			final StringBuilder sb = new StringBuilder();
			Field f = FilterOutputStream.class.getDeclaredField("out");
			f.setAccessible(true);
			OutputStream psout = (OutputStream) f.get(toLog);
			return new Logger(sb, new FilterOutputStream(psout) {
				@Override
				public void write(int b) throws IOException {
					super.write(b);
					sb.append((char) b);
				}
			}, toLog);
		} catch (NoSuchFieldException shouldNotHappen) {
		} catch (IllegalArgumentException shouldNotHappen) {
		} catch (IllegalAccessException shouldNotHappen) {
		}
		return null;
	}

	/*public static void logInfoMessageWithScreenshot(String inMessage) {
		String consoleMessage = inMessage;
		if (ConfigFileReader.ConfigProperties.SCREENSHOT_ON_PASS) {
			String screenpath = captureScreenshot("rp_screenshot");
			File screenshot = new File(screenpath);
			ReportPortal.emitLog(inMessage, "INFO", Calendar.getInstance().getTime(), screenshot);

		*//*Reporter.log(inMessage);
		if (BasePage.test != null) {
			BasePage.test.log(Status.INFO, inMessage);
		}*//*
		}
	}*/

	public static void logInfoMessage(String inMessage) {
		String consoleMessage = inMessage;
		ReportPortal.emitLog(inMessage, "DEBUG", Calendar.getInstance().getTime());
		Reporter.log(inMessage);
		/*if (BasePage.test != null) {
			BasePage.test.log(Status.INFO, inMessage);
		}*/
	}
}

