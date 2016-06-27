package dota;

/**
 * @author abhishek.bagati@gmail.com
 * Experimenting with hashmaps and tables for our requirement.
 * not complete or final
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import org.xml.sax.ContentHandler;

import opennlp.tools.parser.Parse;

public class ExtractedEntitites {
	public static HashMap<String, String> jdsentencemap = new HashMap<String, String>();
	public static HashMap<String, String> cvsentencemap = new HashMap<String, String>();
	public static HashMap<String, String> jdtokensmap = new HashMap<String, String>();
	public static HashMap<String, String> cvtokensmap = new HashMap<String, String>();
	public static HashMap<String, String> jdskillsmap = new HashMap<String, String>();
	public static HashMap<String, String> cvskillsmap = new HashMap<String, String>();
	public static HashMap<String, String> jdexp = new HashMap<String, String>();
	public static HashMap<String, String> cvexp = new HashMap<String, String>();
	public static Hashtable<String, String> experience = new Hashtable<String, String>();
	public static String testword = "years";
	public static String jdexpstate;
	public static String cvexpstate;
	private static final String[] EMPTY_STRING_ARRAY = new String[0];

	public static void JDExtracts() throws Exception {

		System.out.println("Job Description");
		ContentHandler handler = AutoDetectParse.autoDetectParse();

		String[] sentences = Opennlp.SentenceDetect(handler.toString());
		// putting all the sentences from sentencedetect to a hashmap,
		// sentence detector of opennlp doesn't work that good for our case
		// as we are using resumes, sentence enders are not properly metnioned
		// in the most
		// method used in findWord.java class is optimal method.
		for (int i = 0; i < sentences.length; i++) {
			jdsentencemap.put(sentences[i], sentences[i]);
		}
		// System.out.println(jdsentencemap.get(sentences[0]));
		// System.out.println(jdsentencemap.get(sentences[1]));
		// System.out.println(jdsentencemap.get(sentences[2]));

		// splitting each sentence of the hashmap
		for (int i = 0; i < jdsentencemap.size(); i++) {
			String strLine = jdsentencemap.get(sentences[i]);
			String[] lineWords = strLine.split("\\s+");
			// and searching for the testword and getting the line
			for (int j = 1; j < lineWords.length; j++) {
				if (lineWords[j].equals(testword)) {
					System.out.println(strLine);
					jdexpstate = strLine;
					// parsing the line containing testword
					Opennlp.Parse(strLine);
					// Opennlp.chunk(strLine);
					System.out.println("required experience : " + lineWords[j - 1] + ' ' + lineWords[j]);
					// putting no.of years and 'years' into the hashtable
					jdexp.put(lineWords[j - 1], lineWords[j]);
					experience.put(lineWords[j - 1], lineWords[j]);

					break;

				}

			}
		}
		// creating the tokens hashmap
		String[] tokens = Opennlp.Tokenize(handler.toString());

		for (int i = 0; i < tokens.length; i++) {
			jdtokensmap.put(tokens[i], tokens[i]);
		}
		// applying skills model to the tokens map
		Opennlp.findSkills(tokens);
		String[] jdskills = Opennlp.Tokenize(Opennlp.findSkills(tokens));
		// for (String a : jdskills)
		// System.out.println(a);
		List<String> list = new ArrayList<String>(Arrays.asList(jdskills));
		list.removeAll(Arrays.asList(","));
		list.removeAll(Arrays.asList("["));
		list.removeAll(Arrays.asList("]"));
		jdskills = list.toArray(EMPTY_STRING_ARRAY);
		// creating the skills map of JD
		for (int i = 0; i < jdskills.length; i++) {

			jdskillsmap.put(jdskills[i], jdskills[i]);
		}
		for (int j = 0; j <= jdskillsmap.size(); j++) {

			System.out.println(jdskillsmap.get(jdskills[j]));
		}

	}

	// same process as above for the resume
	public static void CVExtracts() throws Exception {

		System.out.println("Resume");
		ContentHandler handler = AutoDetectParse.autoDetectParse();
		String[] sentences = Opennlp.SentenceDetect(handler.toString());
		for (int i = 0; i < sentences.length; i++) {
			cvsentencemap.put(sentences[i], sentences[i]);
		}

		String[] tokens = Opennlp.Tokenize(handler.toString());
		for (int i = 0; i < tokens.length; i++) {
			cvtokensmap.put(tokens[i], tokens[i]);
		}

		// System.out.println(cvsentencemap.get(sentences[0]));
		for (int i = 0; i < cvsentencemap.size(); i++) {
			String strLine = cvsentencemap.get(sentences[i]);

			String[] lineWords = strLine.split("\\s+");

			for (int j = 1; j < lineWords.length; j++) {
				if (lineWords[j].equals(testword)) {
					// System.out.println(strLine);
					cvexpstate = strLine;
					Opennlp.Parse(strLine);
					// Opennlp.chunk(strLine);
					System.out.println("person's experience : " + lineWords[j - 1] + ' ' + lineWords[j]);
					cvexp.put(lineWords[j - 1], lineWords[j]);
					experience.put(lineWords[j - 1], lineWords[j]);

					// String[] cvexp = {lineWords[j-1], lineWords[j]};

					break;

				}

			}
		}

		Opennlp.findSkills(tokens);
		String[] cvskills = Opennlp.Tokenize(Opennlp.findSkills(tokens));
		List<String> list = new ArrayList<String>(Arrays.asList(cvskills));
		list.removeAll(Arrays.asList(","));
		list.removeAll(Arrays.asList("["));
		list.removeAll(Arrays.asList("]"));
		cvskills = list.toArray(EMPTY_STRING_ARRAY);

		for (int i = 0; i < cvskills.length; i++) {

			jdskillsmap.put(cvskills[i], cvskills[i]);
		}
		for (int j = 0; j < cvskills.length; j++) {

			// System.out.println(jdskillsmap.get(cvskills[j]));
		}

	}

	// to check if the token preceeding 'years' is an integer
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		} catch (NullPointerException e) {
			return false;
		}
		// only got here if we didn't return false
		return true;
	}

	public static void main(String[] args) throws Exception {
		ExtractedEntitites.JDExtracts();
		ExtractedEntitites.CVExtracts();
		System.out.println(experience);

		// System.out.println(jdexpstate);
		/**
		 * int ej = HashMap.get(jdexp.get(ej));
		 * 
		 * if(isInteger(jdexp1.toString())){ if(isInteger(cvexp1.toString())){
		 * String jdexp = jdexp1.toString(); Integer x = Integer.valueOf(jdexp);
		 * String cvexp = jdexp1.toString(); Integer y = Integer.valueOf(cvexp);
		 * if(x>y){ System.out.println("you Don't have enough experience"); }
		 * else{ System.out.println(
		 * "you have enough experience. checking the skill set..."); } } }
		 * 
		 * 
		 * }
		 * 
		 * public static void Compare(){ /** for(int i=0; i<
		 * jdskillsmap.size();i++){ for(int j = 0; j< cvskillsmap.size();j++){
		 * if(jdskillsmap[i].equals(cvskillsmap[j])){ } } }
		 */
		for (HashMap.Entry<String, String> m : experience.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
		}
		for (Entry<String, String> entry : jdskillsmap.entrySet()) {
			if (cvskillsmap.containsKey(entry.getKey())) {
				// if the key is common to both map1 and map2, compare the
				// values
				if (entry.getValue().toString().equals(cvskillsmap.get(entry.getKey().toString()))) {
					System.out.println("common skills:" + cvskillsmap.get(entry.getKey().toString()));
				}
			}
		}

	}

}
