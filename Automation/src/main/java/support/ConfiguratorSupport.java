package support;  

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class ConfiguratorSupport {
	static Properties props = new Properties();
	String strFileName;
	String strValue;

	public String getProperty(String strKey) {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				strValue = props.getProperty(strKey);
				in.close();
			} else
				System.out.println("File not found!");
		} catch (Exception e) {
			System.out.println(e);
		}
		return strValue;
	}

	public void setProperty(String strKey, String strValue) throws Throwable {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				//System.out.println("load"+in);
				props.load(in);
				props.setProperty(strKey, strValue);
				props.store(new FileOutputStream(strFileName), null);
				
				in.close();
			} else {
				System.out.println("File not found!");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void removeProperty(String strKey) {
		try {
			File f = new File(strFileName);
			if (f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				props.remove(strKey);
				props.store(new FileOutputStream(strFileName), null);
				in.close();
			} else
				System.out.println("File not found!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public ConfiguratorSupport(String strFileName) {
		this.strFileName = strFileName;
	}

	// return environmental details
	public static String getHostName() throws UnknownHostException {
		InetAddress addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();

		return hostname;
	}
	
	public void clean()
	{
		props.clear();
	}
}
