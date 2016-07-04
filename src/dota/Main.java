package dota;
/**
 * @author abhishek.bagati@gmail.com
 * This is the Main class!
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.xml.sax.ContentHandler;


public class Main {
	public static void main(String[] args) throws Exception {
		
		ContentHandler handler = AutoDetectParse.autoDetectParse();
		
		System.out.println("Name : " + java.util.Arrays
				.toString(Opennlp.extractNoun(Opennlp.POSTagNOPerformanceMonitor(handler.toString()))));
		// Opennlp.Tokenize(handler.toString());
		String[] tokens = Opennlp.Tokenize(handler.toString());
		//Opennlp.SentenceDetect(handler.toString());
	
		FileInputStream fstream = new FileInputStream("src/dota/resources/out.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strLine;
		while ((strLine = br.readLine()) != null) {
			String[] token = strLine.split("\\s+");
			for (String a : token) {
				// System.out.println(a);
				RegExExtracts.isEmailValid(a);
				RegExExtracts.isPhoneNumberValid(a);
			}
		}
		
		Opennlp.findOrganization(tokens);
		Opennlp.findSkills(tokens);
		findWord.experience();

		/**
		 * Opennlp.Parse(handler.toString());
		 * Opennlp.POSTagger(handler.toString()); Opennlp.findName(tokens);
		 * Opennlp.findDate(tokens); Opennlp.findPercentage(tokens);
		 * Opennlp.findLocation(tokens); Opennlp.findOrganization(tokens);
		 * Opennlp.POSTag(handler.toString());
		 * Opennlp.chunk(handler.toString()); Opennlp.Parse(handler.toString());
		 * //extracts nouns! System.out.println("Name : " +
		 * java.util.Arrays.toString(Opennlp.extractNoun(Opennlp.
		 * POSTagNOPerformanceMonitor(handler.toString()))));
		 * Opennlp.findSkills(tokens);
		 */
		// train.toText();
		// findWord.experience();
		// ExtractedEntitites.JDExtracts();
		// ExtractedEntitites.CVExtracts();
		// ExtractedEntitites.Compare();
		// train.main(args);

	}

}