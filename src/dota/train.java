package dota;
/**
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
 * Hello world!
 *
 */
public class train
{
    public static void main( String[] args) throws InvalidFormatException, IOException
    {
    	
        String target = "C:/Users/abhis/Desktop/Indian Baby Names ( Boys,Gilrs) (1).xls";
        File document = new File(target);
        Parser parser = new AutoDetectParser();
        
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
        PrintStream console = System.out;
        File file = new File("out.txt");
        FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
        //System.out.println(metadata);
        //System.out.println(handler.toString());
        Opennlp.SentenceDetect(handler.toString());
        System.setOut(console);
        }
    }
