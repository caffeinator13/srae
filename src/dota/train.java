package dota;

/**
 * @author abhishek.bagati@gmail.com
 * write whatever you want to out.txt using this class.
 * This class takes any input file and gives the output as suitable for our training data(in sentences) into a out.txt file
 * we can use this and annotate as required for our training data * 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import opennlp.tools.util.InvalidFormatException;

/**
 * this is a duplicate of AutoDetectParse.java which can be directly used to get
 * the output into a textfile.
 */
public class train {
	public static void main(String[] args) throws Exception {

		File document = new File(Inputfile.getFileName());
		Parser parser = new AutoDetectParser();
		// '-1' is to handle unlimited content of the body.
		ContentHandler handler = new BodyContentHandler(-1);
		Metadata metadata = new Metadata();

		try {
			parser.parse(new FileInputStream(document), handler, metadata, new ParseContext());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		}
		// String[] tokens = Opennlp.Tokenize(handler.toString());
		PrintStream console = System.out;
		File file = new File("src/dota/resources/out.txt");
		FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
		// System.out.println(metadata);
		// System.out.println(handler.toString());
		// Opennlp.Tokenize(handler.toString());
		Opennlp.SentenceDetect(handler.toString());
		System.setOut(console);
		System.out.println("Done!");
	}

}
