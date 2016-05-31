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
import java.io.IOException;

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
    	
    	
    	String fileName = Inputfile.getFileName();
        //System.out.println(fileName);
       
        String target = fileName;
        
        File document = new File(target);
        Parser parser = new AutoDetectParser();
        
        ContentHandler handler = new BodyContentHandler();
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
		return handler;
        
        
        //System.out.println(metadata);
        //System.out.println(handler.toString());
        //Opennlp.SentenceDetect(handler.toString());
     //  Opennlp.Tokenize(handler.toString());
    //   System.out.println(Tokens);
     //  Opennlp.findName(tokens);
 
        
       
      //  Opennlp.POSTag(handler.toString());
      //  Opennlp.chunk(handler.toString());
       
    
     
    }
}