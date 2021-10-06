package io.abhijith.java;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
	
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.javatpoint.com/URLConnection-class");
			URLConnection urlConnection = url.openConnection();
			InputStream is = urlConnection.getInputStream();
			int i;
			while((i = is.read())!= -1) {
				System.out.print((char)i);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
