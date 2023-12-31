package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class GettheWeather {

	public static void getWeather(weatherBean wBean) throws IOException {
		String API_KEY = "a7e238d25af91b54f6450f60a5849740";
		// Build the API call URL by adding city+country into a URL
		String URLtoSend = "http://api.openweathermap.org/data/2.5/weather?q=" + wBean.getCityStr() + ","
				+ wBean.getCountryStr() + "&APPID=" + API_KEY + "&mode=xml";

		// print and test in a browser
		System.out.println(URLtoSend);

		// Set the URL that will be sent
		URL line_api_url = new URL(URLtoSend);

		// Create a HTTP connection to sent the GET request over
		HttpURLConnection linec = (HttpURLConnection) line_api_url.openConnection();
		linec.setDoInput(true);
		linec.setDoOutput(true);
		linec.setRequestMethod("GET");

		// Make a Buffer to read the response from the API
		BufferedReader in = new BufferedReader(new InputStreamReader(linec.getInputStream()));

		// a String to temp save each line in the response
		String inputLine;

		// a String to save the full response to use later
		String ApiResponse = "";

		// loop through the whole response
		while ((inputLine = in.readLine()) != null) {

			// System.out.println(inputLine);
			// Save the temp line into the full response
			ApiResponse += inputLine;
		}
		in.close();

		// print the response
		System.out.println(ApiResponse);

		// Call a method to make a XMLdoc out of the full response
		Document doc = convertStringToXMLDocument(ApiResponse);

		// check that the XML response is OK by getting the Root element
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

		// Create a Node list that gets everything in and under the "clouds", "sun" and "speed" tag
		NodeList nList = doc.getElementsByTagName("clouds");
		NodeList nList2 = doc.getElementsByTagName("sun");
		NodeList nList3 = doc.getElementsByTagName("speed");

		// loop through the content of the tag
		for (int temp = 0; temp < nList.getLength(); temp++) {
			// Save a node of the current list id
			Node node = nList.item(temp);
		
			if (node.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement = (Element) node;
				// get the content of an attribute in element
				String XMLclouds = eElement.getAttribute("name");
				// and print it
				System.out.println(wBean.getCityStr() + " is now a " + XMLclouds);
				// save it
				wBean.setCloudsStr(XMLclouds);

			}
		}
		
		// loop through the content of the tag
		for( int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
			Node node2 = nList2.item(temp2);
			if (node2.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement2 = (Element) node2;
				// get the content of an attribute in element
				String XMLsun = eElement2.getAttribute("rise");
				String XMLsunset = eElement2.getAttribute("set");
				// and print it
				System.out.println(" Sunrise is at " + XMLsun);
				// save it
				wBean.setSunRiseStr(XMLsun);
				wBean.setSunSetStr(XMLsunset);
			}
		}
		
		// loop through the content of the tag		
		for( int temp3 = 0; temp3 < nList3.getLength(); temp3++) {
			Node node3 = nList3.item(temp3);
			if (node3.getNodeType() == Node.ELEMENT_NODE) {

				// set the current node as an Element
				Element eElement3 = (Element) node3;
				// get the content of an attribute in element
				String XMLwind = eElement3.getAttribute("name");
				// and print it
				System.out.println(" The weather is " + XMLwind);
				// save it
				wBean.setWindStr(XMLwind);
			
			}
		}
	}

	// Method the makes a XML doc out of a string, if it is in a XML format.
	private static Document convertStringToXMLDocument(String xmlString) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
