package com.infosys.retailrobot;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 * 
	 * @throws IOException
	 */
	public void testApp() throws IOException {
		System.setProperty("http.proxyHost", "webproxysea.nordstrom.net");
		System.setProperty("http.proxyPort", "8181");
		String url = "http://stackoverflow.com/questions/2835505";

		Document document = Jsoup.connect(url).get();

		String question = document.select("#question .post-text").text();
		System.out.println("Question: " + question);

		Elements answerers = document.select("#answers .user-details a");
		for (Element answerer : answerers) {
			System.out.println("Answerer: " + answerer.text());
		}
	}
}
