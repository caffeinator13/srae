package dota;
/**
 * All opennlp methods are written in this class
 * 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.cmdline.PerformanceMonitor;

import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.parser.Parse;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span; 


public class Opennlp {
	// private static String token[] = tokens;
	public static void SentenceDetect(String input) throws InvalidFormatException,
	IOException {
		
// always start with a model, a model is learned from training data
InputStream is = new FileInputStream("en-sent.bin");
SentenceModel model = new SentenceModel(is);
SentenceDetectorME sdetector = new SentenceDetectorME(model);
String sentences[] = sdetector.sentDetect(input);
//System.out.println(input);
 for(int i=0;i<sentences.length;i++){
System.out.println(sentences[i]);

is.close();
} 

}
	public static String[] Tokenize(String input) throws InvalidFormatException, IOException {
		InputStream is = new FileInputStream("en-token.bin");
	 
		TokenizerModel model = new TokenizerModel(is);
	 
		Tokenizer tokenizer = new TokenizerME(model);
	 
		String[] tokens = tokenizer.tokenize(input);
	 
		for (String a : tokens)
			System.out.println(a);
	 
		is.close();
		
		return tokens;
		 
	}

	public static void findName(String[] input) throws IOException {
		InputStream is = new FileInputStream("en-ner-person.bin");
	 
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
	 
		NameFinderME nameFinder = new NameFinderME(model);
			Span nameSpans[] = nameFinder.find(input);
			System.out.println("Name: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));
			 
	}
	public static void findDate(String[] input) throws IOException {
		InputStream is = new FileInputStream("en-ner-date.bin");
	 
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
	 
		NameFinderME nameFinder = new NameFinderME(model);
		    Span nameSpans[] = nameFinder.find(input);
			System.out.println("Found Dates: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));
				
	}
	public static void findLocation(String[] input) throws IOException {
		InputStream is = new FileInputStream("en-ner-location.bin");
	 
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
	 
		NameFinderME nameFinder = new NameFinderME(model);
			Span nameSpans[] = nameFinder.find(input);
			System.out.println("Found Locations: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));
					
	}
	public static void findOrganization(String[] input) throws IOException {
		InputStream is = new FileInputStream("en-ner-organization.bin");
	 
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
	 
		NameFinderME nameFinder = new NameFinderME(model);
			Span nameSpans[] = nameFinder.find(input);
			System.out.println("Found Organizations: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));
					
	}
	public static void findPercentage(String[] input) throws IOException {
		InputStream is = new FileInputStream("en-ner-percentage.bin");
	 
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
	 
		NameFinderME nameFinder = new NameFinderME(model);
			Span nameSpans[] = nameFinder.find(input);
			System.out.println("Found percentages: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));
				
	}
	public static void findPincode(String[] input) throws IOException {
		InputStream is = new FileInputStream("en-ner-pincode.bin");
	 
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();
	 
		NameFinderME nameFinder = new NameFinderME(model);
		    Span nameSpans[] = nameFinder.find(input);
			System.out.println("Found Pincode: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));
				
	}
	public static void POSTag(String input) throws IOException {
		POSModel model = new POSModelLoader()	
			.load(new File("en-pos-maxent.bin"));
		PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
		POSTaggerME tagger = new POSTaggerME(model);
	 
		//String input = "Hi. How are you? This is Mike.";
		ObjectStream<String> lineStream = new PlainTextByLineStream(
				new StringReader(input));
	 
		perfMon.start();
		String line;
		while ((line = lineStream.read()) != null) {
	 
			String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE
					.tokenize(line);
			String[] tags = tagger.tag(whitespaceTokenizerLine);
	 
			POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
			 
			System.out.println(sample.toString());
	 
			perfMon.incrementCounter();
		}
		perfMon.stopAndPrintFinalResult();
	}
	
public static String[] chunk(String input) throws IOException {
	POSModel model = new POSModelLoader()
			.load(new File("en-pos-maxent.bin"));
	PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
	POSTaggerME tagger = new POSTaggerME(model);
 
	
	ObjectStream<String> lineStream = new PlainTextByLineStream(
			new StringReader(input));
 
	perfMon.start();
	String line;
	String whitespaceTokenizerLine[] = null;
 
	String[] tags = null;
	while ((line = lineStream.read()) != null) {
		whitespaceTokenizerLine = WhitespaceTokenizer.INSTANCE
				.tokenize(line);
		tags = tagger.tag(whitespaceTokenizerLine);
 
		POSSample sample = new POSSample(whitespaceTokenizerLine, tags);
		System.out.println(sample.toString());
			perfMon.incrementCounter();
	}
	perfMon.stopAndPrintFinalResult();
 
	// chunker
	InputStream is = new FileInputStream("en-chunker.bin");
	ChunkerModel cModel = new ChunkerModel(is);
 
	ChunkerME chunkerME = new ChunkerME(cModel);
	String result[] = chunkerME.chunk(whitespaceTokenizerLine, tags);
 
	for (String s : result)
		System.out.println(s);
 
	Span[] span = chunkerME.chunkAsSpans(whitespaceTokenizerLine, tags);
	for (Span s : span)
		System.out.println(s.toString());
	return result;
	
	
}
List<Parse> nounPhrases;
public Parse getNounPhrases(Parse p) {
    if (p.getType().equals("NP")) {
         nounPhrases.add(p);
    }
    for (Parse child : p.getChildren()) {
         getNounPhrases(child);
    }
	return p;
}

}
