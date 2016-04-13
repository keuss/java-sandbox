package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 
 * @author galloisg
 * 
 * jsoup library : http://jsoup.org/
 * http://mvnrepository.com/artifact/org.jsoup/jsoup/1.7.3
 * http://stackoverflow.com/questions/12943734/jsoup-strip-all-formatting-and-link-tags-keep-text-only
 */
public class HTTPTest {
	
	private static final String USER_AGENT = "Mozilla/5.0";
	
	
	/**
	 * @param html
	 */
	private static void parseHrml(String html) {
		Document doc = Jsoup.parse(html);
		//System.out.println(doc.text());
		
		Elements elmts = doc.getElementsByClass("section");
		System.out.println("html class ...");
		System.out.println(elmts.html());
		
		
		
		for( Element elementTable : doc.select("table") )
		{
//			System.out.println(elementTable.text());
//			System.out.println();
			
			System.out.println("tab ...");
			System.out.println(elementTable.text());
			
			System.out.println("html ...");
			System.out.println(elementTable.html());
			
			Elements child = elementTable.children();
			for (Element element : child) {
				System.out.println("chlid ...");
				System.out.println(element.text());
			}
		
		}
		
//		for( Element elementTd : doc.select("td") )
//		{
//			System.out.println(elementTd.text());
//			    // eg. you can use a StringBuilder and append lines here ...
//		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Properties props = System.getProperties();
//		props.put("http.proxyHost", "fr-proxy.groupinfra.com");
//		props.put("http.proxyPort", "3128");
		
		System.out.println("Testing 1 - Send Http GET request");
		try {
			//http://10.80.136.99:32776/IOR/ping
			//http://10.80.136.99:9080/FileNet/Engine
			// other : http://10.80.136.99:9080/P8CE/Health
			String response = HTTPTest.sendGet("http://10.80.136.99:9080/FileNet/Engine");
			System.out.println(response);
			HTTPTest.parseHrml(response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// HTTP GET request
	private static String sendGet(String url) throws Exception {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		
		return response.toString();

	}
}
