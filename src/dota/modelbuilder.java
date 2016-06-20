package dota;
import java.io.File;
import opennlp.addons.modelbuilder.DefaultModelBuilderUtil;

public class modelbuilder {

  public static void main(String[] args) {
    File fileOfSentences = new File("path to your sentence file");
    File fileOfNames = new File("path to your file of person names");
    File blackListFile = new File("path to your blacklist file");
    File modelOutFile = new File("E:/workspace/dota");
    File annotatedSentencesOutFile = new File("trainingdata.txt");

    DefaultModelBuilderUtil.generateModel(fileOfSentences, fileOfNames, blackListFile, modelOutFile, annotatedSentencesOutFile, "person", 3);


  }
}