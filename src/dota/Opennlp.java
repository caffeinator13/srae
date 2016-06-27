package dota;

/**
 * All opennlp methods are written in this class
 * @author abhishek.bagati@gmail.com
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.cmdline.postag.POSModelLoader;
import opennlp.tools.coref.DefaultLinker;
import opennlp.tools.coref.DiscourseEntity;
import opennlp.tools.coref.Linker;
import opennlp.tools.coref.LinkerMode;
import opennlp.tools.coref.TreebankLinker;
import opennlp.tools.coref.mention.DefaultParse;
import opennlp.tools.coref.mention.Mention;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
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

	public static String[] SentenceDetect(String input) throws InvalidFormatException, IOException {
		// System.out.println("SentenceDetect");
		InputStream is = new FileInputStream("src/dota/resources/OpennlpModels/en-sent.bin");
		SentenceModel model = new SentenceModel(is);
		SentenceDetectorME sdetector = new SentenceDetectorME(model);
		String sentences[] = sdetector.sentDetect(input);
		// System.out.println(input);
		/**
		 * for(int i=0;i<sentences.length;i++){
		 * System.out.println(sentences[i]); is.close(); }
		 */
		return sentences;

	}

	public static String[] Tokenize(String input) throws InvalidFormatException, IOException {
		System.out.println("Tokenize");
		InputStream is = new FileInputStream("src/dota/resources/OpennlpModels/en-token.bin");
		TokenizerModel model = new TokenizerModel(is);
		Tokenizer tokenizer = new TokenizerME(model);
		String[] tokens = tokenizer.tokenize(input);
		/**
		 * for (String a : tokens) System.out.println(a); is.close();
		 */
		return tokens;

	}

	public static void findName(String[] input) throws IOException {
		InputStream is = new FileInputStream("src/dota/resources/OpennlpModels/en-ner-person.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		NameFinderME nameFinder = new NameFinderME(model);
		Span nameSpans[] = nameFinder.find(input);
		System.out.println("Name: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));

	}

	public static void findDate(String[] input) throws IOException {
		InputStream is = new FileInputStream("src/dota/resources/OpennlpModels/en-ner-date.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		NameFinderME nameFinder = new NameFinderME(model);
		Span nameSpans[] = nameFinder.find(input);
		System.out.println("Found Dates: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));

	}

	public static void findLocation(String[] input) throws IOException {
		InputStream is = new FileInputStream("src/dota/resources/OpennlpModels/en-ner-location.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		NameFinderME nameFinder = new NameFinderME(model);
		Span nameSpans[] = nameFinder.find(input);
		System.out.println("Found Locations: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));

	}

	public static void findOrganization(String[] input) throws IOException {
		InputStream is = new FileInputStream("src/dota/resources/OpennlpModels/en-ner-organization.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		NameFinderME nameFinder = new NameFinderME(model);
		Span nameSpans[] = nameFinder.find(input);
		System.out.println("Found Organizations: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));

	}

	public static void findPercentage(String[] input) throws IOException {
		InputStream is = new FileInputStream("src/dota/resources/OpennlpModels/sen-ner-percentage.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		NameFinderME nameFinder = new NameFinderME(model);
		Span nameSpans[] = nameFinder.find(input);
		System.out.println("Found percentages: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));

	}

	public static void findPincode(String[] input) throws IOException {
		InputStream is = new FileInputStream("src/dota/resources/OpennlpModels/en-ner-pincode.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		NameFinderME nameFinder = new NameFinderME(model);
		Span nameSpans[] = nameFinder.find(input);
		System.out.println("Found Pincode: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));

	}

	public static String findSkills(String[] input) throws IOException {
		InputStream is = new FileInputStream("src/dota/resources/CustomModels/skillsModel.bin");
		TokenNameFinderModel model = new TokenNameFinderModel(is);
		is.close();

		NameFinderME nameFinder = new NameFinderME(model);
		Span nameSpans[] = nameFinder.find(input);
		System.out.println("Found Skills: " + Arrays.toString(Span.spansToStrings(nameSpans, input)));
		String skills = Arrays.toString(Span.spansToStrings(nameSpans, input));
		return skills;

	}

	public static void POSTagger(String input) throws InvalidFormatException, IOException {
		System.out.println("POSTagger");
		POSModel model = new POSModelLoader()
				.load(new File("src/dota/resources/OpennlpModels/en-pos-maxent.bin"));
		POSTaggerME tagger = new POSTaggerME(model);
		// ObjectStream<String> lineStream = new PlainTextByLineStream(
		// new StringReader(input));

		{
			if (tagger != null) {
				// Call Sentence Detector
				String[] sentences = Opennlp.SentenceDetect(input);
				for (String sentence : sentences) {
					System.out.println("Sentence : " + sentence);
				}
				for (String sentence : sentences) {
					String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(sentence);
					String[] tags = tagger.tag(whitespaceTokenizerLine);
					for (int i = 0; i < whitespaceTokenizerLine.length; i++) {
						String word = whitespaceTokenizerLine[i].trim();
						String tag = tags[i].trim();
						System.out.println(word + ":" + tag);

					}
				}
			}
			tagger = null;
		}
	}

	@SuppressWarnings({ "deprecation", "resource" })
	public static String POSTagNOPerformanceMonitor(String input) throws IOException {
		POSModel model = new POSModelLoader().load(new File("src/dota/resources/OpennlpModels/en-pos-maxent.bin"));
		POSTaggerME tagger = new POSTaggerME(model);
		ObjectStream<String> lineStream = new PlainTextByLineStream(new StringReader(input));
		String line;

		while ((line = lineStream.read()) != null) {

			String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(line);
			String[] tags = tagger.tag(whitespaceTokenizerLine);
			POSSample output = new POSSample(whitespaceTokenizerLine, tags);
			/*** String[] tokens = Opennlp.Tokenize(input); */
			// System.out.println(whitespaceTokenizerLine.length);
			// System.out.println(tags.length);
			// System.out.println(output.toString());
			return output.toString();

		}
		return null;

	}

	@SuppressWarnings({ "deprecation", "resource" })
	public static void POSTag(String input) throws IOException {
		POSModel model = new POSModelLoader()
				.load(new File("src/dota/resources/OpennlpModels/en-pos-maxent.bin"));
		PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
		POSTaggerME tagger = new POSTaggerME(model);

		ObjectStream<String> lineStream = new PlainTextByLineStream(new StringReader(input));

		perfMon.start();
		String line;
		while ((line = lineStream.read()) != null) {

			String whitespaceTokenizerLine[] = WhitespaceTokenizer.INSTANCE.tokenize(line);
			String[] tags = tagger.tag(whitespaceTokenizerLine);
			POSSample output = new POSSample(whitespaceTokenizerLine, tags);
			System.out.println(output.toString());
			perfMon.incrementCounter();
		}
		perfMon.stopAndPrintFinalResult();

	}

	// POStagger and Chunker
	public static String[] chunk(String input) throws IOException {
		System.out.println("chunk");
		POSModel model = new POSModelLoader()
				.load(new File("src/dota/resources/OpennlpModels/en-pos-maxent.bin"));
		PerformanceMonitor perfMon = new PerformanceMonitor(System.err, "sent");
		POSTaggerME tagger = new POSTaggerME(model);
		ObjectStream<String> lineStream = new PlainTextByLineStream(new StringReader(input));

		perfMon.start();
		String line;
		String whitespaceTokenizerLine[] = null;

		String[] tags = null;
		while ((line = lineStream.read()) != null) {
			whitespaceTokenizerLine = WhitespaceTokenizer.INSTANCE.tokenize(line);
			tags = tagger.tag(whitespaceTokenizerLine);

			POSSample output = new POSSample(whitespaceTokenizerLine, tags);
			System.out.println(output.toString());
			perfMon.incrementCounter();
		}
		perfMon.stopAndPrintFinalResult();

		// chunker
		InputStream is = new FileInputStream("src/dota/resources/OpennlpModels/en-chunker.bin");
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

	public static Parse[] Parse(String input) throws IOException {
		System.out.println("Parse");
		InputStream modelIn = new FileInputStream("src/dota/resources/OpennlpModels/en-parser-chunking.bin");

		ParserModel model = new ParserModel(modelIn);
		Parser parser = ParserFactory.create(model);
		Parse[] topParses = ParserTool.parseLine(input, parser, 1);

		for (Parse p : topParses) {
			p.show();
			getPhrases(p);
		}
		System.out.println("List of Noun Parse : " + nounPhrases);
		System.out.println("List of Adjective Parse : " + adjectivePhrases);
		System.out.println("List of Verb Parse : " + verbPhrases);
		// String ParsedData = Arrays.toString(topParses);
		// System.out.println(ParsedData);
		modelIn.close();
		return topParses;

	}

	public static String[] extractNoun(String TaggedData) {
		// Split String into array of Strings whenever there is a tag that
		// starts with "._NN"
		// followed by zero, one or two more letters (like "_NNP", "_NNPS", or
		// "_NNS")
		String[] nouns = TaggedData.split("_NN\\w?\\w?\\b");
		// remove all but last word (which is the noun) in every String in the
		// array
		for (int index = 0; index < nouns.length; index++) {
			nouns[index] = nouns[index].substring(nouns[index].lastIndexOf(" ") + 1)
					// Remove all non-word characters from extracted Nouns
					.replaceAll("[^\\p{L}\\p{Nd}]", "");
		}

		return nouns;
	}

	static Set<String> nounPhrases = new HashSet<>();
	static Set<String> adjectivePhrases = new HashSet<>();
	static Set<String> verbPhrases = new HashSet<>();

	public static void getPhrases(Parse p) {
		if (p.getType().equals("NN") || p.getType().equals("NNS") || p.getType().equals("NNP")
				|| p.getType().equals("NNPS")) {
			nounPhrases.add(p.getCoveredText());
		}

		if (p.getType().equals("JJ") || p.getType().equals("JJR") || p.getType().equals("JJS")) {
			adjectivePhrases.add(p.getCoveredText());
		}

		if (p.getType().equals("VB") || p.getType().equals("VBP") || p.getType().equals("VBG")
				|| p.getType().equals("VBD") || p.getType().equals("VBN")) {
			verbPhrases.add(p.getCoveredText());
		}

		for (Parse child : p.getChildren()) {
			getPhrases(child);
		}
	}

}
