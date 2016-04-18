package Utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class IOUtils {

	public static String readFromFile(String path) {
		File f = null;
		BufferedReader bufferedReader = null;
		try {
			f = new File(path);
			if (!f.exists()) {
				return null;
			}
			bufferedReader = new BufferedReader(new FileReader(f));
			String lineStr = null;
			String resultStr = null;
			while ((lineStr = bufferedReader.readLine()) != null) {
				resultStr += lineStr;
			}
			resultStr = resultStr.substring(4);
			return resultStr == null ? null : resultStr;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public static void writeToFile(String path, String str) {
		File f = null;
		BufferedWriter bufferedWriter = null;
		try {
			f = new File(path);
			if (!f.exists()) {
				f.mkdirs();
				f.createNewFile();
			}
			bufferedWriter = new BufferedWriter(new FileWriter(f));
			bufferedWriter.write(str);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bufferedWriter != null) {
				try {
					bufferedWriter.flush();
					bufferedWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static String readFromNet(String urlpath) {
		HttpURLConnection connection = null;
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL(urlpath);
			connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.setConnectTimeout(8000);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows; U; Windows NT 5.2; en-US) AppleWebKit/534.11 (KHTML, like Gecko) Chrome/9.0.570.0 Safari/534.11");
			connection.connect();
			bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String buffStr = null;
			String resultStr = null;
			while ((buffStr = bufferedReader.readLine()) != null) {
				resultStr += buffStr;
			}
			if (resultStr != null) {
				return resultStr.substring(4);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
