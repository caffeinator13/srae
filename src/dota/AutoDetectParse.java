package dota;

/** 
 * @author abhishek.bagati@gmail.com
 * This class, Auto-Detect Parser, which automatically figures out what kind of input we give, then calls the appropriate parser. 
 * the output is returned as a atring and we can use it as an input for the opennlp classes.
 *
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;


public class AutoDetectParse 
{
    public static ContentHandler autoDetectParse() throws Exception
    {
        File document = new File(Inputfile.getFileName());
        Parser parser = new AutoDetectParser();
        
        ContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        
        try {
          parser.parse(new FileInputStream(document), handler, metadata, new ParseContext());
         // System.out.println(metadata);
          
        } catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (SAXException e) {
          e.printStackTrace();
        } catch (TikaException e) {
          e.printStackTrace();
        }
       /** PrintStream console = System.out;
        File file = new File("out.txt");
        FileOutputStream fos = new FileOutputStream(file);
		PrintStream ps = new PrintStream(fos);
		System.setOut(ps);
        //System.out.println(metadata);
        //System.out.println(handler.toString());
        Opennlp.SentenceDetect(handler.toString());
        System.setOut(console);*/
		return handler;
        
        
        
        
    
     
    }
}