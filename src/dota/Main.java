package dota;
/**
 * @author abhishek.bagati@gmail.com
 * This is the Main class!
 */

import java.util.StringTokenizer;

import org.xml.sax.ContentHandler;

import opennlp.tools.tokenize.WhitespaceTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		ContentHandler handler = AutoDetectParse.autoDetectParse();
		System.out.println("Name : " + java.util.Arrays
				.toString(Opennlp.extractNoun(Opennlp.POSTagNOPerformanceMonitor(handler.toString()))));
		// Opennlp.Tokenize(handler.toString());
		String[] tokens = Opennlp.Tokenize(handler.toString());
		for (String a : tokens)
			RegExExtracts.isEmailValid(a);
		for (String a : tokens)
			RegExExtracts.isPhoneNumberValid(a);
		/**
		 * trying to get the email id's which have '.' and '_' from a sentence
		 * 
		 * String sentences[] = Opennlp.SentenceDetect(handler.toString());
		 * for(int i=0;i<1;i++){
		 * 
		 * StringTokenizer t=new StringTokenizer(sentences[i]," =,;"); while
		 * (t.hasMoreTokens()) {
		 * 
		 * RegExExtracts.isEmailValid(sentences[i]);
		 * 
		 * //System.out.print(t.nextToken()); }
		 * 
		 * 
		 * }
		 */
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