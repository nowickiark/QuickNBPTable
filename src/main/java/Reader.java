import java.io.InputStream;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class Reader {
	
	public static void getCurrency() throws Exception {
		
		Scanner scan1 = new Scanner(System.in);
		String url = null;
		String rawResponse = null;
		System.out.print("Podaj url do œci¹gniêcia");
		url = scan1.nextLine();
		rawResponse = getResponse(url);
		
		convertToClass(rawResponse);
	}
	
	private static String getResponse(String url) throws Exception {
        URL url1 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
        connection.addRequestProperty("User-Agent", "Mozilla/4.76");
        connection.connect();
        InputStream inStream = connection.getInputStream();
        return new Scanner(inStream, "UTF-8").useDelimiter("\\Z").next();
	}
	
	private static Tabela_kursow convertToClass(String rawResponse) {
		
		JAXBContext jc;
		try {
			jc = JAXBContext.newInstance(Tabela_kursow.class);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			StreamSource streamSource = new StreamSource(new StringReader(rawResponse));
			JAXBElement<Tabela_kursow> je = unmarshaller.unmarshal(streamSource, Tabela_kursow.class);
			
			Tabela_kursow tabela_kursow = (Tabela_kursow) je.getValue();
			
			System.out.print(tabela_kursow.getNumer_tabeli());
			
			
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	} 
	
	
	
	
	
	
}
