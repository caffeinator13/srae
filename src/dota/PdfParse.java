package dota;
/**
 * initially written for just parsing ODF files, but autodetectparser does a better job.
 * 
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.IOException;
import java.util.Scanner;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;


//import org.xml.sax.SAXException;

class TikaExtraction {
	
	   TikaExtraction() throws IOException, TikaException {

	      //Assume sample.txt is in your current directory		        
	      File file = new File("Example.pdf");
	      
	      //Instantiating Tika facade class
	      Tika tika = new Tika();
	      String filecontent = tika.parseToString(file);
	      System.out.println("Extracted Content: " + filecontent);
	   }		 
	}

class Typedetection {

   Typedetection() throws Exception {

      //assume example.mp3 is in your current directory
      File file = new File("example.pdf");//
      
      //Instantiating tika facade class 
      Tika tika = new Tika();
      
      //detecting the file type using detect method
      String filetype = tika.detect(file);
      System.out.println(filetype);
   }
} 

public class PdfParse {

   public static void main(final String[] args) throws Exception  {

      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      
      String fileName = Inputfile.getFileName();
      System.out.println(fileName);
      FileInputStream inputstream = new FileInputStream(new File(fileName));
      ParseContext pcontext = new ParseContext();
      new Typedetection();
      new TikaExtraction();
      
      
      
      //parsing the document using PDF parser
      PDFParser pdfparser = new PDFParser(); 
      pdfparser.parse(inputstream, handler, metadata,pcontext);
      
      //getting the content of the document
      System.out.println("Contents of the PDF :" + handler.toString());
      
      //getting metadata of the document
      System.out.println("Metadata of the PDF:");
      String[] metadataNames = metadata.names();
      
      for(String name : metadataNames) {
         System.out.println(name+ " : " + metadata.get(name));
      }
   }

public static void parse(Scanner input) {
	// TODO Auto-generated method stub
	
}



}