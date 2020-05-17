package javafxapplication8;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;

public class APIrequest {
	
	private static HttpURLConnection connection;
	
	public static void main(String[] args) {
		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			try {
				connection = (HttpURLConnection) url.openConnection();
				//Request setup
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				
				int status = connection.getResponseCode();
				System.out.println(status);
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				while((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();
				System.out.println(responseContent.toString());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}	catch (MalformedURLException e) {
			e.printStackTrace();
		}
		finally {
			connection.disconnect();
		}
		
	}
	
}
