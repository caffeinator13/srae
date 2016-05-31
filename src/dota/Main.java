package dota;
/**
 * This is the Main class!
 * @author abhishek.bagati@gmail.com
 */

import java.util.Arrays;

import org.xml.sax.ContentHandler;


public class Main {
	 public static void main( String[] args) throws Exception
	    {
		 ContentHandler handler = AutoDetectParse.autoDetectParse();
		 Opennlp.Tokenize(handler.toString());
	    String[] tokens = Opennlp.Tokenize(handler.toString());
	    Opennlp.findName(tokens);
	    Opennlp.findDate(tokens);
	    Opennlp.findPercentage(tokens);
	    Opennlp.findLocation(tokens);
	    Opennlp.findOrganization(tokens);
		Opennlp.POSTag(handler.toString());
	    Opennlp.chunk(handler.toString());
	    Opennlp.Parse(handler.toString());
	    //extracts nouns!
		System.out.println("Name : " + java.util.Arrays.toString(Opennlp.extractNoun(Opennlp.POSTagNOPerformanceMonitor(handler.toString()))));
	      
	       
	    }
 
}