package training;
/**
 * copy this code and paste it to a new class, add the resources and give the path to the files accordingly
 * input resources: sentences.txt, blentities.txt(black listed) and knownentities.txt
 * takes all the resources as input and gives the annotated sentences and the model.bin as output
 */
import java.io.File;


import opennlp.addons.modelbuilder.DefaultModelBuilderUtil;
public class CreateModel {


		/**
		 * @param args
		 * @throws Exception 
		 */
		public static void main(String[] args) throws Exception {
			/**
		     * establish a file to put sentences in
		     */
		    File sentences = new File("E:/workspace/dota/src/training/resources/CreateModel/sentences.txt");

		    /**
		     * establish a file to put your NER hits in (the ones you want to keep based on prob)
		     */
		    File knownEntities = new File("E:/workspace/dota/src/training/resources/CreateModel/knownentities.txt");

		    /**
		     * establish a BLACKLIST file to put your bad NER hits in (also can be based on prob)
		     */
		    File blacklistedentities = new File("E:/workspace/dota/src/training/resources/CreateModel/blentities.txt");

		    /**
		     * establish a file to write your annotated sentences to
		     */
		    File annotatedSentences = new File("E:/workspace/dota/src/training/resources/CreateModel/annotatedSentences.txt");

		    /**
		     * establish a file to write your model to
		     */
		    File theModel = new File("E:/workspace/dota/src/training/resources/CreateModel/Model.bin");

		    /**
		     * THIS IS WHERE THE ADDON IS GOING TO USE THE FILES (AS IS) TO CREATE A NEW MODEL. YOU SHOULD NOT HAVE TO RUN THE FIRST PART AGAIN AFTER THIS RUNS, JUST NOW PLAY WITH THE
		     * KNOWN ENTITIES AND BLACKLIST FILES AND RUN THE METHOD BELOW AGAIN UNTIL YOU GET SOME DECENT RESULTS (A DECENT MODEL OUT OF IT).
		     */
		    DefaultModelBuilderUtil.generateModel(sentences, knownEntities, blacklistedentities, theModel, annotatedSentences, "skills", 3);
		}
	}


