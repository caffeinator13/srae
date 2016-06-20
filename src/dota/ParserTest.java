package dota;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.xml.sax.ContentHandler;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.Parser;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;

public class ParserTest {
 static Set<String> namePhrases = new HashSet<>();
 static Set<String> nounPhrases = new HashSet<>();
 static Set<String> adjectivePhrases = new HashSet<>();
 static Set<String> verbPhrases = new HashSet<>();
 
 
 
 public void getNounPhrases(Parse p) {
	 if (p.getType().equals("NN") ) {
         namePhrases.add(p.getCoveredText());
 } 
  if (p.getType().equals("NN") || p.getType().equals("NNS") ||  p.getType().equals("NNPS")) {
          nounPhrases.add(p.getCoveredText());
  }

  if (p.getType().equals("JJ") || p.getType().equals("JJR") || p.getType().equals("JJS")) {
      adjectivePhrases.add(p.getCoveredText());
  }
     
  if (p.getType().equals("VB") || p.getType().equals("VBP") || p.getType().equals("VBG")|| p.getType().equals("VBD") || p.getType().equals("VBN")) {
      verbPhrases.add(p.getCoveredText());
   }
     
  for (Parse child : p.getChildren()) {
          getNounPhrases(child);
  }
}
 
 
public void parserAction(String input) throws Exception {
 InputStream is = new FileInputStream("en-parser-chunking.bin");
 ParserModel model = new ParserModel(is);
 Parser parser = ParserFactory.create(model);
 Parse topParses[] = ParserTool.parseLine(input, parser, 1);
 for (Parse p : topParses){
  //p.show();
  getNounPhrases(p);
 }
}

 public static void main(String[] args) throws Exception {
	 ContentHandler handler = AutoDetectParse.autoDetectParse();
  new ParserTest().parserAction(handler.toString());
  System.out.println("List of Name Parse : "+namePhrases);
  System.out.println("List of Noun Parse : "+nounPhrases);
  System.out.println("List of Adjective Parse : "+adjectivePhrases);
  System.out.println("List of Verb Parse : "+verbPhrases);
 }
}
