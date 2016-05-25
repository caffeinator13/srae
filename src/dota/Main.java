package dota;
/**
 * This is the Main class!
 * 
 */

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
	      // Opennlp.findPincode(tokens);
	     //   Opennlp.chunk(handler.toString());
	      //  String[] chunkedData = Opennlp.chunk(handler.toString());
	     //  // (Str.toString());
	      //  String s = chunkedData.toString();
	     //   String delims = "[NNP]";
	     //  String[] data = s.split(delims);	         
	     //  for (String q : data)
	   	//	System.out.println(q);
	      // System.out.println(data);
	       
	    }
 
}